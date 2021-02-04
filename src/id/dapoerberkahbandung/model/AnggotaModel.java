/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.model;

import id.dapoerberkahbandung.database.Koneksi;
import id.dapoerberkahbandung.entity.Anggota;
import id.dapoerberkahbandung.error.AnggotaException;
import id.dapoerberkahbandung.event.AnggotaListener;
import id.dapoerberkahbandung.service.AnggotaDao;
import java.sql.SQLException;

/**
 *
 * @author Dandi Ahmadin
 */
public class AnggotaModel {
    private String id_anggota;
    private String nama;
    private String alamat;
    private String no_telp;
    private AnggotaListener listener;

    public String getId_anggota() {
        return id_anggota;
    }

    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
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
    
    public AnggotaListener getListener() {
        return listener;
    }

    public void setListener(AnggotaListener listener) {
        this.listener = listener;
    }
    
    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Anggota anggota) {
        if (listener != null) {
            listener.onInsert(anggota);
        }
    }
    
    protected void fireOnUpdate(Anggota anggota) {
        if (listener != null) {
            listener.onUpdate(anggota);
        }
    }
    
    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }
    
    public void insertAnggota() throws SQLException, AnggotaException {
        AnggotaDao dao = Koneksi.getAnggotaDao();
        
        Anggota anggota = new Anggota();
        anggota.setId_anggota(id_anggota);
        anggota.setNama(nama);
        anggota.setAlamat(alamat);
        anggota.setNo_telp(no_telp);
        
        dao.insertAnggota(anggota);
        fireOnInsert(anggota);
    }
    
    public void updateAnggota() throws SQLException, AnggotaException {
        AnggotaDao dao = Koneksi.getAnggotaDao();
        
        Anggota anggota = new Anggota();
        anggota.setId_anggota(id_anggota);
        anggota.setNama(nama);
        anggota.setAlamat(alamat);
        anggota.setNo_telp(no_telp);
        
        dao.updateAnggota(anggota);
        fireOnUpdate(anggota);
    }
    
    public void deleteAnggota() throws SQLException, AnggotaException {
        AnggotaDao dao = Koneksi.getAnggotaDao();
        dao.deleteAnggota(id_anggota);
        fireOnDelete();
    }
    
    public void resetAnggota() {
        setId_anggota("");
        setNama("");
        setAlamat("");
        setNo_telp("");
    }
    
}
