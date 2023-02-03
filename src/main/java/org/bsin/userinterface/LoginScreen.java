package org.bsin.userinterface;

import org.bsin.utils.AuthenticationUtil;
import org.bsin.utils.DatabaseConnector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class LoginScreen implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Zaloguj");
    JButton resetButton = new JButton("Kasuj");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("Login:");
    JLabel userPasswordLabel = new JLabel("Hasło:");
    JLabel messageLabel = new JLabel();

    public LoginScreen(){

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIDField.setBounds(125,100,190,25);
        userPasswordField.setBounds(125,150,190,25);

        loginButton.setBounds(125,200,95,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225,200,90,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,370);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground( Color.pink );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
            messageLabel.setText("");
        }

        if(e.getSource()==loginButton) {
            try {
                String login = userIDField.getText();
                String password = String.valueOf(userPasswordField.getPassword());
                Connection conn = DatabaseConnector.connect();

                int exitCode = AuthenticationUtil.validate(login, password, conn);

                switch (exitCode) {
                    case (201) -> code201(login);
                    case (401) -> code401();
                    case (402) -> code402();
                    default -> {
                    }
                }
            }catch (Exception ex) {
                messageLabel.setText(ex.getMessage());
            }
        }
    }

    private void code201(String login) {
        frame.dispose();
        new WelcomePage(login);
    }
    private void code401() {
        messageLabel.setForeground(Color.red);
        messageLabel.setText("Nieprawidłowe hasło");
        messageLabel.setFont(new Font("Verdana", Font.BOLD, 12));
    }
    private void code402() {
        messageLabel.setForeground(Color.red);
        messageLabel.setText("Nie ma takiego użytkownika");
        messageLabel.setFont(new Font("Verdana", Font.BOLD, 12));
    }
}
