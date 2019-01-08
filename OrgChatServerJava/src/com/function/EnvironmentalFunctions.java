package com.function;

import java.util.Scanner;
import java.sql.Statement;

import com.database.dbConfig;
import com.database.queryFunctions;

public class EnvironmentalFunctions{
	
	public static void getAdminDetails(){
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Admin ID: ");
		dbConfig.admin_id = s.nextLine();
		System.out.println("Admin Password: ");
		dbConfig.admin_password = s.nextLine();
		
		
	}
	
	public static boolean setupAdmin(){
		
		getAdminDetails();
		return queryFunctions.createAdmin();
		
	}
    
    public static boolean setupEnvironment(){
    
        Scanner s = new Scanner(System.in);

        System.out.println("Setup new Server <y/n>?");
        String res = s.nextLine();
        res = res.toUpperCase();

        if ( res.equals("Y") || res.equals("YES") ){

            if(queryFunctions.setupDatabase()){

                System.out.println("Environment setup is Successful\n");
                return true;

            }else{

                System.out.println("Unable to setup the Database. Bye...\n");
                return false;

            }
            
        }else if( res.equals("N") || res.equals("NO")){

            System.out.println("Connect to already existing Database <y/n>?");
            res = s.nextLine();
            res = res.toUpperCase();

            if( res.equals("Y") || res.equals("YES")){

                if(queryFunctions.alreadyExist()){

                    System.out.println("Connected to the Database");
                    return true;

                }else{

                    System.out.println("Connection Failed. Retry <y/n>?");

                    res = s.nextLine();
                    res = res.toUpperCase();

                    if( res.equals("Y") || res.equals("YES")){
                    
                        return setupEnvironment();
                    
                    }else{

                        System.out.println("Bye...");
                        return false;

                    }

                }

            } else if( res.equals("N") || res.equals("NO") ){
            	
                System.out.println("Bye...");
                return false;
            	
            }else{
            	return false;
            }

        }else{
        	return false;
        }

    }

}