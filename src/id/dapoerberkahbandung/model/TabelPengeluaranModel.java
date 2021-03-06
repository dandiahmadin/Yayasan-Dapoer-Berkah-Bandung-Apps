/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.model;

import id.dapoerberkahbandung.entity.Pengeluaran;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alfi Nurizkya
 */
public class TabelPengeluaranModel extends AbstractTableModel {
    
    List<Pengeluaran> list = new ArrayList<Pengeluaran>();

    public void setList(List<Pengeluaran> list) {
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
            case 0 : return list.get(rowIndex).getNo_pengeluaran();
            case 1 : {
                SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
                String tanggal = formatDate.format(list.get(rowIndex).getTanggal());
                return tanggal;
            }
            case 2 : return list.get(rowIndex).getId_anggota();
            case 3 : return list.get(rowIndex).getId_kebutuhan();
            case 4 : return list.get(rowIndex).getRekening();
            case 5 : return list.get(rowIndex).getUang_tunai();
            default : return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "Nomor";
            case 1 : return "Tanggal";
            case 2 : return "Anggota";
            case 3 : return "Kebutuhan";
            case 4 : return "Rekening";
            case 5 : return "Uang Tunai";
            default: return null;
        }
    }

    public void add(Pengeluaran e) {
        try {
            list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Pengeluaran get(int i) {
        return list.get(i);
    }

    public Pengeluaran set(int i, Pengeluaran e) {
        try {
            return list.set(i, e);
        } finally {
            fireTableRowsUpdated(i, i);
        }
    }

    public Pengeluaran remove(int i) {
        try {
            return list.remove(i);
        } finally {
            fireTableRowsDeleted(i, i);
        }
    }
    
    
    
    
    
}
