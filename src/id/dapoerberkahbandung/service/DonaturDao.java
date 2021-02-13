/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.service;

import id.dapoerberkahbandung.entity.Donatur;
import id.dapoerberkahbandung.error.DonaturException;
import java.util.List;

/**
 *
 * @author Dandi Ahmadin
 */
public interface DonaturDao {
    public void autoGenerateId();
    
    public void insertDonatur(Donatur donatur) throws DonaturException;
    public void updateDonatur(Donatur donatur) throws DonaturException;
    public void deleteDonatur(String id_donatur) throws DonaturException;
    public Donatur getDonatur(String id_donatur) throws DonaturException;
    public List<Donatur> selectAllDonatur() throws DonaturException;
    
}
