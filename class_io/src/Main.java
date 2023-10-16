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
                System.out.print((char) c);
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
                outputStream.write((char)c);
            }
            System.out.println("from\n" + inFileName +"\ninto\n" + outFileName +"\nis complete");
            outputStream.flush();
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //写入操作
    public static void outStream(String fileName){
        try{
            char[] str = "this is a little test".toCharArray();
            FileOutputStream outputStream = new FileOutputStream(fileName);
            System.out.print(fileName+" is writing");
            for(char c : str){
                outputStream.write(c);
                System.out.print(".");
            }
            System.out.println();
            outputStream.close();
        }catch (IOException e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        //获取文件前缀路径，使用相对路径。
        //此方法适用于类文件
        String fileName = Objects.requireNonNull(m.getClass().getResource("test.txt")).getPath().substring(1);
        String inFileName = Objects.requireNonNull(m.getClass().getResource("in.txt")).getPath().substring(1);
        String outFileName = Objects.requireNonNull(m.getClass().getResource("ou.txt")).getPath().substring(1);
        System.out.println("<---read and write--->");
        Main.inputAndOutStream(inFileName, outFileName);
        System.out.println("\n<---only read--->");
        Main.inputStream(fileName);
        System.out.println("\n<---after write read --->");
        Main.inputStream(outFileName);
        System.out.println("\n<---process write--->");
        Main.outStream(outFileName);
        System.out.println("\n<---after process write read--->");
        Main.inputStream(outFileName);
    }
}