/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.event;

import id.dapoerberkahbandung.entity.Anggota;
import id.dapoerberkahbandung.model.AnggotaModel;

/**
 *
 * @author Dandi Ahmadin
 */
public interface AnggotaListener {
    
    // model anggota
    public void onChange(AnggotaModel model);
   
    // entity anggota
    public void onInsert(Anggota anggota);
    public void onUpdate(Anggota anggota);
    
    
    public void onDelete();
    
}
