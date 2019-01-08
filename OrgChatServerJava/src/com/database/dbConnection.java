package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dbConnection{

    public Statement getConnection(){

        String username = dbConfig.username;
        String password = dbConfig.password;
        String database = dbConfig.database;
        String host = dbConfig.host;

        String url = "jdbc:mysql://localhost/"+database;
        url = "jdbc:mysql://"+host+":3306/"+database+"?user="+username+"&password="+password;

        Connection connection;
        Statement statement;

        try{

            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            
            
            return statement; 

        }catch(Exception e){
        	System.out.println(e.toString());
            return null;
        }

    }

}