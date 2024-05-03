package org.example.projectjavafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static String databaseUser = "root";
    public static String databasePassword = "Zbaki+2751";
    public static String url = "jdbc:mysql://localhost:3306/user-profile";

    public Connection getConnection(){
        Connection databaseLink = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try{
                databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return databaseLink;
    }
}
