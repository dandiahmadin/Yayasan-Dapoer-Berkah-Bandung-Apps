/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.model;

import id.dapoerberkahbandung.database.Koneksi;
import id.dapoerberkahbandung.entity.Donatur;
import id.dapoerberkahbandung.error.DonaturException;
import id.dapoerberkahbandung.event.DonaturListener;
import id.dapoerberkahbandung.service.DonaturDao;
import java.sql.SQLException;

/**
 *
 * @author Dandi Ahmadin
 */
public class DonaturModel {
    private String id_donatur, nama, alamat, no_telp;
    private DonaturListener listener;
    
    public String getId_donatur() {
        return id_donatur;
    }

    public void setId_donatur(String id_donatur) {
        this.id_donatur = id_donatur;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
        fireOnChange();
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
        fireOnChange();
    }

    public DonaturListener getListener() {
        return listener;
    }

    public void setDonaturListener(DonaturListener listener) {
        this.listener = listener;
    }

    public void fireOnChange() {
        if(listener != null) {
            listener.onChange(this);
        }
    }

    public void fireOnInsert(Donatur donatur) {
        if(listener != null) {
            listener.onInsert(donatur);
        }
    }

    public void fireOnUpdate(Donatur donatur) {
        if(listener != null) {
            listener.onUpdate(donatur);
        }
    }

    public void fireOnDelete() {
        if(listener != null) {
            listener.onDelete();
        }
    }
    
    public void insertDonatur() throws SQLException, DonaturException {
        DonaturDao dao = Koneksi.getDonaturDao();
        
        Donatur donatur = new Donatur();
        donatur.setId_donatur(id_donatur);
        donatur.setNama(nama);
        donatur.setAlamat(alamat);
        donatur.setNo_telp(no_telp);
        
        dao.insertDonatur(donatur);
        fireOnInsert(donatur);
    }
    
    public void updateDonatur() throws SQLException, DonaturException {
        DonaturDao dao = Koneksi.getDonaturDao();
        
        Donatur donatur = new Donatur();
        donatur.setId_donatur(id_donatur);
        donatur.setNama(nama);
        donatur.setAlamat(alamat);
        donatur.setNo_telp(no_telp);
        
        dao.updateDonatur(donatur);
        fireOnUpdate(donatur);
    }
    
    public void deleteDonatur() throws SQLException, DonaturException {
        DonaturDao dao = Koneksi.getDonaturDao();
        
        dao.deleteDonatur(id_donatur);
        fireOnDelete();
    }
    
    public void resetDonatur() throws SQLException {
        DonaturDao dao = Koneksi.getDonaturDao();
        setId_donatur(dao.autoGenerateId());
        setNama("");
        setAlamat("");
        setNo_telp("");
    }
}
