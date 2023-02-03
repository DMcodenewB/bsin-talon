package org.bsin.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationUtil {

    private static ResultSet userSet;

    public static int validate(String login, String password, Connection conn) throws SQLException{

        if(checkLoginInDatabase(login, conn)){
            String passwordHashFromDB = userSet.getString("haslo");

            if(PasswordChecker.checkPassword(password, passwordHashFromDB)){
                return 201;
            } else {
                return 401;
            }
        } else {
            return 402;
        }
    }

    private static boolean checkLoginInDatabase(String login, Connection conn) {
        try {
            String sql = "SELECT * FROM uzytkownik WHERE login LIKE ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userSet = resultSet;
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error checking user credentials: " + e.getMessage());
        }
        return false;
    }
}
