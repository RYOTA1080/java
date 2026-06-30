import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class server {
    static ArrayList<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(2121);
        while (true) {
            Socket client = socket.accept();
            new Thread(() -> handleClient(client)).start();
        }
    }

    static void handleClient(Socket socket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String nick = in.readLine();
            clients.add(out);
            String msg;
            while ((msg = in.readLine()) != null) {
                for (PrintWriter w : clients) {
                    w.println(nick + ": " + msg);
                }
            }
        } catch (IOException e) {
            System.out.println("Клиент отключился");
        }
    }
}
