/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.model;

import id.dapoerberkahbandung.entity.Anggota;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dandi Ahmadin
 */
public class TabelAnggotaModel extends AbstractTableModel {

    List<Anggota> list = new ArrayList<Anggota>();

    public void setList(List<Anggota> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return list.get(rowIndex).getId_anggota();
            case 1: return list.get(rowIndex).getNama();
            case 2: return list.get(rowIndex).getAlamat();
            case 3: return list.get(rowIndex).getNo_telp();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Id Anggota";
            case 1: return "Nama";
            case 2: return "Alamat";
            case 3: return "Nomor Telepon";
            default: return null;
        }
    }

    public  Anggota get(int index) {
        return list.get(index);
    }

    public Anggota set(int index, Anggota e) {
        try {
            return list.set(index, e);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public boolean add(Anggota e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Anggota remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }
    
    
    
}
