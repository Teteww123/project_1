/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import java.util.ArrayList;
import Model.Pegawai.*;
import connector.*;
import Main.pegawai;
import javax.swing.JOptionPane;
/**
 *
 * @author PC PRAKTIKUM
 */
public class controllerPegawai {
    pegawai frame;
    interfaceDAOPegawai impdatapegawai;
    List<ModelPegawai> dm;
    
    public controllerPegawai(pegawai frame){
    this.frame = frame;
    impdatapegawai = new DAOPegawai();
    dm = impdatapegawai.getAll();
    }
    public void isitabel (){
        dm = impdatapegawai.getAll();
        ModelTablePegawai mm = new ModelTablePegawai(dm);
        frame.getTabelPegawai().setModel(mm);
    }
}
