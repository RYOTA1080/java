import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String HOST = "localhost";
    private static final int PORT = 1111;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            Socket socket = new Socket(HOST, PORT);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter writer = new PrintWriter(
                    socket.getOutputStream(),
                    true
            );

            System.out.print("Enter your nickname: ");
            String nickname = scanner.nextLine();

            writer.println(nickname);

            Thread receiveThread = new Thread(() -> {

                try {

                    String message;

                    while ((message = reader.readLine()) != null) {

                        System.out.println(message);

                    }

                } catch (IOException exception) {

                    System.out.println("Disconnected from server.");

                }

            });

            receiveThread.start();

            System.out.println("You can start chatting.");
            System.out.println("Type 'exit' to quit.");

            while (true) {

                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.println(message);

            }

            socket.close();
            scanner.close();

        } catch (IOException exception) {

            System.out.println("Unable to connect to the server.");

        }

    }

}