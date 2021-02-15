/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.service;

import id.dapoerberkahbandung.entity.Pengeluaran;
import id.dapoerberkahbandung.error.PengeluaranException;
import java.util.List;

/**
 *
 * @author Alfi Nurizkya
 */
public interface PengeluaranDao {
    public void insertPengeluaran(Pengeluaran pengeluaran) throws PengeluaranException;
    public void updatePengeluaran(Pengeluaran pengeluaran) throws PengeluaranException;
    public void deletePengeluaran(int no_pengeluaran) throws PengeluaranException;
    public Pengeluaran getPengeluaran(int no_pengeluaran) throws PengeluaranException;
    public List<Pengeluaran> selectAllPengeluaran() throws PengeluaranException;
}
