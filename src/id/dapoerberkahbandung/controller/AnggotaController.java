/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.controller;

import id.dapoerberkahbandung.model.AnggotaModel;
import id.dapoerberkahbandung.view.AnggotaView;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dandi Ahmadin
 */
public class AnggotaController {
    private AnggotaModel model;

    public void setModel(AnggotaModel model) {
        this.model = model;
    }
    
    public void resetAnggota(AnggotaView view) throws SQLException {
        model.resetAnggota();
    }
    
    public void insertAnggota(AnggotaView view) {
        String id_anggota = view.getTxtIdAnggota().getText();
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String no_telp = view.getTxtNoTelp().getText();

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Kosong!");
        } else if (nama.length() > 50) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Lebih Dari 50 Karakter!");
        } else if (no_telp.length() > 15) {
            JOptionPane.showMessageDialog(view, "Telepon Tidak Boleh Lebih Dari 15 digit!");
        } else {
            model.setId_anggota(id_anggota);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setNo_telp(no_telp);
            
            try {
                model.insertAnggota();
                JOptionPane.showMessageDialog(view, "Anggota Berhasil Ditambahkan!");
                model.resetAnggota();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error Di Database Dengan Pesan ", throwable.getMessage()});
            }
        }    
    }
    
    public void updateAnggota(AnggotaView view) {
        
        if (view.getTabelAnggota().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silakan pilih baris data yang akan di ubah!");
            return;
        }
        
        String id_anggota = view.getTxtIdAnggota().getText();
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String no_telp = view.getTxtNoTelp().getText();

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Kosong!");
        } else if (nama.length() > 50) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Lebih Dari 50 Karakter!");
        } else if (no_telp.length() > 15) {
            JOptionPane.showMessageDialog(view, "Telepon Tidak Boleh Lebih Dari 15 digit!");
        } else {
            model.setId_anggota(id_anggota);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setNo_telp(no_telp);
            
            try {
                model.updateAnggota();
                JOptionPane.showMessageDialog(view, "Anggota Berhasil Diubah!");
                model.resetAnggota();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error Di Database Dengan Pesan ", throwable.getMessage()});
            }
        }    
    }
    
    public void deleteAnggota(AnggotaView view) {
        if (view.getTabelAnggota().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silakan pilih baris data yang akan di hapus!");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus?")== JOptionPane.OK_OPTION) {
            String id_anggota = view.getTxtIdAnggota().getText();
            model.setId_anggota(id_anggota);
       
            try {
                model.deleteAnggota();
                JOptionPane.showMessageDialog(view, "Anggota Berhasil Dihapus!");
                model.resetAnggota();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error Di Database Dengan Pesan ", throwable.getMessage()});
            }
        }
    }
    
}
