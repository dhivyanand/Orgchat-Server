package com.controller;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.function.EnvironmentalFunctions;
import java.net.*;
import java.sql.Statement;
import java.util.Scanner;
import java.io.*;

import com.database.dbConfig;
import com.database.dbConnection;

public class Control{

    public static void main(String args[]){

        System.out.println("Org Chat Server");  

        if(EnvironmentalFunctions.setupEnvironment()){
        	if(EnvironmentalFunctions.setupAdmin()){
        		
        	}
        }
        
        /*Statement s = new dbConnection().getConnection();
        try {
			s.executeUpdate("insert into message values('a','b','c','a','e','a','a')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
    }

}