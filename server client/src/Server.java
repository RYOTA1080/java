import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
    private static final int PORT = 1111;

    private static final ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args){
        System.out.println("Server started on port" + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)){

            while (true){

                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                ClientHandler clientHandler = new ClientHandler(socket);

                synchronized (clients){
                    clients.add(clientHandler);
                }
                clientHandler.start();
            }

        } catch (IOException exception){
            System.out.println("Server error" + exception.getMessage());
        }
    }
    public static void broadcast(String message, ClientHandler sender){
        synchronized (clients){
            for (ClientHandler client : clients){
                if(client != sender){
                    client.sendMessage(message);
                }
            }
        }
    }

    public static void removeClient(ClientHandler clientHandler){
        synchronized (clients){
           clients.remove(clientHandler);
        }
    }

    static  class ClientHandler extends Thread{
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;
        private String nickname;

        public ClientHandler(Socket socket){
            this.socket = socket;

            try{
                reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                writer = new PrintWriter(
                        socket.getOutputStream(),
                        true
                );
            } catch (IOException exception){
                System.out.println("Connection error");
            }
        }
        @Override
        public void run(){
            try{
                nickname = reader.readLine();
                broadcast(nickname + " joined the chat.",this);
                String message;
                while ((message = reader.readLine()) != null){
                    String fullMessage = nickname + ":" + message;
                    System.out.println(fullMessage);
                    broadcast(fullMessage, this);
                }
            }catch (IOException exception){
                System.out.println("Client disconnected.");
            } finally {
                removeClient(this);
                broadcast(nickname +" left the chat.",this);

                try{
                    socket.close();
                } catch (IOException exception){
                }
            }
        }
        public void sendMessage(String message){
            writer.println(message);
        }
    }
}
