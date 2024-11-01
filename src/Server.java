import java.io.*;
import java.net.*;

public class Server extends Thread {

    Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());

            String message;
            StringBuilder sb;

            do {
                message = in.readLine();

                sb = new StringBuilder(message);
                sb.reverse();
                message = sb.toString();

                out.println(message);
            } while (!message.equals("dne"));

            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(2000);
        Socket socket;
        Server s;
        int count = 1;

        do
        {
            socket = ss.accept();
            System.out.println("Clients connected: " + count++);
            s = new Server(socket);
            s.start();
        } while (true);

    }
}