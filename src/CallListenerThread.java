import java.io.IOException;
import java.net.SocketAddress;
import java.util.Observable;

public class CallListenerThread extends Observable implements Runnable{
    private CallListener call;
    private Caller.CallStatus callStatus;
    private volatile boolean isClose;
    private Connection connection;

    public CallListenerThread(){
        start();
    }

    public CallListenerThread(String localNik){
        call.setLocalNick(localNik);
    }

    public CallListenerThread(String localNik, String localIp){
        call.setLocalNick(localNik);
        call.setLocalIp(localIp);
    }

    public SocketAddress getRemoteAddress(){
        return call.getRemoteAddress();
    }

    public SocketAddress getListenAddress(){
        return call.getListenAddress();
    }

    public String getLocalNick(){
        return call.getLocalNick();
    }

    public String getRemoteNick(){
        return call.getRemoteNick();
    }

    public boolean isBusy(){
        return call.isBusy();
    }

    public void setBusy(boolean busy){
        call.setBusy(busy);
    }

    public void setListenAddress(SocketAddress listenAddress){
       call.setListenAddress(listenAddress);
    }

    public void setLocalNick(String localNick){
        call.setLocalNick(localNick);
    }

    public void start(){
        isClose = false;
        Thread t = new Thread();
        t.start();
    }

    public Connection getConnection(){
        return connection;
    }

    public void stop(){
        isClose = true;
    }

    public void run() {
        while (true){
            try{
               connection = call.getConnection();
                if (connection != null){
                    callStatus = Caller.CallStatus.valueOf("OK");
                }
                else{
                    callStatus = Caller.CallStatus.valueOf("BUSY");
                }

            }catch (IOException e){
                System.out.println("Critical situation!");
            }
            setChanged();
            notifyObservers();
        }

    }

}
