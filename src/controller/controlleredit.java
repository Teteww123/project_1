/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connector.connect;

/**
 *
 * @author PC PRAKTIKUM
 */
public class controlleredit {
     // Metode untuk memperbarui data di database
    public static void update(String id, String nama, String kelas, String jenisMakanan) {
        // Query SQL untuk melakukan pembaruan data
        String sql = "UPDATE nama_tabel SET nama=?, kelas=?, jenis_makanan=? WHERE id=?";
        
        try (
            // Menggunakan try-with-resources agar sumber daya tertutup secara otomatis
            Connection con = connect.connection(); // Mendapatkan koneksi menggunakan metode connection dari connect.java
            PreparedStatement stmt = con.prepareStatement(sql);
        ) {
            // Mengatur nilai parameter pada statement SQL
            stmt.setString(1, nama);
            stmt.setString(2, kelas);
            stmt.setString(3, jenisMakanan);
            stmt.setString(4, id);
            
            // Menjalankan kueri pembaruan
            int rowsAffected = stmt.executeUpdate();
            
            // Memeriksa apakah pembaruan berhasil
            if (rowsAffected > 0) {
                System.out.println("Data berhasil diperbarui");
            } else {
                System.out.println("Gagal memperbarui data");
            }
        } catch (SQLException ex) {
            // Menangani eksepsi yang mungkin terjadi saat menjalankan kueri SQL
            ex.printStackTrace();
        }
    }}
