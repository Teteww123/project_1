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
    
    
    
    
   
    


    @Override
    public List<ModelCustomer> getAll() {
        List<ModelCustomer> daftarCustomer = null;
        try{
            daftarCustomer = new ArrayList <>();
            Statement st = connect.connection().createStatement();
            String select = "SELECT * FROM makanan;";
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                ModelCustomer customer = new ModelCustomer ();
          
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("nama paket"));
            customer.setPrice(rs.getDouble("harga paket"));
           
                daftarCustomer.add(customer);
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null,ex);
        }
        return daftarCustomer;
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
