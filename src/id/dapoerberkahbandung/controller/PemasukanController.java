/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.controller;

import id.dapoerberkahbandung.model.PemasukanModel;
import id.dapoerberkahbandung.view.PemasukanView;
import javax.swing.JOptionPane;
import java.sql.Date;

/**
 *
 * @author Dandi Ahmadin
 */
public class PemasukanController {
    private PemasukanModel model;
    
    public void setModel(PemasukanModel model) {
        this.model = model;
    }
    
    public void resetPemasukan(PemasukanView view) {
        model.resetPemasukan();
    }
    
    public void insertPemasukan(PemasukanView view) {
        Date tanggal = new Date(view.getDateChooser().getDate().getTime());
        String id_anggota = view.getTxtIdAnggota().getText();
        String id_donatur = view.getTxtIdDonatur().getText();
        Integer rekening = Integer.parseInt(view.getTxtRekening().getText());
        Integer uang_tunai = Integer.parseInt(view.getTxtUangTunai().getText());
        
        if (id_anggota.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Anggota Tidak Boleh Kosong!");
        } else if (id_anggota.length() > 4) {
            JOptionPane.showMessageDialog(view, "ID Anggota Tidak Boleh Lebih dari 4 karakter!");
        } else if (id_donatur.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Donatur Tidak Boleh Kosong!");
        } else if (id_donatur.length() > 4) {
            JOptionPane.showMessageDialog(view, "ID Donatur Tidak Boleh Lebih dari 4 karakter!");
        } else {
            model.setTanggal(tanggal);
            model.setId_anggota(id_anggota);
            model.setId_donatur(id_donatur);
            model.setRekening(rekening);
            model.setUang_tunai(uang_tunai);
            
            try {
                model.insertPemasukan();
                JOptionPane.showMessageDialog(view, "Pemasukan Berhasil Ditambahkan!");
                model.resetPemasukan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error Di Database Dengan Pesan ", throwable.getMessage()});
            }
        }
    }
    
    public void updatePemasukan(PemasukanView view) {
        
        if(view.getTabelPemasukan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silakan pilih baris yang akan diubah!");
            return;
        }
        Date tanggal = new Date(view.getDateChooser().getDate().getTime());
        Integer no_pemasukan = Integer.parseInt(view.getTxtNoPemasukan().getText());
        String id_anggota = view.getTxtIdAnggota().getText();
        String id_donatur = view.getTxtIdDonatur().getText();
        Integer rekening = Integer.parseInt(view.getTxtRekening().getText());
        Integer uang_tunai = Integer.parseInt(view.getTxtUangTunai().getText());
        
        if (id_anggota.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Anggota Tidak Boleh Kosong!");
        } else if (id_anggota.length() > 4) {
            JOptionPane.showMessageDialog(view, "ID Anggota Tidak Boleh Lebih dari 4 karakter!");
        } else if (id_donatur.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Donatur Tidak Boleh Kosong!");
        } else if (id_donatur.length() > 4) {
            JOptionPane.showMessageDialog(view, "ID Donatur Tidak Boleh Lebih dari 4 karakter!");
        } else {
            model.setNo_pemasukan(no_pemasukan);
            model.setTanggal(tanggal);
            model.setId_anggota(id_anggota);
            model.setId_donatur(id_donatur);
            model.setRekening(rekening);
            model.setUang_tunai(uang_tunai);
            
            try {
                model.updatePemasukan();
                JOptionPane.showMessageDialog(view, "Pemasukan Berhasil Diubah!");
                model.resetPemasukan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error Di Database Dengan Pesan ", throwable.getMessage()});
            }
        }
    }
    
    public void deletePemasukan(PemasukanView view) {
        if (view.getTabelPemasukan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silakan pilih baris data yang akan di hapus!");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus?")== JOptionPane.OK_OPTION) {
            Integer no_pemasukan = Integer.parseInt(view.getTxtNoPemasukan().getText());
            model.setNo_pemasukan(no_pemasukan);
       
            try {
                model.deletePemasukan();
                JOptionPane.showMessageDialog(view, "Pemasukan Berhasil Dihapus!");
                model.resetPemasukan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error Di Database Dengan Pesan ", throwable.getMessage()});
            }
        }
    }
}
