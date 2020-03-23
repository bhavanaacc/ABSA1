/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SentimentProcess;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sunsoft
 */
public class Dbconn {
 
    public Dbconn() throws SQLException {
        //initComponents();
           //Connection con;
        
    }
        public static Connection conn() throws SQLException, ClassNotFoundException{
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost/aspectmining","root","");// for local database
        
       return(con);
    
}
           
}
