/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Pegawai;
import connector.connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author HP
 */
public class DAOPegawai implements interfaceDAOPegawai{
     @Override
    public List<ModelPegawai> getAll() {
        List<ModelPegawai> listPegawai = null;
            try {
            listPegawai = new ArrayList<>();
            
            Statement statement = connect.connection().createStatement();
            
            String query = "SELECT * FROM pegawai;";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
              
                ModelPegawai hew = new ModelPegawai();
                
                hew.setId(resultSet.getInt("id"));
                hew.setNama(resultSet.getString("nama"));
                hew.setEmail(resultSet.getString("email"));
                hew.setRole(resultSet.getString("role"));
                
    
                listPegawai.add(hew);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listPegawai;
    }
}
