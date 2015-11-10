import java.net.SocketAddress;

    import java.net.*;
    import java.sql.Connection;

    public class CallListener extends java.lang.Object{
        private int localPort = 28411;
        private String localNick;
        private String remoteNick;
        private String localIp;
        private boolean busy;
        private SocketAddress remoteAddress, listenAddress;


        CallListener(){
            this.localNick=getLocalNick();
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
                //необходимо переделать консруктор класа Connection
            }
        }

        public java.lang.String getLocalNick() {
            return localNick;
        }

        public boolean isBusy() {
            return busy;
        }

        public java.net.SocketAddress getListenAddress() {
            return listenAddress;
        }

        public java.lang.String getRemoteNick() {
            return remoteNick;
        }


        public java.net.SocketAddress getRemoteAddress(){
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

        public static void main(java.lang.String args[]){

        }

    }


