
package jdbc.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MYSQLConnUtils {
    
    public static Connection getMYSQLConnection()throws SQLException,ClassNotFoundException{
            
        String hostname = "localhost";
        String dbName ="book";
        String userName = "root";    
        String password = "199144";
        
        return getMYSQLConnection(hostname,dbName,userName,password);
    }
    public static Connection getMYSQLConnection(String hostname,String dbname,String username,String password)
            throws SQLException , ClassNotFoundException{
    
        Class.forName("com.mysql.jdbc.Driver");
        String connectionURL = "jdbc:mysql://"+hostname+":3306/"+dbname;
        
        Connection conn = DriverManager.getConnection(connectionURL, username, password);
        return conn;
    }
}

