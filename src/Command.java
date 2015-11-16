public class Command {
    private CommandType comType;

    static enum CommandType{ ACCEPT, DISCONNECT, MESSAGE, NICK, REJECT }

    public Command(CommandType t) {
        this.comType = t;
    }

    public String toString(){ return comType.toString(); }

}