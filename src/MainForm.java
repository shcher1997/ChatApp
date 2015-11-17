import javax.swing.*;

public class MainForm extends  JFrame {
    private JPanel panel1;
    private JButton disconnectButton;
    private JButton connectButton;
    private JTextField DAppSeTextField;
    private JTextField textField2;
    private JTextField textField3;
    private JButton applyButton;
    private JButton sendButton;
    private JTextField textField4;
    private JScrollBar scrollBar1;
    private JList list1;

    public MainForm(){
        setContentPane(panel1);
        setTitle("Incoming connection");
        setSize(700,600);
        setVisible(true);
    }
    public static void main (String [] args){
        new MainForm();
    }
}
