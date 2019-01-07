import java.util.Scanner;
import java.sql.Statement;

public class EnvironmentalFunctions{
    
    public static void setupEnvironment(){
    
        Scanner s = new Scanner(System.in);

        System.out.println("Setup new Server <y/n>?");
        String res = s.nextLine();
        res = res.toUpperCase();

        if ( res.equals("Y") || res.equals("YES") ){

            if(queryFunctions.setupDatabase()){

                System.out.println("Environment setup is Successful\n");

            }else{

                System.out.println("Unable to setup the Database.\n");
                return;

            }
            
        }else if( res.equals("N") || res.equals("NO")){

            System.out.println("Connect to already existing Database <y/n>?");
            res = s.nextLine();
            res = res.toUpperCase();

            if( res.equals("Y") || res.equals("YES")){

                if(queryFunctions.alreadyExists()){

                    System.out.println("Connected to the Database");

                }else{

                    System.out.println("Connection Failed. Retry <y/n>?");

                    res = s.nextLine();
                    res = res.toUpperCase();

                    if( res.equals("Y") || res.equals("YES")){
                    
                        setupEnvironment();
                    
                    }else{

                        System.out.println("Bye...");
                        return;

                    }

                }

            }

        }

    }

}