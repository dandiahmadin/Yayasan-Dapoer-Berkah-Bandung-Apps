/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.event;

import id.dapoerberkahbandung.entity.Pengeluaran;
import id.dapoerberkahbandung.model.PengeluaranModel;

/**
 *
 * @author Alfi Nurizkya
 */
public interface PengeluaranListener {
    public void onChange(PengeluaranModel model);
    public void onInsert(Pengeluaran pengeluaran);
    public void onUpdate(Pengeluaran pengeluaran);
    public void onDelete();
}
