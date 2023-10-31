import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    public SocketServer(){
        try{
            serverSocket = new ServerSocket(10000);
            System.out.println("等待链接。。。");
            socket = serverSocket.accept();
            System.out.println("已连接");
            in = socket.getInputStream();
            out = socket.getOutputStream();
            dataInputStream = new DataInputStream(in);
            dataOutputStream = new DataOutputStream(out);
            dataOutputStream.writeUTF("Hello!");
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readUTF());
            in.close();
            out.close();
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
