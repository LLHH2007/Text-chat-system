/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSP0007.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author LONG
 */
public class Chat extends JPanel implements Runnable {

    private JTextArea textArea;
    private JButton btnNewButton;
    private JTextArea textArea_1;
    // ______________________________
    Socket socket = null;
    String sender;
    String receiver;
    BufferedReader bf = null;
    DataOutputStream os = null;
    String str;

    @Override
    public void run() {
        while (true) {
            try {
                if (socket != null) {
                    String msg = bf.readLine();
                    while (msg != null) {
                        textArea_1.append(msg + "\n");
                        msg = bf.readLine();
                    }
                }
            } catch (Exception e) {

            }
        }
    }

    public Chat(Socket s, String sender, String receiver, String str) {
        initComponents();
        socket = s;
        this.sender = sender;
        this.receiver = receiver;
        this.str = str;
        try {

            GroupLayout groupLayout = new GroupLayout(this);
            groupLayout.setHorizontalGroup(
                    groupLayout.createParallelGroup(Alignment.LEADING)
                            .addGroup(groupLayout.createSequentialGroup().addGap(332)
                                    .addGap(339))
                            .addGroup(groupLayout
                                    .createSequentialGroup().addGap(12)
                                    .addComponent(getTextArea_1(), GroupLayout.DEFAULT_SIZE, 714,
                                            Short.MAX_VALUE)
                                    .addGap(12))
                            .addGroup(groupLayout.createSequentialGroup().addGap(12).addGroup(groupLayout
                                    .createParallelGroup(Alignment.LEADING)
                                    .addGroup(groupLayout.createSequentialGroup().addGap(168)
                                            .addGap(147))
                                    .addComponent(getTextArea(), GroupLayout.DEFAULT_SIZE, 545,
                                            Short.MAX_VALUE))
                                    .addGap(12).addComponent(getBtnNewButton(), GroupLayout.DEFAULT_SIZE,
                                    157, Short.MAX_VALUE)
                                    .addGap(12)));
            groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
                    .createSequentialGroup().addGap(6).addComponent(getTextArea_1(), GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE).addGap(1)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                            .addGroup(groupLayout.createSequentialGroup()
                                    .addComponent(getTextArea(), GroupLayout.DEFAULT_SIZE, 154,
                                            Short.MAX_VALUE))
                            .addGroup(groupLayout.createSequentialGroup().addGap(26).addComponent(
                                    getBtnNewButton(), GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                    .addGap(13)));
            bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            os = new DataOutputStream(socket.getOutputStream());

            setLayout(groupLayout);
            (new Thread(this)).start();
        } catch (Exception e) {
            System.out.println("Error while create Main Panel");
        }

        if (btnNewButton.getText().equals("START")) {
            btnNewButton.setText("SEND");
            try {
                os.writeBytes(sender + ": " + textArea.getText() + "\n");
                os.flush();
                textArea.setText("");

            } catch (Exception e) {
                System.out.println("Error while sendding messeger");
            }
            return;
        }
    }

    private void initComponents() {
    }

    public JTextArea getTextArea() {
        if (textArea == null) {
            textArea = new JTextArea();
            textArea.setFont(new Font("Arial", Font.PLAIN, 24));
        }
        return textArea;
    }

    public JButton getBtnNewButton() {
        if (btnNewButton == null) {
            btnNewButton = new JButton(str);
            btnNewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    if (btnNewButton.getText().equals("SEND") && textArea.getText().isEmpty()) {
                        return;
                    } else if (btnNewButton.getText().equals("START")) {
                        btnNewButton.setText("SEND");
                        try {
                            os.writeBytes(sender + ": " + textArea.getText() + "\n");
                            os.flush();
                            textArea.setText("");

                        } catch (Exception e) {
                            System.out.println("Error while sendding messeger");
                        }
                        return;
                    }
                    try {
                        os.writeBytes(sender + ": " + textArea.getText() + "\n");
                        os.flush();
                        textArea_1.append(sender + ": " + textArea.getText() + "\n");
                        textArea.setText("");

                    } catch (Exception e) {
                        System.out.println("Error while sendding messeger");
                    }
                }
            });
            btnNewButton.setBackground(Color.GRAY);
            btnNewButton.setForeground(Color.BLACK);
            btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        }
        return btnNewButton;
    }

    public void logout() {
        try {
            os.writeBytes(sender + " has left ");
            os.flush();
            textArea_1.append(sender + " has left");
        } catch (Exception e) {
        }

    }

    public JTextArea getTextArea_1() {
        if (textArea_1 == null) {
            textArea_1 = new JTextArea();
            textArea_1.setFont(new Font("Arial", Font.PLAIN, 14));
        }
        return textArea_1;
    }
}
