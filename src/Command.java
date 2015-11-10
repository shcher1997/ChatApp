public class Command {
    private CommandType comType;

    public Command(CommandType t) {
        this.comType = t;
    }

    static enum CommandType{
        ACCEPT, DISCONNECT, MESSAGE, NICK, REJECT
    }

    public String toString(){
        return comType.toString();
    }

}