import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class History extends Observable {

    private ArrayList<Message> arrayListMessages;

    History(){
        arrayListMessages = new ArrayList<Message>();
    }

    class Message {
        private String nick;
        private Date date;
        private String text;

        private ArrayList<Message> arrayListMessages;

        Message(String nick, Date date, String text) {
            this.nick = nick;
            this.text = text;
            this.date = date;
        }

        String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

    }

    public Message	getMessage(int pos){
        return arrayListMessages.get(pos);
    }

    public void	addMessage(String nick, Date date, String text){
        Message message = new Message(nick,date,text);
        arrayListMessages.add(message);
        setChanged();
        notifyObservers();
    }

    public void	addMessage(Message message){
        arrayListMessages.add(message);
        setChanged();
        notifyObservers();
    }

    public void	clear(){
        arrayListMessages.clear();
        setChanged();
        notifyObservers();
    }

}

