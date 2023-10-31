import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/*
TCP/IP协议：
    应用层-->传输层-->网络层-->数据链路图-->物理层
    HTTP    TCP/UDP
 */
public class Main {
    //互联网IP地址查询
    public static void InetAddressDemo(){
        InetAddress inetAddress1 = null;
        InetAddress inetAddress2 = null;
        InetAddress[] inetAddress3 = null;
        try{
            inetAddress1 = InetAddress.getByName("www.163.com");
            inetAddress2 = InetAddress.getLocalHost();
            inetAddress3 = InetAddress.getAllByName("www.github.com");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println("hostname:" + inetAddress1.getHostName() + " IP=" + Arrays.toString(inetAddress1.getAddress()));
        System.out.println("hostname:" + inetAddress2.getHostName() + " IP=" + Arrays.toString(inetAddress2.getAddress()));
        for(InetAddress i : inetAddress3){
            System.out.println("hostname:" + i.getHostName() + " IP=" + i.getHostAddress() );
        }
    }
    //UPL测试
    public static void URLDemo() throws MalformedURLException {
        URL url = new URL("https://zhuanlan.zhihu.com/p/93029229");
        System.out.println("URL:" + url);
        System.out.println("协议名:" + url.getProtocol());
        //主机号
        System.out.println("Host:" + url.getHost());
        //端口号
        System.out.println("Post:" + url.getPort());
        //文件名
        System.out.println("File:" + url.getFile());
        //文件名相对路径
        System.out.println("Ref:" + url.getRef());
        //路径
        System.out.println("Path:" + url.getPath());
        //权限信息
        System.out.println("Authority:" + url.getAuthority());
        //使用者信息
        System.out.println("UserInfo:" + url.getUserInfo());
    }

    public static void UseURL(){
        try{
            FileWriter fileWriter = new FileWriter("output.html");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            URL url = new URL("http://www.hitwh.edu.cn/");
            InputStreamReader inputStreamReader = new InputStreamReader(url.openStream(), StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String readStr;
            while((readStr = bufferedReader.readLine()) != null){
//                System.out.println(readStr);
                printWriter.println(readStr);
            }
            bufferedReader.close();
            printWriter.close();
            fileWriter.close();
            System.out.println("over");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) throws MalformedURLException {
//        InetAddressDemo();
//        URLDemo();
        UseURL();
    }
}