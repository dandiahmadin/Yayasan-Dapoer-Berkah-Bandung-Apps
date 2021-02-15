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
public class Kebutuhan {
    private String id_kebutuhan, nama_kebutuhan;

    public Kebutuhan() {
    }

    public Kebutuhan(String id_kebutuhan, String nama_kebutuhan) {
        this.id_kebutuhan = id_kebutuhan;
        this.nama_kebutuhan = nama_kebutuhan;
        
    }
    
    public String getId_kebutuhan() {
        return id_kebutuhan;
    }

    public void setId_kebutuhan(String id_kebutuhan) {
        this.id_kebutuhan= id_kebutuhan;
    }

    public String getNama_kebutuhan() {
        return nama_kebutuhan;
    }

    public void setNama_kebutuhan(String nama_kebutuhan) {
        this.nama_kebutuhan = nama_kebutuhan;
    }

   
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id_kebutuhan);
        hash = 37 * hash + Objects.hashCode(this.nama_kebutuhan);
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
        final Kebutuhan other = (Kebutuhan) obj;
        if (!Objects.equals(this.id_kebutuhan, other.id_kebutuhan)) {
            return false;
        }
        if (!Objects.equals(this.nama_kebutuhan, other.nama_kebutuhan)) {
            return false;
        }
        return true;
    }
}
