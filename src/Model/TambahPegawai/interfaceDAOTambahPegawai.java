/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.TambahPegawai;
import java.util.List;

/**
 *
 * @author Bagus Duta Prasetya
 */
public interface interfaceDAOTambahPegawai {
    public List<ModelTambahPegawai>getAll();

    public void insert(ModelTambahPegawai dm);
}
