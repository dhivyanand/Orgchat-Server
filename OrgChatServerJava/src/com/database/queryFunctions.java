package com.database;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class queryFunctions{

    static void collectDBConf(){

        Scanner in = new Scanner(System.in);

        System.out.println("User: ");
        dbConfig.username = in.nextLine();

        System.out.println("Password: ");
        dbConfig.password = in.nextLine();

        System.out.println("Host: ");
        dbConfig.host = in.nextLine();

        System.out.println("Database: ");
        dbConfig.database = in.nextLine();        

    }

    public static boolean setupDatabase(){

        collectDBConf();        
        
        Statement s = new dbConnection().getConnection();

        	try {
        		s.executeUpdate("create table admin(name varchar(45),id varchar(45) , profile_photo blob , password varchar(45))");
        		s.executeUpdate("create table user(name varchar(45) , id varchar(45) , profile_photo blob , inbox tiny_int , password varchar(45) ) ");
        		s.executeUpdate("create table message(sender_id varchar(45) , message_type varchar(45) , message blob , topic varchar(100) , status varchar(5) , handler_id varchar(45) , sub_topic varchar(100))");
        		
        		s.close();
        		return true;
        	} catch (Exception e) {
        		return false;
		}

    }

    public static boolean alreadyExist(){

        collectDBConf();
        return false;

    }
    
    public static boolean createAdmin(){
    	
    	 Statement s = new dbConnection().getConnection();
    	 
     	try {
     		s.executeUpdate("truncate table admin");
     		s.executeUpdate("insert into admin values()");
     		
     		s.close();
     		return true;
     	} catch (Exception e) {
     		return false;
		}
    	
    }

}