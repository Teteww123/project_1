/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.TambahPegawai;
import connector.connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bagus Duta Prasetya
 */
public class DAOTambahPegawai implements interfaceDAOTambahPegawai{
     @Override
    public List<ModelTambahPegawai> getAll() {
        List<ModelTambahPegawai> listPegawai = null;
            try {
            listPegawai = new ArrayList<>();
            
            Statement statement = connect.connection().createStatement();
            
            String query = "SELECT * FROM pegawai;";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
              
                ModelTambahPegawai hew = new ModelTambahPegawai();
                
                hew.setId(resultSet.getInt("id"));
                hew.setNama(resultSet.getString("nama"));
                hew.setEmail(resultSet.getString("email"));
                hew.setEmail(resultSet.getString("password"));
                hew.setRole(resultSet.getString("role"));
                
    
                listPegawai.add(hew);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listPegawai;
    }
    @Override
    public void insert(ModelTambahPegawai pegawai){
        try{
            String query = "INSERT INTO pegawai (nama, email, password,role) VALUES (?,?,?,?);";
            ModelTambahPegawai dm = new ModelTambahPegawai();
            PreparedStatement statement;
            statement = connect.connection().prepareStatement(query);
            statement.setString(1, pegawai.getNama());
            statement.setString(2, pegawai.getEmail());
            statement.setString(3, pegawai.getPasword());
            statement.setString(4, pegawai.getRole());
            statement.executeUpdate();
            
     
            
            statement.close();
        }catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }
}
