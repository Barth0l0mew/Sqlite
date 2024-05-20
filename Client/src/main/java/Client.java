import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    public void start () throws IOException {
        clientSocket = new Socket("192.168.2.162",777);
        out = new PrintWriter(clientSocket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


    }
    public void send() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input hello or stop");
        String choice = scanner.nextLine();
        out.println(choice);
        String response = in.readLine();
        System.out.println(response);
        stop();
    }
    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.start();
        client.send();
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("input query");


    }
}
