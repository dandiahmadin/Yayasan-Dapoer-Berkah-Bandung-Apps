/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.entity;

import java.util.Objects;

/**
 *
 * @author Dandi Ahmadin
 */
public class Anggota {
    private String id_anggota;
    private String nama;
    private String alamat;
    private String no_telp;

    public Anggota() {
        
    }

    public Anggota(String id_anggota, String nama, String alamat, String no_telp) {
        this.id_anggota = id_anggota;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telp = no_telp;
    }
    
    public String getId_anggota() {
        return id_anggota;
    }

    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id_anggota);
        hash = 97 * hash + Objects.hashCode(this.nama);
        hash = 97 * hash + Objects.hashCode(this.alamat);
        hash = 97 * hash + Objects.hashCode(this.no_telp);
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
        final Anggota other = (Anggota) obj;
        if (!Objects.equals(this.id_anggota, other.id_anggota)) {
            return false;
        }
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.alamat, other.alamat)) {
            return false;
        }
        if (!Objects.equals(this.no_telp, other.no_telp)) {
            return false;
        }
        return true;
    }
    
    
}
