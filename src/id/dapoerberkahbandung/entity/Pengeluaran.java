/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.entity;

import java.util.Objects;

/**
 *
 * @author Alfi Nurizkya
 */
public class Pengeluaran {
    private int no_pengeluaran, rekening, uang_tunai;
    private String id_anggota, id_kebutuhan;

    public Pengeluaran() {
    }

    public Pengeluaran(int no_pengeluaran, int rekening, int uang_tunai, String id_anggota, String id_kebutuhan) {
        this.no_pengeluaran = no_pengeluaran;
        this.rekening = rekening;
        this.uang_tunai = uang_tunai;
        this.id_anggota = id_anggota;
        this.id_kebutuhan = id_kebutuhan;
    }

    public int getNo_pengeluaran() {
        return no_pengeluaran;
    }

    public void setNo_pengeluaran(int no_pengeluaran) {
        this.no_pengeluaran = no_pengeluaran;
    }

    public int getRekening() {
        return rekening;
    }

    public void setRekening(int rekening) {
        this.rekening = rekening;
    }

    public int getUang_tunai() {
        return uang_tunai;
    }

    public void setUang_tunai(int uang_tunai) {
        this.uang_tunai = uang_tunai;
    }

    public String getId_anggota() {
        return id_anggota;
    }

    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
    }

    public String getId_kebutuhan() {
        return id_kebutuhan;
    }

    public void setId_kebutuhan(String id_kebutuhan) {
        this.id_kebutuhan = id_kebutuhan;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.no_pengeluaran;
        hash = 47 * hash + this.rekening;
        hash = 47 * hash + this.uang_tunai;
        hash = 47 * hash + Objects.hashCode(this.id_anggota);
        hash = 47 * hash + Objects.hashCode(this.id_kebutuhan);
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
        final Pengeluaran other = (Pengeluaran) obj;
        if (this.no_pengeluaran != other.no_pengeluaran) {
            return false;
        }
        if (this.rekening != other.rekening) {
            return false;
        }
        if (this.uang_tunai != other.uang_tunai) {
            return false;
        }
        if (!Objects.equals(this.id_anggota, other.id_anggota)) {
            return false;
        }
        if (!Objects.equals(this.id_kebutuhan, other.id_kebutuhan)) {
            return false;
        }
        return true;
    }
    
    
}
