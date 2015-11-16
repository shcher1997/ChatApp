import java.net.SocketAddress;
import java.util.Observable;

public class CallListenerThread extends Observable implements Runnable{
    private CallListener call;
    private volatile boolean isClose;
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
        return null;
    }

    public SocketAddress getListenAddress(){
        return call.getListenAddress();
    }

    public String getLocalNick(){
        return call.getLocalNick();
    }

    public String getRemoteNick(){
        return null;
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
        run();
    }

    public void stop(){
        isClose = true;
    }

    public void run() {

    }

}
