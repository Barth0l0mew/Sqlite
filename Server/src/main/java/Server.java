import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    public void start () throws IOException {
        serverSocket = new ServerSocket(777);
        System.out.println("server start");
        while ( true){
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();
            System.out.println(in.readLine());
            if (message.equals("hello")) {
                System.out.println("hello from client");
                out.println("hello from server");
            }
            else if (message.equals("stop"))
                stop();

        }
    }
    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }
}
