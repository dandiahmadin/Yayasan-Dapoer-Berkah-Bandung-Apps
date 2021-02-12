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
public class Donatur {
    private String id_donatur, nama, alamat, no_telp;

    public Donatur() {
    }

    public Donatur(String id_donatur, String nama, String alamat, String no_telp) {
        this.id_donatur = id_donatur;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telp = no_telp;
    }
    
    public String getId_donatur() {
        return id_donatur;
    }

    public void setId_donatur(String id_donatur) {
        this.id_donatur = id_donatur;
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
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id_donatur);
        hash = 37 * hash + Objects.hashCode(this.nama);
        hash = 37 * hash + Objects.hashCode(this.alamat);
        hash = 37 * hash + Objects.hashCode(this.no_telp);
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
        final Donatur other = (Donatur) obj;
        if (!Objects.equals(this.id_donatur, other.id_donatur)) {
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
