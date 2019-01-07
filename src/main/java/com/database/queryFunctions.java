import java.sql.Statement;
import java.util.Scanner;

public static class queryFunctions{

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

    static boolean setupDatabase(){

        collectDBConf();        
        
        Statement s = new dbConnection.getConnection();

        //create table operations

        return false;
    }

    static boolean alreadyExist(){

        collectDBConf();
        return false;

    }

}