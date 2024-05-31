/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Pegawai;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author HP
 */
public class ModelTablePegawai extends AbstractTableModel{
     List<ModelPegawai> daftarPegawai;
    
    String kolom[] = {"ID","Nama","Email","Role"};
    
    public ModelTablePegawai(List<ModelPegawai> daftarPegawai){
        this.daftarPegawai = daftarPegawai;
    }

    @Override
    public int getRowCount() {
        return daftarPegawai.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return daftarPegawai.get(rowIndex).getId();
            case 1:
                return daftarPegawai.get(rowIndex).getNama();
            case 2:
                return daftarPegawai.get(rowIndex).getEmail();
            case 3:
                return daftarPegawai.get(rowIndex).getRole();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return kolom[columnIndex];
    }

    public void removeRow(int selectedRow) {
         // Hapus baris dari daftar hewan berdasarkan indeks baris yang dipilih
    daftarPegawai.remove(selectedRow);
    
    // Memberi tahu tabel bahwa baris telah dihapus
    fireTableRowsDeleted(selectedRow, selectedRow);
    }

}
