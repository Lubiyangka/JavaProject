import java.io.*;
import java.util.Objects;

public class Main {
    //读取操作
    public static void inputStream(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            int c = 0;
            int i = 0;
            while ((c = fileInputStream.read()) != -1) {
                i++;
                System.out.print(c);
            }
            System.out.println();
            System.out.println("文件字节数" + i);
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("文件读取异常：\n" + e.toString());
            e.printStackTrace();
        }
    }

    //读写操作
    public static void inputAndOutStream(String inFileName, String outFileName) {
        try {
            FileInputStream inputStream = new FileInputStream(inFileName);
            FileOutputStream outputStream = new FileOutputStream(outFileName);
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
            System.out.println("from\n" + inFileName + "\ninto\n" + outFileName + "\nis complete");
            outputStream.flush();
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //写入操作
    public static void outPutStream(String fileName) {
        try {
            char[] str = "this is a little test".toCharArray();
            FileOutputStream outputStream = new FileOutputStream(fileName);
            System.out.print(fileName + " is writing");
            for (char c : str) {
                outputStream.write(c);
                System.out.print(".");
            }
            System.out.println();
            outputStream.close();
        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public static void inputAndOutPutWithFilter(String inFileName, String outFileName) {
        try {
            //输入输出流，缓存区初始化
            FileInputStream fileInputStream = new FileInputStream(inFileName);
            InputStream inputStream = new BufferedInputStream(fileInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(outFileName);
            OutputStream outputStream = new BufferedOutputStream(fileOutputStream);

            int c = 0;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }

            //刷新
            outputStream.flush();

            //关闭数据流
            fileInputStream.close();
            inputStream.close();
            ;

            fileOutputStream.close();
            outputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void outputWithDataStream(String fileName) throws IOException {
        //输出流初始化
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        DataOutputStream outputStream = new DataOutputStream(fileOutputStream);

        //测试数据
        double[] prices = {19.9, 9.9, 2.9, 29.2, 29, 29};
        int[] units = {1, 2, 34, 5, 6, 7};
        String[] desc = {"Java", "Python", "C++", "C", "C#", "JS"};
        for(double i : prices){
            outputStream.writeDouble(i);
        }
        for(int i : units){
            outputStream.writeInt(i);
        }
        for(String i : desc){
            outputStream.writeUTF(i);
        }

        fileOutputStream.close();
        outputStream.close();
    }

    public static void inputStreamWithClass(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            DataInputStream inputStream = new DataInputStream(fileInputStream);
            int c = 0;
            int i = 0;
            double d=0;
            System.out.println("<---Double--->");
            while ((d = inputStream.readDouble()) != -1) {
                i++;
                System.out.println(d);
            }
            System.out.println("<---Int--->");
            while ((c = inputStream.readInt()) != -1) {
                i++;
                System.out.println(c);
            }
            System.out.println("<---String--->");
            while ((c = fileInputStream.read()) != -1) {
                i++;
                System.out.println((char)c);
            }
            System.out.println();
            System.out.println("文件字节数" + i);
            fileInputStream.close();
            inputStream.close();
        } catch (IOException e) {
            System.out.println("文件读取异常：\n" + e.toString());
            e.printStackTrace();
        }
    }

    public static void exampleNoFilter(String fileName, String inFileName, String outFileName) {
        System.out.println("<---read and write--->");
        Main.inputAndOutStream(inFileName, outFileName);
        System.out.println("\n<---only read--->");
        Main.inputStream(fileName);
        System.out.println("\n<---after write read --->");
        Main.inputStream(outFileName);
        System.out.println("\n<---process write--->");
        Main.outPutStream(outFileName);
        System.out.println("\n<---after process write read--->");
        Main.inputStream(outFileName);
    }

    public static void main(String[] args) {
        Main m = new Main();
        //获取文件前缀路径，使用相对路径。
        //此方法适用于类文件
        String fileName = Objects.requireNonNull(m.getClass().getResource("test.txt")).getPath().substring(1);
        String inFileName = Objects.requireNonNull(m.getClass().getResource("in.txt")).getPath().substring(1);
        String outFileName = Objects.requireNonNull(m.getClass().getResource("ou.txt")).getPath().substring(1);
        //无缓冲区数据处理
//        exampleNoFilter(fileName, inFileName, outFileName);
        inputAndOutPutWithFilter(inFileName, outFileName);
        try {
            outputWithDataStream(outFileName);
            inputStreamWithClass(outFileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}