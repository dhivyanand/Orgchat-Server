package com.controller;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.function.EnvironmentalFunctions;
import java.net.*;
import java.sql.Statement;
import java.util.Scanner;
import java.io.*;

import com.controller.handler.*;
import com.database.dbConfig;
import com.database.dbConnection;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Control{

	public static void server(){
		int port = 9000;
		
		try{
		HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
		System.out.println("server started at " + port);
		server.createContext("/", new RootHandler());
		
		server.createContext("/adminLogin", new adminLogin());
		server.createContext("/createUser", new createUser());
		server.createContext("/deleteUser", new deleteUser());
		server.createContext("/editUser", new editUser());
		server.createContext("/listUser", new listUser());
		server.createContext("/userLogin", new userLogin());
		server.createContext("/messageToServer", new messageToServer());
		server.createContext("/syncMessages", new syncMessages());
		server.createContext("/adminMessages", new adminMessages());
		server.createContext("/addDepartment", new addDepartment());
		server.createContext("/addSubDepartment", new addSubDepartment());



		
		server.setExecutor(null);
		server.start();
		
		}catch(Exception e){
			System.out.println("Problem with System");
		}
		
	}
	
    public static void main(String args[]){
    	
        System.out.println("Org Chat Server");  

        if(EnvironmentalFunctions.setupEnvironment()){
        	if(EnvironmentalFunctions.setupAdmin()){
        		System.out.println("Admin setup is successful...");
        		
        		server();
        		
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