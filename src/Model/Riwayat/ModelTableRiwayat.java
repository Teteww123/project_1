/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Riwayat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author HP
 */
public class ModelTableRiwayat extends AbstractTableModel{
     List<ModelRiwayat> daftarRiwayat;
    
    String kolom[] = {"ID","Nama","Nama Paket","Harga Paket", "Jumlah Tiket","Total Harga" };
    
    public ModelTableRiwayat(List<ModelRiwayat> daftarRiwayat){
        this.daftarRiwayat = daftarRiwayat;
    }

    @Override
    public int getRowCount() {
        return daftarRiwayat.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return daftarRiwayat.get(rowIndex).getId();
            case 1:
                return daftarRiwayat.get(rowIndex).getNama();
            case 2:
                return daftarRiwayat.get(rowIndex).getPilihPa();
            case 3:
                return daftarRiwayat.get(rowIndex).getHarga1();
            case 4:
                return daftarRiwayat.get(rowIndex).getJumlah();
            case 5:
                return daftarRiwayat.get(rowIndex).getTotalHarga();
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
    daftarRiwayat.remove(selectedRow);
    
    // Memberi tahu tabel bahwa baris telah dihapus
    fireTableRowsDeleted(selectedRow, selectedRow);
    }

}

