/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.event;

import id.dapoerberkahbandung.entity.Kebutuhan;
import id.dapoerberkahbandung.model.KebutuhanModel;

/**
 *
 * @author Alfi Nurizkya
 */
public interface KebutuhanListener {
    public void onChange(KebutuhanModel kebutuhan);
    public void onInsert(Kebutuhan kebutuhan);
    public void onUpdate(Kebutuhan kebutuhan);
    public void onDelete();

}