/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.main;

import id.dapoerberkahbandung.error.AnggotaException;
import id.dapoerberkahbandung.view.MainView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;


/**
 *
 * @author Dandi Ahmadin
 */
public class YayasanDapoerBerkahBandung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, AnggotaException {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainView mainView = new MainView();
                    mainView.loadDatabase();
                    mainView.setVisible(true);
                } catch (SQLException e) {
                } catch (AnggotaException ex) {
                    Logger.getLogger(YayasanDapoerBerkahBandung.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }
    
}
