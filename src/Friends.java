import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class Friends {
    private HashMap<String,String> contacts;

    Friends () throws IOException {
        RandomAccessFile file = new RandomAccessFile(new File("Friends.txt"), "rw");
        contacts=getNicks(file);
    }

    public void rewriteFile(RandomAccessFile file, HashMap<String,String> hm)
            throws IOException {
        file.setLength(0);
        Set<String> n=hm.keySet();
        Iterator<String> itr = n.iterator();
        while (itr.hasNext()){
            file.writeUTF(itr.next());
            file.writeUTF(hm.get(itr.next()));
        }

    }

    private HashMap<String,String> getNicks(RandomAccessFile file) throws IOException {
        file.seek(0);
        HashMap<String,String> nick = new HashMap<String,String>();
        int a = file.read();
        if (a == -1) {
            return nick;
        }
        file.seek(file.getFilePointer() - 1);
        while (a != -1) {
            String n =file.readUTF();
            String ip =file.readUTF();
            nick.put(n, ip);
            a = file.read();
            file.seek(file.getFilePointer() - 1);
        }
        return nick;

    }

    public String getIP(String nick){
        String ip ;
        StringBuffer stringBufferIP = new StringBuffer("                    ");
        stringBufferIP.replace(0, nick.length(), nick);
        ip = contacts.get(stringBufferIP.toString());
        ip.replace(" ", " ");
        return ip;

    }

    public void add(String nick,String IP){
        StringBuffer stringBuffer = new StringBuffer("                    ");
        nick = nick.substring(0, 20);
        stringBuffer.replace(0, nick.length(), nick);
        StringBuffer stringBufferIP = new StringBuffer("                    ");
        IP = IP.substring(0, 20);
        stringBufferIP.replace(0, IP.length(), IP);
        contacts.put(stringBuffer.toString(), stringBufferIP.toString());
    }

}
