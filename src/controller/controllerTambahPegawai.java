/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Model.TambahPegawai.*;
import java.util.List;
import java.util.ArrayList;
import connector.*;
import Main.tambahpegawai;
/**
 *
 * @author Bagus Duta Prasetya
 */
public class controllerTambahPegawai {
    tambahpegawai frame;
    interfaceDAOTambahPegawai impdatapegawai;
    List<ModelTambahPegawai> dm;
    
    public controllerTambahPegawai(tambahpegawai frame){
    this.frame = frame;
    impdatapegawai = new DAOTambahPegawai();
    dm = impdatapegawai.getAll();
    }
    public void insert(){
     ModelTambahPegawai tp = new ModelTambahPegawai();
     tp.setNama(frame.getNama().getText());
     tp.setEmail(frame.getEmail().getText());
     tp.setPasword(frame.getPas().getText());
     tp.setRole(frame.getRole().getText());
     
     impdatapegawai.insert(tp);
}
}
