/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.model;

import id.dapoerberkahbandung.database.Koneksi;
import id.dapoerberkahbandung.entity.Kebutuhan;
import id.dapoerberkahbandung.error.KebutuhanException;
import id.dapoerberkahbandung.event.KebutuhanListener;
import id.dapoerberkahbandung.service.KebutuhanDao;
import id.dapoerberkahbandung.view.KebutuhanView;
import java.sql.SQLException;

/**
 *
 * @author Alfi Nurizkya
 */
public class KebutuhanModel {
    private String id_kebutuhan, kebutuhan;
    private KebutuhanListener listener;
    
    public String getId_kebutuhan() {
        return id_kebutuhan;
    }

    public void setId_kebutuhan(String id_kebutuhan) {
        this.id_kebutuhan = id_kebutuhan;
        fireOnChange();
    }

    public String getKebutuhan() {
        return kebutuhan;
    }

    public void setKebutuhan(String kebutuhan) {
        this.kebutuhan = kebutuhan;
        fireOnChange();
    }

    public KebutuhanListener getListener() {
        return listener;
    }

    public void setKebutuhanListener(KebutuhanListener listener) {
        this.listener = listener;
    }

    public void fireOnChange() {
        if(listener != null) {
            listener.onChange(this);
        }
    }

    public void fireOnInsert(Kebutuhan kebutuhan) {
        if(listener != null) {
            listener.onInsert(kebutuhan);
        }
    }

    public void fireOnUpdate(Kebutuhan kebutuhan) {
        if(listener != null) {
            listener.onUpdate(kebutuhan);
        }
    }

    public void fireOnDelete() {
        if(listener != null) {
            listener.onDelete();
        }
    }
    
    public void insertKebutuhan() throws SQLException, KebutuhanException {
        KebutuhanDao dao = Koneksi.getKebutuhanDao();
        
        Kebutuhan kebutuhan = new Kebutuhan();
        kebutuhan.setId_kebutuhan(id_kebutuhan);
        kebutuhan.setKebutuhan(kebutuhan);
                
        dao.insertKebutuhan(kebutuhan);
        fireOnInsert(kebutuhan);
    }
    
    public void updateKebutuhan() throws SQLException, KebutuhanException {
        KebutuhanDao dao = Koneksi.getKebutuhanDao();
        
        Kebutuhan kebutuhan = new Kebutuhan();
        kebutuhan.setId_kebutuhan(id_kebutuhan);
        kebutuhan.setKebutuhan(kebutuhan);
               
        dao.updateKebutuhan(kebutuhan);
        fireOnUpdate(kebutuhan);
    }
    
    public void deleteKebutuhan() throws SQLException, KebutuhanException {
        KebutuhanDao dao = Koneksi.getKebutuhanDao();
        
        dao.deleteKebutuhan(id_kebutuhan);
        fireOnDelete();
    }
    
    public void resetKebutuhan() throws SQLException {
        KebutuhanDao dao = Koneksi.getKebutuhanDao();
        setId_kebutuhan(dao.autoGenerateId());
        setKebutuhan("");
        }

    public void resetDonatur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
