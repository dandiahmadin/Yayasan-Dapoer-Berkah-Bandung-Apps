/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.main;

import id.dapoerberkahbandung.view.MainView;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dandi Ahmadin
 */
public class YayasanDapoerBerkahBandung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainView mainView = new MainView();
                mainView.setVisible(true);
                
            }
            
        }); 

    }
    
}
