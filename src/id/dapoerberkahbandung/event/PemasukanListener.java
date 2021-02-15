/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.event;

import id.dapoerberkahbandung.entity.Pemasukan;
import id.dapoerberkahbandung.model.PemasukanModel;

/**
 *
 * @author Dandi Ahmadin
 */
public interface PemasukanListener {
    public void onChange(PemasukanModel model);
    public void onInsert(Pemasukan pemasukan);
    public void onUpdate(Pemasukan pemasukan);
    public void onDelete();
}
