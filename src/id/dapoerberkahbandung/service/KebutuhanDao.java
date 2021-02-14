/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.service;

import id.dapoerberkahbandung.entity.Kebutuhan;
import id.dapoerberkahbandung.error.KebutuhanException;
import java.util.List;

/**
 *
 * @author Alfi Nurizkya
 */
public interface KebutuhanDao {
    public String autoGenerateId();
    
    public void insertKebutuhan(Kebutuhan kebutuhan) throws KebutuhanException;
    public void updateKebutuhan(Kebutuhan kebutuhan) throws KebutuhanException;
    public void deleteKebutuhan(String id_kebutuhan) throws KebutuhanException;
    public Kebutuhan getKebutuhan(String id_kebutuhan) throws KebutuhanException;
    public List<Kebutuhan> selectAllKebutuhan() throws KebutuhanException;
    
}
