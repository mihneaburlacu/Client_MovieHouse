package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Cloneable{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public Client(){}

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public String sendMessage(String msg) {
        out.println(msg);

        String resp = "";
        try {
            resp = in.readLine();
        }catch (Exception exception){
            exception.printStackTrace();
        }

        return resp;
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Client clone() {
        try {
            Client cloned = (Client) super.clone();

            return cloned;
        } catch (CloneNotSupportedException exception) {
            exception.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
