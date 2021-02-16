/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.model;

import id.dapoerberkahbandung.entity.Pemasukan;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dandi Ahmadin
 */
public class TabelPemasukanModel extends AbstractTableModel {
    
    List<Pemasukan> list = new ArrayList<Pemasukan>();

    public void setList(List<Pemasukan> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getNo_pemasukan();
            case 1 : {
                SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
                String tgl = formatDate.format(list.get(rowIndex).getTanggal());
                return tgl;
            }
            case 2 : return list.get(rowIndex).getId_anggota();
            case 3 : return list.get(rowIndex).getId_donatur();
            case 4 : return list.get(rowIndex).getRekening();
            case 5 : return list.get(rowIndex).getUang_tunai();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        //To change body of generated methods, choose Tools | Templates.
        switch (column) {
            case 0 : return "Nomor Pemasukan";
            case 1 : return "Tanggal";
            case 2 : return "ID Anggota";
            case 3 : return "ID Donatur";
            case 4 : return "Rekening";
            case 5 : return "Uang Tunai";
            default: return null;
        }
    }

    public Pemasukan get(int index) {
        return list.get(index);
    }

    public Pemasukan set(int index, Pemasukan e) {
        try {
            return list.set(index, e);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public void add(Pemasukan e) {
        try {
            list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Pemasukan remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }
    
    
    
    
}
