/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.service;

import id.dapoerberkahbandung.entity.Anggota;
import id.dapoerberkahbandung.error.AnggotaException;
import java.util.ArrayList;

/**
 *
 * @author Dandi Ahmadin
 */
public interface AnggotaDao {
    // menambah anggota
    public void insertAnggota(Anggota anggota) throws AnggotaException;
    
    // update anggota
    public void updateAnggota(Anggota anggota) throws AnggotaException;
    
    // delete anggota
    public void deleteAnggota(String id_anggota) throws AnggotaException;
    
    // mendapatkan satu record anggota
    public Anggota getAnggota(String id_anggota) throws AnggotaException;
    
    // menampilkan semua data anggota
    public ArrayList<Anggota> selectAllAnggota() throws AnggotaException;
}
