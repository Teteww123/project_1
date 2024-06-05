/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import connector.connect;

        
public class DAOCustomer implements InterfaceDAOCustomer {
    
    
   

    public List<ModelCustomer> getAll() {
        List<ModelCustomer> pl = null;
        try{
            pl = new ArrayList <ModelCustomer>();
            Statement st = connect.connection().createStatement();
            String select = "SELECT * FROM paket;";
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                ModelCustomer paket = new ModelCustomer ();
          
            paket.setId(rs.getInt("id"));
            paket.setName(rs.getString("name"));
            paket.setPrice(rs.getDouble("price"));
           
                pl.add(paket);
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null,ex);
        }
        return pl;
    }

    @Override
    public void insert(ModelCustomer mahasiswa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ModelCustomer mahasiswa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
