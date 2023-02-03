package org.bsin.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TicketUtil {
    private static final Connection conn = DatabaseConnector.connect();

    public static ResultSet getTicketSet(String login){
        ResultSet ticketSet = null;
        try{
            String sql = "SELECT nr_talon AS 'Numer talonu', wartosc AS 'Kwota' " +
                    "FROM talon INNER JOIN uzytkownik ON talon.id_uzytkownik=uzytkownik.id_uzytkownik " +
                    "WHERE uzytkownik.login LIKE ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, login);
            ticketSet = statement.executeQuery();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return ticketSet;
    }
}
