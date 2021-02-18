/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.model;

import id.dapoerberkahbandung.database.Koneksi;
import id.dapoerberkahbandung.entity.Pengeluaran;
import id.dapoerberkahbandung.error.AnggotaException;
import id.dapoerberkahbandung.error.KebutuhanException;
import id.dapoerberkahbandung.error.PengeluaranException;
import id.dapoerberkahbandung.event.PengeluaranListener;
import id.dapoerberkahbandung.service.PengeluaranDao;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Alfi Nurizkya
 */
public class PengeluaranModel {
    private int no_pengeluaran, rekening, uang_tunai;
    private String id_anggota, id_kebutuhan;
    private Date tanggal;
    private PengeluaranListener listener;

    public void setListener(PengeluaranListener listener) {
        this.listener = listener;
    }

    public PengeluaranListener getListener() {
        return listener;
    }
    
    public int getNo_pengeluaran() {
        return no_pengeluaran;
    }

    public void setNo_pengeluaran(int no_pengeluaran) {
        this.no_pengeluaran = no_pengeluaran;
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

    public String getId_kebutuhan() {
        return id_kebutuhan;
    }

    public void setId_kebutuhan(String id_kebutuhan) {
        this.id_kebutuhan = id_kebutuhan;
        fireOnChange();
    }
    
    public void fireOnChange() {
        if(listener != null) {
            listener.onChange(this);
        }
    }
    
    public void fireOnInsert(Pengeluaran pengeluaran) {
        if(listener != null) {
            listener.onInsert(pengeluaran);
        }
    }
    
    public void fireOnUpdate(Pengeluaran pengeluaran) {
        if(listener != null) {
            listener.onUpdate(pengeluaran);
        }
    }
    
    public void fireOnDelete() {
        if(listener != null) {
            listener.onDelete();
        }
    }
    
    public void insertPengeluaran() throws SQLException, PengeluaranException, AnggotaException, KebutuhanException {
        PengeluaranDao dao = Koneksi.getPengeluaranDao();
        
        Pengeluaran pengeluaran = new Pengeluaran();
        pengeluaran.setTanggal(tanggal);
        pengeluaran.setId_anggota(dao.getIdAnggota(id_anggota).getId_anggota());
        pengeluaran.setId_kebutuhan(dao.getIdKebutuhan(id_kebutuhan).getId_kebutuhan());
        pengeluaran.setRekening(rekening);
        pengeluaran.setUang_tunai(uang_tunai);
        
        dao.insertPengeluaran(pengeluaran);
        fireOnInsert(pengeluaran);
    }
    
    public void updatePengeluaran() throws SQLException, PengeluaranException, KebutuhanException, AnggotaException {
        PengeluaranDao dao = Koneksi.getPengeluaranDao();
        
        Pengeluaran pengeluaran = new Pengeluaran();
        pengeluaran.setTanggal(tanggal);
        pengeluaran.setId_anggota(dao.getIdAnggota(id_anggota).getId_anggota());
        pengeluaran.setId_kebutuhan(dao.getIdKebutuhan(id_kebutuhan).getId_kebutuhan());
        pengeluaran.setRekening(rekening);
        pengeluaran.setUang_tunai(uang_tunai);
        pengeluaran.setNo_pengeluaran(no_pengeluaran);
        
        dao.updatePengeluaran(pengeluaran);
        fireOnUpdate(pengeluaran);
    }
    
    public void deletePengeluaran() throws PengeluaranException, SQLException {
        PengeluaranDao dao = Koneksi.getPengeluaranDao();
        
        dao.deletePengeluaran(no_pengeluaran);
        fireOnDelete();
    }
    
    public void resetPengeluaran() {
        setNo_pengeluaran(0);
        setTanggal(new Date());
        setId_anggota("");
        setId_kebutuhan("");
        setRekening(0);
        setUang_tunai(0);
    }
}
