

import java.net.*;
import java.sql.Connection;

public class CallListener extends java.lang.Object{
    public static final int localPort = 28411;
    private String localNick;
    private String remoteNick;
    private String localIp;
    private boolean busy;
    private SocketAddress remoteAddress, listenAddress;

    CallListener(){
        this.localNick="localNick";
        this.localIp="127.0.0.1";
    }

    public CallListener(java.lang.String localNick) {
        this.localNick=localNick;
    }

    public CallListener(java.lang.String localNick, java.lang.String localIp) {
        this.localNick=localNick;
        this.localIp=localIp;
    }

    public Connection getConnection() throws java.io.IOException {
        if (isBusy()) {
            return null;
        }
        else {
            ServerSocket serversocket = new ServerSocket(localPort);
            Connection connection = new Connection(serversocket.accept(), localNick);
            return connection;
        }

    }
    public String getLocalIp(){
        return localIp;
    }
    public void setLocalIp (String localIp){
        this.localIp=localIp;
    }

    public String getLocalNick() {
        return localNick;
    }

    public boolean isBusy() {
        return busy;
    }

    public SocketAddress getListenAddress() {
        return listenAddress;
    }

    public String getRemoteNick() {
        return remoteNick;
    }

    public SocketAddress getRemoteAddress(){
        return remoteAddress;
    }

    public void setLocalNick(java.lang.String localNick) {
        this.localNick = localNick;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public void setListenAddress(SocketAddress listenAddress) {
        this.listenAddress = listenAddress;
    }

    public static void main(String args[]){

    }

}

