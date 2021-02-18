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
        String id_anggota = view.getComboBoxAnggota().getSelectedItem().toString();
        String id_kebutuhan = view.getComboBoxKebutuhan().getSelectedItem().toString();
        
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
        } else if (id_kebutuhan.trim().equals("~ Pilih ~")) {
            JOptionPane.showMessageDialog(view, "Nama Kebutuhan Tidak Boleh Kosong!");
        } else if (rekening == 0 && uang_tunai == 0){
            JOptionPane.showMessageDialog(view, "Rekening atau Uang Tunai Tidak Boleh Kosong!");
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
        Integer no_pengeluaran = Integer.parseInt(view.getTxtNoPengeluaran().getText());
        Date tanggal = new Date(view.getDateChooser().getDate().getTime());
        String id_anggota = view.getComboBoxAnggota().getSelectedItem().toString();
        String id_kebutuhan = view.getComboBoxKebutuhan().getSelectedItem().toString();
        
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
        } else if (id_kebutuhan.trim().equals("~ Pilih ~")) {
            JOptionPane.showMessageDialog(view, "Nama Kebutuhan Tidak Boleh Kosong!");
        } else if (rekening == 0 && uang_tunai == 0){
            JOptionPane.showMessageDialog(view, "Rekening atau Uang Tunai Tidak Boleh Kosong!");
        } else {
            model.setNo_pengeluaran(no_pengeluaran);
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
