
import javax.swing.DefaultListModel;

public class FriendsView extends DefaultListModel {
    private String[] str;
    private Friends model;

    FriendsView() {

    }

    FriendsView(ServerConnection server) {
        String arr[] = server.getAllNicks();
        str = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {

            try {
                str[i] = model.toString();
                addElement(model.toString());
            } catch (NullPointerException e) {
                System.out.println("no one user online on server");
                break;
            }

        }

    }

    String[] getStr() {
        return str;
    }

}