/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.ait.dao.cars;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author A00261481
 */
public enum CarDao {
    
    instance;
    
    private Connection con = null;
    
    private CarDao() {
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
    
        public List<Cars> getCars() {
        List<Cars> cars = new ArrayList<Cars>();
        try
        {
            PreparedStatement pstmt = con.prepareStatement("Select * from Cars");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next())
            {
                int id = rs.getInt("id");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String mileage = rs.getString("mileage");
                String fuel = rs.getString("fuel");
                String transmission = rs.getString("transmission");
                Cars s = new Cars(id, make, model, mileage, fuel, transmission);
                cars.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cars;
    }
    
}
