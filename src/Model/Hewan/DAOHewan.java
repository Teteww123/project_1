/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Hewan;

import Model.Hewan.ModelHewan;
import Model.Hewan.interfaceDAOHewan;
import connector.connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC PRAKTIKUM
 */
public class DAOHewan implements interfaceDAOHewan {
    @Override
    public void insert(ModelHewan hewan){
        try{
            String query = "INSERT INTO hewan (nama, kelas, jenis_makanan) VALUES (?,?,?);";
            ModelHewan dm = new ModelHewan();
            PreparedStatement statement;
            statement = connect.connection().prepareStatement(query);
            statement.setString(1, hewan.getNama());
            statement.setString(2, hewan.getKelas());
            statement.setString(3, hewan.getJenisMakanan());
            
            statement.executeUpdate();
            
     
            
            statement.close();
        }catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }
    @Override
    public void update(ModelHewan hewan) {
        try {
            String query = "UPDATE hewan SET nama=?, kelas=?, jenis_makanan=? WHERE id=?;";
            
            PreparedStatement statement;
            statement = connect.connection().prepareStatement(query);
            statement.setString(1, hewan.getNama());
            statement.setString(2, hewan.getKelas());
            statement.setString(3, hewan.getJenisMakanan());
            statement.setInt(4, hewan.getId());
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM hewan WHERE id=?;";
            
            PreparedStatement statement;
            statement = connect.connection().prepareStatement(query);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelHewan> getAll() {
        List<ModelHewan> listHewan = null;
            try {
            listHewan = new ArrayList<>();
            
            Statement statement = connect.connection().createStatement();
            
            String query = "SELECT * FROM hewan;";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
              
                ModelHewan hew = new ModelHewan();
                
                hew.setId(resultSet.getInt("id"));
                hew.setNama(resultSet.getString("nama"));
                hew.setKelas(resultSet.getString("kelas"));
                hew.setJenisMakanan(resultSet.getString("jenis_makanan"));
                
    
                listHewan.add(hew);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listHewan;
    }

    @Override
    public boolean hapusData(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
