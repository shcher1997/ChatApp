import javax.swing.*;
import java.awt.event.ActionEvent;

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
    private JTextArea textArea1;

    public MainForm(){
        setContentPane(panel1);
        setTitle("Incoming connection");
        setSize(700,600);
        setVisible(true);
        

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
