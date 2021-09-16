/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Expert
 */
public class DBConn {
    
    Driver d;
    static Connection con;
    Statement stmt;
    ResultSet rs;
    
    
    public void opencon()
    {
        try 
        {
            d = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(d);
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "hitesh");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void nonSelect(String query)
    {
        try 
        {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet select(String query)
    {
        try
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex)
        {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public void closeCon()
    {
        try 
        {
            con.close();
        } catch (SQLException ex) 
        {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
}
