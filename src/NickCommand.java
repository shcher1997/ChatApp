
public class NickCommand extends Command{
    private boolean busy;
    private String nick;
    private String version;

    public NickCommand(String version, String nick, boolean busy){
        super(Command.CommandType.valueOf("NICK"));
        this.nick = nick;
        this.busy = busy;
        this.version = version;
    }

    public String toString(){
        if (busy)
            return version + " user " + nick + " busy";
        else
            return version + " user " + nick;
    }

    public boolean Busy() {
        return busy;
    }

    public String getNick() {
        return nick;
    }
}
