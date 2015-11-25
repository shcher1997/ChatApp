

import java.io.IOException;
import java.net.*;


public class Caller {
    private String localNick;
    private SocketAddress remoteAddress;
    private String remoteNick;
    private boolean status;
    private String ip;
    private String CallStatus;
    private Socket s;



    public Caller(){
        remoteNick = "localNick";
        ip ="127.0.0.1";
    }

    public Caller(String localNick) {
        this.localNick=localNick;
    }
    public Caller(String localNick, SocketAddress remoteAddress) {
        this.localNick=localNick;
        this.remoteAddress=remoteAddress;
    }

    public Caller(String localNick, String ip){
        this.localNick=localNick;
        this.ip=ip;
    }

    public void setRemoteNick(String remoteNick) {
        this.remoteNick = remoteNick;
    }

    public void setIp(java.lang.String ip){
        this.ip = ip;
    }

    public Socket getSocket() {
        return s;
    }
    public void setSocket(Socket s){
        this.s=s;
    }


    static enum CallStatus {
        BUSY, NO_SERVICE, NOT_ACCESSIBLE, OK, REJECTED
    }

    Connection call() throws IOException {
        s =new Socket(ip, 28411);
        Connection connection = new Connection(s);
        connection.sendNickHello(localNick);
        Command command = connection.receive();

        if (command.getClass().equals(NickCommand.class)) {

            remoteNick = ((NickCommand) command).getNick();
            return connection;

        }else{
            return null;
        }

    }

    public java.lang.String getLocalNick(){
        return localNick;
    }

    public java.net.SocketAddress getRemoteAddress(){
        return remoteAddress;
    }

    public java.lang.String getRemoteNick(){
        return remoteNick;
    }

    public String getStatus(){
        return CallStatus;
    }

    public void setLocalNick(java.lang.String localNick){
        this.localNick = localNick;
    }

    public void setRemoteAddress(java.net.SocketAddress remoteAddress){
        this.localNick = localNick;
    }

    public String toString() {
        return "Local nick: " + localNick + ", IP: " + ip + ", remote nick: " + remoteNick + ", remote address: " + remoteAddress;
    }

    public static void main(java.lang.String[] args){

    }



}


