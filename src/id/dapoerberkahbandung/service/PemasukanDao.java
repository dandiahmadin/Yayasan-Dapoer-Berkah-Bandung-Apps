/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.service;

import id.dapoerberkahbandung.entity.Anggota;
import id.dapoerberkahbandung.entity.Donatur;
import id.dapoerberkahbandung.entity.Pemasukan;
import id.dapoerberkahbandung.error.AnggotaException;
import id.dapoerberkahbandung.error.DonaturException;
import id.dapoerberkahbandung.error.PemasukanException;
import java.util.List;

/**
 *
 * @author Dandi Ahmadin
 */
public interface PemasukanDao {
    public void insertPemasukan(Pemasukan pemasukan) throws PemasukanException;
    public void updatePemasukan(Pemasukan pemasukan) throws PemasukanException;
    public void deletePemasukan(int no_pemasukan) throws PemasukanException;
    public Pemasukan getPemasukan(int no_pemasukan) throws PemasukanException;
    public List<Pemasukan> selectAllPemasukan() throws PemasukanException;
    public List<Anggota> selectNameAnggota() throws AnggotaException;
    public List<Donatur> selectNameDonatur() throws DonaturException;
    public Anggota getIdAnggota(String nama) throws AnggotaException;
    public Donatur getIdDonatur(String nama) throws DonaturException;
}
