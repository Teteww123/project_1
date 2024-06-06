/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.isiriwayat;
import connector.connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bagus Duta Prasetya
 */
public class DAOisiriwayat implements interfaceDAOIsiRiwayat{
     @Override
    public List<ModelIsiRiwayat> getAll() {
        List<ModelIsiRiwayat> listRiwayat = null;
            try {
            listRiwayat = new ArrayList<>();
            
            Statement statement = connect.connection().createStatement();
            
            String query = "SELECT * FROM riwayat;";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
              
                ModelIsiRiwayat hew = new ModelIsiRiwayat();
                
                hew.setId(resultSet.getInt("id"));
                hew.setNama(resultSet.getString("name"));
                hew.setPilihPa(resultSet.getString("Nama Paket"));
                hew.setHarga1(resultSet.getString("Harga Paket"));
                hew.setJumlah(resultSet.getString("Jumlah Tiket"));
                hew.setTotalHarga(resultSet.getString("Total Harga"));
                
    
                listRiwayat.add(hew);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listRiwayat;
    }
  
    @Override
    public void insert(ModelIsiRiwayat riwayat) {
            try {
        String query = "INSERT INTO riwayat (`name`, `Nama Paket`, `Harga Paket`, `Jumlah Tiket`, `Total Harga`) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement statement = connect.connection().prepareStatement(query);
        statement.setString(1, riwayat.getNama());
        statement.setString(2, riwayat.getPilihPa());
        statement.setString(3, riwayat.getHarga1());
        statement.setString(4, riwayat.getJumlah());
        statement.setString(5, riwayat.getTotalHarga());
        statement.executeUpdate();
        statement.close();
    } catch (SQLException e) {
        System.out.println("Input Failed: " + e.getLocalizedMessage());
    }

}
}
