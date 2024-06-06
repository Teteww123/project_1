/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Riwayat;
import connector.connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bagus Duta Prasetya
 */
public class DAORiwayat implements interfaceDAORiwayat{
     @Override
    public List<ModelRiwayat> getAll() {
        List<ModelRiwayat> listRiwayat = null;
            try {
            listRiwayat = new ArrayList<>();
            
            Statement statement = connect.connection().createStatement();
            
            String query = "SELECT * FROM riwayat;";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
              
                ModelRiwayat hew = new ModelRiwayat();
                
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
    
}
