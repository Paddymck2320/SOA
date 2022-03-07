/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.ait.dao.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author A00261481
 */
public enum BankDao {
    
     instance;
    
    private Connection con = null;
    
    private BankDao(){
            try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            con = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/SOA_DB",
                    "billy",
                    "billy"
            );
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public int deleteAllAccounts(){
        try{
            PreparedStatement pstmt = con.prepareStatement("delete * from BankAcount");
            ResultSet rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 1;
    }
    
    public ArrayList<BankAccount> getAllAccounts() throws SQLException{
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        try
        {
            PreparedStatement pstmt = con.prepareStatement("Select * from BankAccount");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next())
            {
                String branch_code = rs.getString("branch_code");
                String account_num = rs.getString("account_num");
                String cust_name = rs.getString("cust_name");
                String cust_address = rs.getString("cust_address");
                int rating = rs.getInt("cust_rating");
                float balance = rs.getFloat("balance");
                BankAccount b = new BankAccount(branch_code, account_num, cust_name, cust_address, rating, balance);
                accounts.add(b);
            } 
         }  catch (SQLException ex) {
            ex.printStackTrace();
        }
         return accounts;
    }  
    
}
