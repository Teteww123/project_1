/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import Model.Hewan.DAOHewan;
import java.util.List;
import java.util.ArrayList;
import Model.Hewan.*;
import connector.*;
import Main.hewan;
import javax.swing.JOptionPane;

/**
 *
 * @author PC PRAKTIKUM
 */
public class controllerHewan {
    hewan frame;
    interfaceDAOHewan impdatahewan;
    List<ModelHewan> dm;
    
    public controllerHewan(hewan frame){
    this.frame = frame;
    impdatahewan = new DAOHewan();
    dm = impdatahewan.getAll();
    }
    public void isitabel (){
        dm = impdatahewan.getAll();
        ModelTableHewan mm = new ModelTableHewan(dm);
        frame.getTabelhewan().setModel(mm);
    }
    
    public void hapusData(int id) {
         impdatahewan.delete(id);
        
        // Refresh tampilan tabel setelah penghapusan berhasil
        isitabel();
    }
 
    public void updateData(ModelHewan hewan) {
        impdatahewan.update(hewan);
        isitabel(); // Refresh the table data
}

    
}