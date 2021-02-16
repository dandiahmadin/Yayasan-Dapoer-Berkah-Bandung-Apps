/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.controller;

import id.dapoerberkahbandung.model.PengeluaranModel;
import id.dapoerberkahbandung.view.PengeluaranView;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Alfi Nurizkya
 */
public class PengeluaranController {
   private PengeluaranModel model;

    public void setModel(PengeluaranModel model) {
        this.model = model;
    }
   
    public void resetPengeluaran(PengeluaranView view) {
       model.resetPengeluaran();
    }
   
    public void insertPengeluaran(PengeluaranView view) {
        Date tanggal = new Date(view.getDateChooser().getDate().getTime());
        String id_anggota = view.getTxtIdAnggota().getText();
        String id_kebutuhan = view.getTxtIdKebutuhan().getText();
        Integer rekening = Integer.parseInt(view.getTxtRekening().getText());
        Integer uang_tunai = Integer.parseInt(view.getTxtUangTunai().getText());
       
        if (id_anggota.trim().equals("")) {
           JOptionPane.showMessageDialog(view, "ID Anggota Tidak Boleh Kosong!");
        } else if (id_anggota.length() > 4) {
           JOptionPane.showMessageDialog(view, "ID Anggota Tidak Boleh Lebih dari 4 karakter!");
        } else if (id_kebutuhan.trim().equals("")) {
           JOptionPane.showMessageDialog(view, "ID Kebutuhan Tidak Boleh Kosong!");
        } else if (id_kebutuhan.length() > 4) {
           JOptionPane.showMessageDialog(view, "ID Kebutuhan Tidak Boleh Lebih dari 4 karakter!");
        } else {
            model.setTanggal(tanggal);
            model.setId_anggota(id_anggota);
            model.setId_kebutuhan(id_kebutuhan);
            model.setRekening(rekening);
            model.setUang_tunai(uang_tunai);
            
            try {
                model.insertPengeluaran();
                JOptionPane.showMessageDialog(view, "Pengeluaran Berhasil Ditambahkan!");
                model.resetPengeluaran();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error Di Database Dengan Pesan ", throwable.getMessage()});
            }
        }
    }
   
    public void updatePengeluaran(PengeluaranView view) {
        
        if(view.getTabelPengeluaran().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silakan pilih baris yang akan diubah!");
            return;
        }
        Integer no_pemasukan = Integer.parseInt(view.getTxtNoPengeluaran().getText());
        Date tanggal = new Date(view.getDateChooser().getDate().getTime());
        String id_anggota = view.getTxtIdAnggota().getText();
        String id_kebutuhan = view.getTxtIdKebutuhan().getText();
        Integer rekening = Integer.parseInt(view.getTxtRekening().getText());
        Integer uang_tunai = Integer.parseInt(view.getTxtUangTunai().getText());
        
        if (id_anggota.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Anggota Tidak Boleh Kosong!");
        } else if (id_anggota.length() > 4) {
            JOptionPane.showMessageDialog(view, "ID Anggota Tidak Boleh Lebih dari 4 karakter!");
        } else if (id_kebutuhan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Kebutuhan Tidak Boleh Kosong!");
        } else if (id_kebutuhan.length() > 4) {
            JOptionPane.showMessageDialog(view, "ID Kebutuhan Tidak Boleh Lebih dari 4 karakter!");
        } else {
            model.setNo_pengeluaran(no_pemasukan);
            model.setTanggal(tanggal);
            model.setId_anggota(id_anggota);
            model.setId_kebutuhan(id_kebutuhan);
            model.setRekening(rekening);
            model.setUang_tunai(uang_tunai);
            
            try {
                model.updatePengeluaran();
                JOptionPane.showMessageDialog(view, "Pengeluaran Berhasil Diubah!");
                model.resetPengeluaran();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error Di Database Dengan Pesan ", throwable.getMessage()});
            }
        }
    }
    
    public void deletePengeluaran(PengeluaranView view) {
        if (view.getTabelPengeluaran().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silakan pilih baris data yang akan di hapus!");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus?")== JOptionPane.OK_OPTION) {
            Integer no_pengeluaran = Integer.parseInt(view.getTxtNoPengeluaran().getText());
            model.setNo_pengeluaran(no_pengeluaran);
       
            try {
                model.deletePengeluaran();
                JOptionPane.showMessageDialog(view, "Pengeluaran Berhasil Dihapus!");
                model.resetPengeluaran();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error Di Database Dengan Pesan ", throwable.getMessage()});
            }
        }
    }
}
