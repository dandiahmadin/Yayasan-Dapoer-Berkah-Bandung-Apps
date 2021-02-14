/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.entity;

import id.dapoerberkahbandung.service.AnggotaDao;
import id.dapoerberkahbandung.service.DonaturDao;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Dandi Ahmadin
 */
public class Pemasukan {
    private int no_pemasukan;
    private Date tanggal;
    private Anggota anggota;
    private Donatur donatur;
    private int rekening, uang_tunai;

    public Pemasukan() {
    }

    public Pemasukan(Date tanggal, int rekening, int uang_tunai) {
        this.tanggal = tanggal;
        this.rekening = rekening;
        this.uang_tunai = uang_tunai;
    }

    public int getNo_pemasukan() {
        return no_pemasukan;
    }

    public void setNo_pemasukan(int no_pemasukan) {
        this.no_pemasukan = no_pemasukan;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Donatur getDonatur() {
        return donatur;
    }

    public void setDonatur(Donatur donatur) {
        this.donatur = donatur;
    }

    public int getRekening() {
        return rekening;
    }

    public void setRekening(int rekening) {
        this.rekening = rekening;
    }

    public int getTunai() {
        return uang_tunai;
    }

    public void setTunai(int uang_tunai) {
        this.uang_tunai = uang_tunai;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.no_pemasukan);
        hash = 47 * hash + Objects.hashCode(this.tanggal);
        hash = 47 * hash + Objects.hashCode(this.anggota);
        hash = 47 * hash + Objects.hashCode(this.donatur);
        hash = 47 * hash + Objects.hashCode(this.rekening);
        hash = 47 * hash + Objects.hashCode(this.uang_tunai);
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
        if (!Objects.equals(this.no_pemasukan, other.no_pemasukan)) {
            return false;
        }
        if (!Objects.equals(this.tanggal, other.tanggal)) {
            return false;
        }
        if (!Objects.equals(this.anggota, other.anggota)) {
            return false;
        }
        if (!Objects.equals(this.donatur, other.donatur)) {
            return false;
        }
        if (!Objects.equals(this.rekening, other.rekening)) {
            return false;
        }
        if (!Objects.equals(this.uang_tunai, other.uang_tunai)) {
            return false;
        }
        return true;
    }
    
    
}
