import java.io.IOException;

public class CommandListenerThread implements Runnable {
    private Connection connect;
    private Command lastCom;
    private volatile boolean isDisconnected;
    CommandListenerThread(){
        connect = null;
        start();
    }

    CommandListenerThread(Connection con){
        this.connect = con;
        start();
    }

    public void start(){
        isDisconnected = false;
        run();

    }

    public void stop(){
        isDisconnected = true;
    }

    public Command getLastCommand(){
        return lastCom;
    }

    public boolean isDisconnected(){
        return isDisconnected;
    }

    public void run() {
        while (!isDisconnected){
            try {
                lastCom = connect.receive();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(java.lang.String[] args){

    }
}
