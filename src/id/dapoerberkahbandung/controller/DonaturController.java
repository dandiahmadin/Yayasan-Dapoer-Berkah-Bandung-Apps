/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.controller;

import id.dapoerberkahbandung.model.DonaturModel;
import id.dapoerberkahbandung.view.DonaturView;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dandi Ahmadin
 */
public class DonaturController {
    private DonaturModel model;

    public void setModel(DonaturModel model) {
        this.model = model;
    }
    
    public void resetDonatur(DonaturView view) throws SQLException {
        model.resetDonatur();
    }
    
    public void insertDonatur(DonaturView view) {
        String id_donatur = view.getTxtIdDonatur().getText();
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
            model.setId_donatur(id_donatur);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setNo_telp(no_telp);
            
            try {
                model.insertDonatur();
                JOptionPane.showMessageDialog(view, "Donatur Berhasil Ditambahkan!");
                model.resetDonatur();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error Di Database Dengan Pesan ", throwable.getMessage()});
            }
        }
    }
    
    public void updateDonatur(DonaturView view) {
        
        if(view.getTabelDonatur().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silakan pilih baris yang akan diubah!");
            return;
        }
        
        String id_donatur = view.getTxtIdDonatur().getText();
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
            model.setId_donatur(id_donatur);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setNo_telp(no_telp);
            
            try {
                model.updateDonatur();
                JOptionPane.showMessageDialog(view, "Donatur Berhasil Diubah!");
                model.resetDonatur();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error Di Database Dengan Pesan ", throwable.getMessage()});
            }
        }
    }
    
    public void deleteAnggota(DonaturView view) {
        if (view.getTabelDonatur().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silakan pilih baris data yang akan di hapus!");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus?")== JOptionPane.OK_OPTION) {
            String id_donatur = view.getTxtIdDonatur().getText();
            model.setId_donatur(id_donatur);
       
            try {
                model.deleteDonatur();
                JOptionPane.showMessageDialog(view, "Donatur Berhasil Dihapus!");
                model.resetDonatur();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error Di Database Dengan Pesan ", throwable.getMessage()});
            }
        }
    }
    
}
