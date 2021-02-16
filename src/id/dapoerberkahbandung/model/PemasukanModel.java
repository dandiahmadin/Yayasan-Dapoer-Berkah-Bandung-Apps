/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.model;

import id.dapoerberkahbandung.database.Koneksi;
import id.dapoerberkahbandung.entity.Pemasukan;
import id.dapoerberkahbandung.error.PemasukanException;
import id.dapoerberkahbandung.event.PemasukanListener;
import id.dapoerberkahbandung.service.PemasukanDao;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Dandi Ahmadin
 */
public class PemasukanModel {
    private int no_pemasukan, rekening, uang_tunai;
    private Date tanggal;
    private String id_anggota, id_donatur;
    private PemasukanListener listener;

    public PemasukanListener getListener() {
        return listener;
    }

    public void setListener(PemasukanListener listener) {
        this.listener = listener;
    }
    
    public int getNo_pemasukan() {
        return no_pemasukan;
    }

    public void setNo_pemasukan(int no_pemasukan) {
        this.no_pemasukan = no_pemasukan;
        fireOnChange();
    }
    
    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
        fireOnChange();
    }

    public int getRekening() {
        return rekening;
    }

    public void setRekening(int rekening) {
        this.rekening = rekening;
        fireOnChange();
    }

    public int getUang_tunai() {
        return uang_tunai;
    }

    public void setUang_tunai(int uang_tunai) {
        this.uang_tunai = uang_tunai;
        fireOnChange();
    }

    public String getId_anggota() {
        return id_anggota;
    }

    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
        fireOnChange();
    }

    public String getId_donatur() {
        return id_anggota;
    }

    public void setId_donatur(String id_donatur) {
        this.id_donatur = id_donatur;
        fireOnChange();
    }
    
    public void fireOnChange() {
        if(listener != null) {
            listener.onChange(this);
        }
    }
    
    public void fireOnInsert(Pemasukan pemasukan) {
        if(listener != null) {
            listener.onInsert(pemasukan);
        }
    }
    
    public void fireOnUpdate(Pemasukan pemasukan) {
        if(listener != null) {
            listener.onUpdate(pemasukan);
        }
    }
    
    public void fireOnDelete() {
        if(listener != null) {
            listener.onDelete();
        }
    }
    
    public void insertPemasukan() throws SQLException, PemasukanException {
        PemasukanDao dao = Koneksi.getPemasukanDao();
        
        Pemasukan pemasukan = new Pemasukan();
        pemasukan.setTanggal(tanggal);
        pemasukan.setId_anggota(id_anggota);
        pemasukan.setId_donatur(id_donatur);
        pemasukan.setRekening(rekening);
        pemasukan.setUang_tunai(uang_tunai);
        
        dao.insertPemasukan(pemasukan);
        fireOnInsert(pemasukan);
    }
    
    public void updatePemasukan() throws SQLException, PemasukanException {
        PemasukanDao dao = Koneksi.getPemasukanDao();
        
        Pemasukan pemasukan = new Pemasukan();
        pemasukan.setTanggal(tanggal);
        pemasukan.setId_anggota(id_anggota);
        pemasukan.setId_donatur(id_donatur);
        pemasukan.setRekening(rekening);
        pemasukan.setUang_tunai(uang_tunai);
        pemasukan.setNo_pemasukan(no_pemasukan);
        
        dao.updatePemasukan(pemasukan);
        fireOnUpdate(pemasukan);
    }
    
    public void deletePemasukan() throws SQLException, PemasukanException {
        PemasukanDao dao = Koneksi.getPemasukanDao();
        dao.deletePemasukan(no_pemasukan);
        fireOnDelete();
    }
    
    public void resetPemasukan() {
        setNo_pemasukan(0);
        setTanggal(new Date());
        setId_anggota("");
        setId_donatur("");
        setRekening(0);
        setUang_tunai(0);
    }
    
}
