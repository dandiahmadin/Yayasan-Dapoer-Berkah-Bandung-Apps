/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.service;

import id.dapoerberkahbandung.error.PemasukanException;
import id.dapoerberkahbandung.error.PengeluaranException;

/**
 *
 * @author Dandi Ahmadin
 */
public interface BerandaDao {
    public int getSaldoPemasukan() throws PemasukanException;
    public int getSaldoPengeluaran() throws PengeluaranException;
    
}
