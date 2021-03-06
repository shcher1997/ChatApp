import javafx.application.Application;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class MainForm extends  JFrame implements Observer{
    private JPanel panel1;
    private JButton disconnectButton;
    private JButton connectButton;
    private JTextField loclog;
    private JTextField remlog;
    private JTextField remaddr;
    private JButton applyButton;
    private JButton sendButton;
    private JTextField messageField;
    private JTextArea textArea1;
    private JScrollBar scrollBar1;
    private JTable table1;
    public static String localNick;

    //private Application logicModel;


    CommandListenerThread comServer;
    CommandListenerThread comClient;
    Connection connect;
    Caller call;
    CallListener callListener;
    String[][] contact = new String[10][2];
    DefaultTableModel table_model;

    public MainForm(){
        setContentPane(panel1);
        setTitle("Incoming connection");
        setSize(700, 600);
        setVisible(true);

        String[] columnNames = {"Nick","IP"};


        Object[][] data = {
                {"Evhen","192.64.0.14"

                }
                //
        };

        //   Container c = getContentPane();
        this.table_model = new DefaultTableModel(contact, new String[]{"Nick", "IP"});
        //panel1.add(table1);
        table1 = new JTable(this.table_model);
        //  c.add(new JScrollPane(table1));




        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (connect != null) {
                    try {
                        connect.sendNickHello(MainForm.localNick);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    new Thread(new Runnable() {

                        public void run() {
                            call = new Caller(localNick, remaddr.getText());
                            try {
                                connect=call.call();
                                Socket s = call.getSocket();
                                connect.setSocket(s);
                                comClient = new CommandListenerThread(connect);
                                textArea1.setText(comClient.getLastCommand().toString()+"\n");

                                //  comClient = new CommandListenerThread(connect);

                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }

                            try {
                                connect.sendNickHello(localNick);
                                textArea1.append("Connected" + "\n");

                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
//                            comClient.start();
                        }
                    }).start();
                }
            }

        });
        disconnectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    connect.disconnect();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        remlog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                call.setRemoteNick(remlog.getText());
            }
        });

        remaddr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                call.setIp(remaddr.getText());
            }
        });

        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!messageField.getText().equals("")){
                    try {

                        //textArea1.append(messageField.getText()+"\n");

                        connect.sendMessage(messageField.getText());
                        textArea1.append(messageField.getText()+"\n");
                        messageField.setText("");

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        loclog.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '\n')
                    applyButton.doClick();
                super.keyPressed(e);
            }
        });


        applyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!loclog.getText().isEmpty()) {
                    MainForm.localNick = loclog.getText();

                    Runnable runnable = new Runnable() {
                        public void run() {
                            try {
                                callListener= new CallListener();
                                callListener.setLocalNick(MainForm.localNick);
                                comServer = new CommandListenerThread(callListener.getConnection());
                                comServer.start();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    };
                    new Thread(runnable).start();
                }
            }
        });

    }


    public static void main (String [] args){
        new MainForm();
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
