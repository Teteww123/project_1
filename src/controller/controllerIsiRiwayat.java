/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Main.CustomerSatu;
import Model.isiriwayat.*;
import java.util.List;
import java.util.ArrayList;
import connector.*;

/**
 *
 * @author Bagus Duta Prasetya
 */
public class controllerIsiRiwayat {
    CustomerSatu frame;
    interfaceDAOIsiRiwayat impdatapegawai;
    List<ModelIsiRiwayat> dm;
    
    public controllerIsiRiwayat(CustomerSatu frame){
    this.frame = frame;
    impdatapegawai = new DAOisiriwayat();
    dm = impdatapegawai.getAll();
    }
    public void insert(){
     ModelIsiRiwayat tp = new ModelIsiRiwayat();
     tp.setNama(frame.getNama().getText());
     tp.setPilihPa((String) frame.getPilihPa().getSelectedItem());
     tp.setHarga1(frame.getHarga1().getText());
     tp.setJumlah(frame.getJumlah().getText());
     tp.setTotalHarga(frame.getTotalHarga().getText());
     
     impdatapegawai.insert(tp);
}
}
