package org.bsin.userinterface;

import org.bsin.utils.TicketUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WelcomePage {
    JFrame frame = new JFrame();
    JPanel mainPanel = new JPanel(new BorderLayout());
    JLabel welcomeLabel = new JLabel();
    JLabel ticketLabel = new JLabel();

    JTable tickets;
    JScrollPane scrollPane;

    WelcomePage(String login){

        welcomeLabel.setFont(new Font("Arial",Font.PLAIN,20));
        welcomeLabel.setText("Witaj, " + login + "!");

        ticketLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        ticketLabel.setText("Oto twoje talony:");


        ResultSet ticketSet = TicketUtil.getTicketSet(login);
        DefaultTableModel model = new DefaultTableModel();
        int columnCount;

        try {
            columnCount = ticketSet.getMetaData().getColumnCount();
            for (int i = 0; i < columnCount; i++){
                model.addColumn(ticketSet.getMetaData().getColumnLabel(i+1));
            }
            while(ticketSet.next()){
                int nr_talon = ticketSet.getInt("Numer talonu");
                int wartosc = ticketSet.getInt("Kwota");
                Object[] rowData = new Object[]{nr_talon, wartosc};
                model.addRow(rowData);
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        tickets = new JTable(model);
        tickets.setPreferredScrollableViewportSize(new Dimension(420, 100));
        tickets.setBackground(new Color(40, 255, 50, 100));
        scrollPane = new JScrollPane(tickets);

        mainPanel.add(welcomeLabel, BorderLayout.NORTH);
        mainPanel.add(ticketLabel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);
        mainPanel.setBackground(new Color(40, 200, 100, 200));
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 370);

        frame.setVisible(true);
    }
}
