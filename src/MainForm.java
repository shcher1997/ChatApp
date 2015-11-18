import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainForm extends  JFrame {
    private JPanel panel1;
    private JButton disconnectButton;
    private JButton connectButton;
    private JTextField loclog;
    private JTextField remlog;
    private JTextField remaddr;
    private JButton applyButton;
    private JButton sendButton;
    private JTextField messageField;
    private JScrollBar scrollBar1;
    private JTextArea textArea1;

    CommandListenerThread comServer;
    CommandListenerThread comClient;
    Connection connect;
    Caller call;
    CallListener callListener;


    public MainForm(){
        setContentPane(panel1);
        setTitle("Incoming connection");
        setSize(700, 600);
        setVisible(true);
        /*loclog.setEnabled(false);
        connectButton.setEnabled(false);
        disconnectButton.setEnabled(false);
        remlog.setEnabled(false);
        remaddr.setEnabled(false);
        applyButton.setEnabled(false);
        sendButton.setEnabled(false);*/


        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (connect != null) {
                    try {
                        connect.sendNickHello(callListener.getLocalNick());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    new Thread(new Runnable() {

                        public void run() {
                            call = new Caller(callListener.getLocalNick(), remaddr.getText());
                            try {
                                connect.sendNickHello(callListener.getLocalNick());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            comClient.start();
                        }
                    }).start();
                }
            }

        });
        disconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    connect.disconnect();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        remlog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                call.setRemoteNick(remlog.getText());
            }
        });

        remaddr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                call.setIp(remaddr.getText());
            }
        });
        //this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!messageField.getText().equals("")){
                    try {
                        textArea1.append(messageField.getText()+"\n");
                        messageField.setText("");
                        connect.sendMessage(messageField.getText());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }


    public static void main (String [] args){
        new MainForm();
    }
}
