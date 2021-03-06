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
        String id_anggota = view.getComboBoxAnggota().getSelectedItem().toString();
        String id_donatur = view.getComboBoxDonatur().getSelectedItem().toString();
        
        Integer rekening = null;
        if(view.getTxtRekening().getText().trim().equals("")){
            rekening = Integer.parseInt(view.getTxtRekening().getText().concat("0"));
        } else {
            rekening = Integer.parseInt(view.getTxtRekening().getText());
        }
               
        Integer uang_tunai = null;
        if(view.getTxtUangTunai().getText().trim().equals("")){
            uang_tunai = Integer.parseInt(view.getTxtUangTunai().getText().concat("0"));
        } else {
            uang_tunai = Integer.parseInt(view.getTxtUangTunai().getText());
        }
        
        if (id_anggota.trim().equals("~ Pilih ~")) {
            JOptionPane.showMessageDialog(view, "Nama Anggota Tidak Boleh Kosong!");
        } else if (id_donatur.trim().equals("~ Pilih ~")) {
            JOptionPane.showMessageDialog(view, "Nama Donatur Tidak Boleh Kosong!");
        } else if (rekening == 0 && uang_tunai == 0){
            JOptionPane.showMessageDialog(view, "Rekening atau Uang Tunai Tidak Boleh Kosong!");
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
        String id_anggota = view.getComboBoxAnggota().getSelectedItem().toString();
        String id_donatur = view.getComboBoxDonatur().getSelectedItem().toString();
        
        Integer rekening = null;
        if(view.getTxtRekening().getText().trim().equals("")){
            rekening = Integer.parseInt(view.getTxtRekening().getText().concat("0"));
        } else {
            rekening = Integer.parseInt(view.getTxtRekening().getText());
        }
               
        Integer uang_tunai = null;
        if(view.getTxtUangTunai().getText().trim().equals("")){
            uang_tunai = Integer.parseInt(view.getTxtUangTunai().getText().concat("0"));
        } else {
            uang_tunai = Integer.parseInt(view.getTxtUangTunai().getText());
        }
        
        if (id_anggota.trim().equals("~ Pilih ~")) {
            JOptionPane.showMessageDialog(view, "Nama Anggota Tidak Boleh Kosong!");
        } else if (id_donatur.trim().equals("~ Pilih ~")) {
            JOptionPane.showMessageDialog(view, "Nama Donatur Tidak Boleh Kosong!");
        } else if (rekening == 0 && uang_tunai == 0){
            JOptionPane.showMessageDialog(view, "Rekening atau Uang Tunai Tidak Boleh Kosong!");
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
