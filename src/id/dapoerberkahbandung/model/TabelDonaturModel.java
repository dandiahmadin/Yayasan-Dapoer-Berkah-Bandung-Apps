/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.model;

import id.dapoerberkahbandung.entity.Donatur;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dandi Ahmadin
 */
public class TabelDonaturModel extends AbstractTableModel{

    List<Donatur> list = new ArrayList<Donatur>();

    public void setList(List<Donatur> list) {
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
            case 0 : return list.get(rowIndex).getId_donatur();
            case 1 : return list.get(rowIndex).getNama();
            case 2 : return list.get(rowIndex).getAlamat();
            case 3 : return list.get(rowIndex).getNo_telp();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        //To change body of generated methods, choose Tools | Templates.
        switch (column) {
            case 0 : return "ID Donatur";
            case 1 : return "Nama";
            case 2 : return "Alamat";
            case 3 : return "Nomor Telepon";
            default: return null;
        }
    }

    public Donatur get(int index) {
        return list.get(index);
    }

    public Donatur set(int index, Donatur donatur) {
        try {
            return list.set(index, donatur);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public void add(Donatur donatur) {
        try {
            list.add(donatur);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Donatur remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }
    
    
    
}
