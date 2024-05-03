package org.example.projectjavafx;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "user-project";
        String databaseUser = "root";
        String databasePassword = "Zbaki+2751";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}
