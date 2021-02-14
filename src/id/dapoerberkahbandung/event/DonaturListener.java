/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.event;

import id.dapoerberkahbandung.entity.Donatur;
import id.dapoerberkahbandung.model.DonaturModel;

/**
 *
 * @author Dandi Ahmadin
 */
public interface DonaturListener {
    public void onChange(DonaturModel donatur);
    public void onInsert(Donatur donatur);
    public void onUpdate(Donatur donatur);
    public void onDelete();
}
