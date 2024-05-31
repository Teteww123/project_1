/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.makanan;

import java.util.List;

/**
 *
 * @author Malik
 */
public interface InterfaceDAOCustomer {
    public void insert(ModelCustomer mahasiswa);
    
    // Method untuk mengupdate (mengedit) suatu data mahasiswa
    public void update(ModelCustomer mahasiswa);
    
    // Method untuk menghapus suatu data mahasiswa
    public void delete(int id);
    
    // Method untuk mengambil data mahasiswa
    public List<ModelCustomer> getAll();
}
