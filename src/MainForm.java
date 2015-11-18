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
    private JTextField textField4;
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

        connectButton.setEnabled(false);
        disconnectButton.setEnabled(false);
        loclog.setEnabled(false);
        remaddr.setEnabled(false);
        applyButton.setEnabled(false);
        sendButton.setEnabled(false);


        connectButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(connect != null){
                    try {
                        connect.sendNickHello(callListener.getLocalNick());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                else{
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



    /*    sendButton.addActionListener(ActionEvent e){


        }*/
    }


    /*
    try {
					if (!messageArea.getText().equals("")) {
						connection.sendMessage(messageArea.getText());
						model.addMessage(nickField.getText(), new Date(), messageArea.getText());

						textArea.update(model, new Object());
						messageArea.setText("");

					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
     */

    public static void main (String [] args){
        new MainForm();
    }
}
