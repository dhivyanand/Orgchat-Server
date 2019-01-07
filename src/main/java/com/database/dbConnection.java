import java.sql.Connection;
import java.sql.Statement;

public class dbConnection{

    protected Statement getConnection(){

        String username = dbConfig.username;
        String password = dbConfig.password;
        String database = dbConfig.database;
        String host = dbConfig.host;

        String url = "jdbc:mysql://localhost/"+database;

        Connection connection;
        Statement statement;

        try{

            connection = DriverManager.getConnection(host, username, password);
            statement = connection.createStatement();
            
            return statement; 

        }catch(Exception e){
            return null;
        }

    }

}