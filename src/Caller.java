
import java.io.IOException;
import java.net.*;
import java.sql.Connection;


public class Caller {
    private String localNick;
    private SocketAddress remoteAddress;
    private String RemoteNick;
    private boolean status;
    private String ip;




    public Caller(){
        this.localNick=getLocalNick();
        this.remoteAddress=getRemoteAddress();
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
        Socket socket = null;
        socket.connect(new InetSocketAddress(ip, 8882));
        return call = new Connection(socket);
        // if (status) {
        //   return call = new Connection(socket);
        // }
    }

    public java.lang.String getLocalNick(){
        return localNick;
    }

    public java.net.SocketAddress getRemoteAddress(){
        return remoteAddress;
    }

    public java.lang.String getRemoteNick(){
        return RemoteNick;
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

    // public java.lang.String toString(){

    //  }

    public static void main(java.lang.String[] args){

    }



}

