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
import Main.Tambahhewan;


/**
 *
 * @author PC PRAKTIKUM
 */
public class controllerTambahHewan {
    Tambahhewan frame;
    interfaceDAOHewan impdatahewan;
    List<ModelHewan> dm;
    
    public controllerTambahHewan(Tambahhewan frame){
    this.frame = frame;
    impdatahewan = new DAOHewan();
    dm = impdatahewan.getAll();
    }
    public void insert(){
     ModelHewan dm = new ModelHewan();
     dm.setNama(frame.getNama().getText());
     dm.setKelas(frame.getKelas().getText());
     dm.setJenisMakanan(frame.getJenis_mkn().getText());
     impdatahewan.insert(dm);
     
    }}
    
