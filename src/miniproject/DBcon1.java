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
public class DBcon1 {
    
    public static void main(String arr[])
    {
        try 
        {
            
            //Step 1 Register the Driver
            Driver d = new oracle.jdbc.driver.OracleDriver();
            DriverManager.deregisterDriver(d);
           
            //Step 2 Get connection
            
            Connection con = DriverManager.getConnection("jdbd:oracle:thin:@localhost:1521:xe", "system", "hitesh");
            DatabaseMetaData dbmd = con.getMetaData();
           // dbmd.getDriverName();
           System.out.println("\n"+"DATABASEMETADATA"+"\n");
           System.out.println("Driver Name: "+ dbmd.getDriverName());
           System.out.println("Driver minimum Verstion: "+dbmd.getDriverMinorVersion());
           System.out.println("Driver Major Version: "+dbmd.getDriverMajorVersion());
           System.out.println("Driver Product Name : "+dbmd.getDatabaseProductName());
           
           //Step 3 Create Statement
           Statement stmt = con.createStatement();
           
           //Exceute the Querry
           ResultSet rs = stmt.executeQuery("select * from studinfo");
           
           ResultSetMetaData rsmd = rs.getMetaData();
           System.out.println("\n"+"RESULTSETMETADATA"+"\n");
           System.out.println("Column count: "+rsmd.getColumnCount());
           for(int i=1;i<rsmd.getColumnCount();i++)
           {
               System.out.println("Coloumn Name: "+rsmd.getColumnName(i));
               System.out.println("Column Type: "+rsmd.getColumnTypeName(i));
           }
           
           //step 5 Close the connnection
           
           con.close();
           
           
           
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(DBcon1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
