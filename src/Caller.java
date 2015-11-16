
import java.io.IOException;
import java.net.*;
import java.sql.Connection;


public class Caller {
    private String localNick;
    private SocketAddress remoteAddress;
    private String remoteNick;
    private boolean status;
    private String ip;




    public Caller(){
        remoteNick = "localNick";
        ip ="127.0.0.1";
    }

    public Caller(java.lang.String localNick) {
        this.localNick=localNick;
    }
    public Caller(java.lang.String localNick, java.net.SocketAddress remoteAddress) {
        this.localNick=localNick;
        this.remoteAddress=remoteAddress;
    }

    public Caller(java.lang.String localNick, java.lang.String ip){
        this.localNick=localNick;
        this.ip=ip;
    }

    private static enum CallStatus {
        BUSY, NO_SERVICE, NOT_ACCeSIBLE, OK, REJECTED
    }

    Connection call(Connection call) throws IOException {
        try {
            Socket socket = new Socket();
            socket.connect(this.remoteAddress);
            Connection connection = new Connection(socket);
            return connection;
        } catch (IOException e) {
            e.printStackTrace();
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

    public Caller.CallStatus getStatus(){
        return status;
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

