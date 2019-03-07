package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class model {
    
    public Statement getStmt(){
        // connect to database
        Connection con = null;
        Statement stmt = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/sakila", "root", "");                       
            stmt = con.createStatement();         
            
        } catch (Exception e) {
            //System.out.println("error conn");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } 
        return stmt;
    }
    
}
