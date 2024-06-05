/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Customer;

import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Malik
 */
public class ModelTabelCustomer extends AbstractTableModel {
    List<ModelCustomer> daftarpaket;
    String kolom[] = {"ID", "Paket", "Harga"};
    
    public ModelTabelCustomer(List<ModelCustomer> daftarpaket) {
        this.daftarpaket = daftarpaket;
    }
    
    @Override
    public int getRowCount() {
        return daftarpaket.size();
    }
    
    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarpaket.get(rowIndex).getId();
            case 1:
                return daftarpaket.get(rowIndex).getName();
            case 2:
                return daftarpaket.get(rowIndex).getPrice();
            default:
                return null;
        }
    }
}