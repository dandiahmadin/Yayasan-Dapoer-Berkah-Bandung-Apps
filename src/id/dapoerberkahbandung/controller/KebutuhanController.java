/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.controller;

import id.dapoerberkahbandung.model.KebutuhanModel;
import id.dapoerberkahbandung.view.KebutuhanView;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alfi Nurizkya
 */
public class KebutuhanController {
    private KebutuhanModel model;

    public void setModel(KebutuhanModel model) {
        this.model = model;
    }
    
    public void resetKebutuhan(KebutuhanView view) throws SQLException {
        model.resetKebutuhan();
    }
    
    public void insertKebutuhan(KebutuhanView view) {
        String id_kebutuhan = view.getTxtIdKebutuhan().getText();
        String kebutuhan = view.getTxtKebutuhan().getText();
        
        if (kebutuhan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kebutuhan Tidak Boleh Kosong!");
        } else if (kebutuhan.length() > 50) {
            JOptionPane.showMessageDialog(view, "Kebutuhan Tidak Boleh Lebih Dari 50 Karakter!");
        } 
        else if {
          
            model.setId_kebutuhan(id_kebutuhan);
            model.setKebutuhan(kebutuhan);
                       
            try {
                model.insertKebutuhan();
                JOptionPane.showMessageDialog(view, "Kebutuhan Berhasil Ditambahkan!");
                model.resetKebutuhan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error Di Database Dengan Pesan ", throwable.getMessage()});
            }
        }
    }
    
    public void updateKebutuhan(KebutuhanView view) {
        
        if(view.getTabelKebutuhan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silakan pilih baris yang akan diubah!");
            return;
        }
        
        String id_kebutuhan = view.getTxtIdKebutuhan().getText();
        String kebutuhan = view.getTxtKebutuhan().getText();
       

        if (kebutuhan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kebutuhan Tidak Boleh Kosong!");
        } else if (nama.length() > 50) {
            JOptionPane.showMessageDialog(view, "kebutuhan Tidak Boleh Lebih Dari 50 Karakter!");
        } else {
            model.setId_kebutuhan(id_kebutuhan);
            model.setKebutuhan(kebutuhan);
           
            
            try {
                model.updateKebutuhan();
                JOptionPane.showMessageDialog(view, "Kebutuhan Berhasil Diubah!");
                model.resetKebutuhan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error Di Database Dengan Pesan ", throwable.getMessage()});
            }
        }
    }
    
    public void deleteKebutuhan(KebutuhanView view) {
        if (view.getTabelKebutuhan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silakan pilih baris data yang akan di hapus!");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus?")== JOptionPane.OK_OPTION) {
            String id_kebutuhan = view.getTxtIdKebutuhan().getText();
            model.setId_kebutuhan(id_kebutuhan);
       
            try {
                model.deleteKebutuhan();
                JOptionPane.showMessageDialog(view, "Kebutuhan Berhasil Dihapus!");
                model.resetKebutuhan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error Di Database Dengan Pesan ", throwable.getMessage()});
            }
        }
    }

  }
