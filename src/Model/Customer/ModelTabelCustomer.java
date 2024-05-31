/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.makanan;

import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Malik
 */
public class ModelTabelCustomer extends AbstractTableModel {
    List<ModelCustomer> daftarmakanan;
    String kolom[] = {"ID", "Menu makanan", "Harga"};
    
    public ModelTabelCustomer(List<ModelCustomer> daftarmakanan) {
        this.daftarmakanan = daftarmakanan;
    }
    
    @Override
    public int getRowCount() {
        return daftarmakanan.size();
    }
    
    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarmakanan.get(rowIndex).getId();
            case 1:
                return daftarmakanan.get(rowIndex).getName();
            case 2:
                return daftarmakanan.get(rowIndex).getPrice();
            default:
                return null;
        }
    }
}