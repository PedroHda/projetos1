package consultorio;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Banco 
{
   private Connection con;
   private String host = "jdbc:mysql://localhost:3307/";
   private String user = "root";
   private String password = "";

    public Banco(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           this.con = (Connection) DriverManager.getConnection(host,user,password);
           Statement comando = (Statement) this.con.createStatement();
           comando.executeQuery("use database consultorio;");

        }catch(Exception e){
           
        }

    }
    public Connection getConnection(){
        return this.con;
    }
}