
import java.io.IOException;
import java.net.*;



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

    public static enum CallStatus {
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

    public Caller.CallStatus getStatus(){///don't sure
   // return status;
        return null;
    }

    public void setLocalNick(String localNick){
        this.localNick = localNick;
    }

    public void setRemoteAddress(SocketAddress remoteAddress){
        this.localNick = localNick;
    }

    public String toString() {
        return "Local nick: " + localNick + ", IP: " + ip + ", remote nick: " + remoteNick + ", remote address: " + remoteAddress;
    }

    public static void main(String[] args){

    }



}

