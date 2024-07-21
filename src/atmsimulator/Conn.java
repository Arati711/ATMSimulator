
package atmsimulator;


import java.sql.*;


public class Conn {
    Connection c;
    Statement s;
    
    public Conn(){
    
       try{
          
            c = DriverManager.getConnection("jdbc:mysql:///atmsimulator", "root","Arati");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
}
}
