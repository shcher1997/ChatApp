import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {
    private ServerSocket ss;
    private Socket socket;
    private final static int PORT = 28411;
    private final static String CODING = "UTF-8";
    DataInputStream in;
    DataOutputStream out;

    public Connection(Socket s) throws IOException {
        this.socket = s;
       // in = new DataInputStream(s.getInputStream());
      //  out = new DataOutputStream(s.getOutputStream());

    }
    
    public ServerSocket getSs() {
        return ss;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSs(ServerSocket ss) {
        this.ss = ss;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean isOpen(){
        return socket!=null;
    }

    public void sendNickHello( String nick) throws IOException { //
        socket.getOutputStream().write(("ChatApp 2015 user "+ nick + "\n").getBytes(CODING));
    }

    public void sendNickBusy(String nick) throws IOException{
        socket.getOutputStream().write(("ChatApp 2015 user " + nick + "busy\n").getBytes(CODING));
    }

    public void accept() throws IOException {//прийняти з"єднання
       // socket = ss.accept();
        socket.getOutputStream().write(("Accepted\n").getBytes(CODING));
    }

    public void reject() throws IOException{
        socket.getOutputStream().write(("Rejected\n").getBytes(CODING));
    }

    public void sendMessage(String mes) throws IOException {
        socket.getOutputStream().write(("Message\n").getBytes(CODING));
        socket.getOutputStream().write(mes.getBytes());
    }

    public void disconnect() throws IOException {
        socket.getOutputStream().write(("Disconnect\n").getBytes(CODING));
    }

    public void close() throws IOException {
        socket.shutdownInput();
        socket.shutdownOutput();
        socket.close();
    }
   //add Command receive
    //main
}
