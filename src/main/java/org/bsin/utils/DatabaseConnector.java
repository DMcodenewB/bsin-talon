package org.bsin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    static String url = "jdbc:mariadb://localhost:3306/bsin";
    static String user = "root";
    static String pass = "181960";

    public static Connection conn;

    public static Connection connect(){
        if(conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, pass);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }
}
