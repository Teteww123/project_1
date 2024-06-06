/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Main.CustomerSatu;
import java.util.List;
import Main.Riwayat;
import Model.Riwayat.*;
import connector.*;

/**
 *
 * @author Malik
 */
public class controllerRiwayat {
    Riwayat frame;
    interfaceDAORiwayat impriwayat;
    List<ModelRiwayat> dm;
    
    public controllerRiwayat(Riwayat frame){
    this.frame = frame;
    impriwayat = new DAORiwayat();
    dm = impriwayat.getAll();
    }
    public void isitabel (){
        dm = impriwayat.getAll();
        ModelTableRiwayat mm = new ModelTableRiwayat(dm);
        frame.getTabelRi().setModel(mm);
    }
}
