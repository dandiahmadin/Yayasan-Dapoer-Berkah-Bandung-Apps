/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.entity;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Dandi Ahmadin
 */
public class Pemasukan {
    private int no_pemasukan;
    private Date tanggal;
    private String id_donatur, id_anggota;
    private int rekening, uang_tunai;

    
    public Pemasukan() {
    }

    public Pemasukan(Date tanggal, String id_anggota, String id_donatur, int rekening, int uang_tunai) {
        this.tanggal = tanggal;
        this.id_anggota = id_anggota;
        this.id_donatur = id_donatur;
        this.rekening = rekening;
        this.uang_tunai = uang_tunai;
    }

    public int getNo_pemasukan() {
        return no_pemasukan;
    }

    public void setNo_pemasukan(int no_pemasukan) {
        this.no_pemasukan = no_pemasukan;
    }

    public int getRekening() {
        return rekening;
    }

    public void setRekening(int rekening) {
        this.rekening = rekening;
    }
   
    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getId_donatur() {
        return id_donatur;
    }

    public void setId_donatur(String id_donatur) {
        this.id_donatur = id_donatur;
    }

    public String getId_anggota() {
        return id_anggota;
    }

    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
    }
   
    public int getUang_tunai() {
        return uang_tunai;
    }

    public void setUang_tunai(int uang_tunai) {
        this.uang_tunai = uang_tunai;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.no_pemasukan;
        hash = 89 * hash + Objects.hashCode(this.tanggal);
        hash = 89 * hash + Objects.hashCode(this.id_donatur);
        hash = 89 * hash + Objects.hashCode(this.id_anggota);
        hash = 89 * hash + this.rekening;
        hash = 89 * hash + this.uang_tunai;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pemasukan other = (Pemasukan) obj;
        if (this.no_pemasukan != other.no_pemasukan) {
            return false;
        }
        if (this.rekening != other.rekening) {
            return false;
        }
        if (this.uang_tunai != other.uang_tunai) {
            return false;
        }
        if (!Objects.equals(this.id_donatur, other.id_donatur)) {
            return false;
        }
        if (!Objects.equals(this.id_anggota, other.id_anggota)) {
            return false;
        }
        if (!Objects.equals(this.tanggal, other.tanggal)) {
            return false;
        }
        return true;
    }

    
}
