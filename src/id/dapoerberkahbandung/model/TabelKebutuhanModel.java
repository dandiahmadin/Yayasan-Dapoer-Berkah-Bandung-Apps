/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.model;

import id.dapoerberkahbandung.entity.Kebutuhan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alfi Nurizkya
 */
public class TabelKebutuhanModel extends AbstractTableModel{

    List<Kebutuhan> list = new ArrayList<Kebutuhan>();

    public void setList(List<Kebutuhan> list) {
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
            case 0 : return list.get(rowIndex).getId_kebutuhan();
            case 1 : return list.get(rowIndex).getKebutuhan();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        //To change body of generated methods, choose Tools | Templates.
        switch (column) {
            case 0 : return "ID Kebutuhan";
            case 1 : return "Kebutuhan";
            default: return null;
        }
    }

    public Kebutuhan get(int index) {
        return list.get(index);
    }

    public Kebutuhan set(int index, Kebutuhan kebutuhan) {
        try {
            return list.set(index, kebutuhan);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public void add(Kebutuhan kebutuhan) {
        try {
            list.add(kebutuhan);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Kebutuhan remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }
    
    
    
}
