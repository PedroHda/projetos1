package consultorio;

// Imports
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*
    This class connects has all database utilities
*/
public class Banco 
{
    // Members
    private Connection con;
    /*   Local host is using port 3307, it can be changeable, 
     *   depending on the port available in system
     */
    private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String password = "";

    // Constructor
    public Banco(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           this.con = (Connection) DriverManager.getConnection(host,user,password);
           Statement comando = (Statement) this.con.createStatement();
           comando.executeQuery("use database consultorio;");

        }catch(Exception e){ 
            // Not treated
         }
    }
    
    // Getters and Setters
    public Connection getConnection(){
        return this.con;
    }
}