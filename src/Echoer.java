import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {

    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            while (true){
                System.out.println("Client connected");
                String echoString = input.readLine();
                if (echoString.equals("exit")){
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("oops "+ e.getMessage());
        }finally {
            try{
                socket.close();
            }catch  (IOException e){

            }
        }
    }
}
