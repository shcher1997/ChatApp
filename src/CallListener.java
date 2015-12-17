/**
 * Created by ���� on 01.11.2015.
 */

import java.io.IOException;
import java.net.*;


public class CallListener extends java.lang.Object{
    public static final int localPort = 28411;
    private String localNick;
    static String remoteNick;
    private String localIp;
    private boolean busy;
    private SocketAddress remoteAddress, listenAddress;

    CallListener(){
        this.localNick=localNick;
        this.localIp="127.0.0.1";
    }

    public CallListener(String localNick) {
        this.localNick=localNick;
    }

    public CallListener(String localNick, String localIp) {
        this.localNick=localNick;
        this.localIp=localIp;
    }

    public Connection getConnection() throws IOException {
        if (isBusy()) {
            return null;
        }
        else {
            ServerSocket serversocket = new ServerSocket(localPort);
            Socket socket = serversocket.accept();
            Connection connection = new Connection(socket);
            return connection;
        }

    }

    public java.lang.String getLocalNick() {
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

    public void setLocalNick(String localNick) {
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

    public void setLocalIp(String localIp) {
        this.localIp = localIp;
    }
}