import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Connection {
    private ServerSocket ss;
    private Socket socket;
    private final static int PORT = 28411;
    private final static String CODING = "UTF-8";
    DataInputStream in;
    DataOutputStream out;
    private static final char nextL = '\n';



    public Connection(Socket s) throws IOException {
        this.socket = s;
        in = new DataInputStream(s.getInputStream());
        out = new DataOutputStream(s.getOutputStream());

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
        out.write(("ChatApp 2015 user "+ nick + "\n").getBytes(CODING));

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
        out.write(("MESSAGE\n").getBytes(CODING));
        out.write(mes.getBytes(CODING));
        
    }

    public void disconnect() throws IOException {
        socket.getOutputStream().write(("Disconnect\n").getBytes(CODING));
    //    socket.close();        //закр сокет MainForm
        close();    //!!!!!!!!
    }

    public void close() throws IOException {
        socket.shutdownInput();
        socket.shutdownOutput();
        socket.close();
    }

    public Command receive() throws IOException{
        StringBuffer sb = new StringBuffer();
        char ch;
      //  Command command;
        while((ch=(char)in.readByte())!=nextL)
            sb.append(ch);
        String str = sb.toString();
        if(str.toUpperCase().startsWith("CHATAPP 2015 USER")){
            Scanner sc = new Scanner(str);
            String a,b,c,d;
            a= sc.next();
            b = sc.next();
            c = sc.next();
            d = sc.next();
            return new NickCommand(b,d,str.toUpperCase().endsWith("BUSY"));
        }else if("MESSAGE".equalsIgnoreCase(str)){
               sb = new StringBuffer();
            while ((ch = (char)in.readByte())!=nextL)
                sb.append(ch);
            return new MessageCommand(sb.toString());
         /*   Scanner sc = new Scanner(System.in);
            str = sc.next();
            return new MessageCommand(str.toString());*/
        }else if (str.toUpperCase().lastIndexOf("ED")>-1)
            str = str.toUpperCase().replace("ED","");


        return new Command(Command.CommandType.valueOf(str));
    }



}
