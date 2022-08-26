package cop2805;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CCulpFinalServer {
    public static void main(String[] args) {
        ServerSocket connectSocket = null;
        boolean shutdown = false;

        try {
            connectSocket = new ServerSocket(1337);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        while (!shutdown) {
            Socket clientConnection;
            InputStream rawInput;
            OutputStream rawOutput;

            try {
                clientConnection = connectSocket.accept();
                rawInput = clientConnection.getInputStream();
                rawOutput = clientConnection.getOutputStream();

                DataInputStream input = new DataInputStream(rawInput);
                DataOutputStream output = new DataOutputStream(rawOutput);

                int fibPlaceToFind = input.readInt();
                if (fibPlaceToFind == 999) {
                    shutdown = true;
                } else {
                    output.writeInt(fibSequencer(fibPlaceToFind));
                    input.close();
                    output.close();
                    clientConnection.close();
                }

            } catch(IOException e){
                e.printStackTrace();
            }
        }
        System.out.println("System Exiting...");
        System.exit(-1);

    }

    public static int fibSequencer(int place) {
        int a = 0, b = 1, c;

        if (place == 0) {
            return a;
        }
        for (int i = 2; i <= place; ++i) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }


}
