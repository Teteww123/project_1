/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Hewan;

/**
 *
 * @author HP
 */
import java.util.List;

public interface interfaceDAOHewan {
    public void insert(ModelHewan hewan);
    public void update(ModelHewan hewan);
    public void delete(int id);
    
    public List<ModelHewan>getAll();

    public boolean hapusData(String id);
}
