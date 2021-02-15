/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.view;

import id.dapoerberkahbandung.controller.PemasukanController;
import id.dapoerberkahbandung.database.Koneksi;
import id.dapoerberkahbandung.entity.Pemasukan;
import id.dapoerberkahbandung.error.PemasukanException;
import id.dapoerberkahbandung.event.PemasukanListener;
import id.dapoerberkahbandung.model.PemasukanModel;
import id.dapoerberkahbandung.model.TabelPemasukanModel;
import id.dapoerberkahbandung.service.PemasukanDao;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Dandi Ahmadin
 */
public class PemasukanView extends javax.swing.JPanel implements PemasukanListener, ListSelectionListener{

    /**
     * Creates new form PemasukanView
     */
    
    private TabelPemasukanModel tabelPemasukanModel;
    private PemasukanModel model;
    private PemasukanController controller;
    
    public PemasukanView() throws PemasukanException {
        initComponents();
        tabelPemasukanModel = new TabelPemasukanModel();
        model = new PemasukanModel();
        controller = new PemasukanController();
        
        
        
        model.setListener(this);
        controller.setModel(model);
        tabelPemasukan.getSelectionModel().addListSelectionListener(this);
        tabelPemasukan.setModel(tabelPemasukanModel);
    }

    public JTextField getTxtIdAnggota() {
        return txtIdAnggota;
    }

    public JTextField getTxtIdDonatur() {
        return txtIdDonatur;
    }

    public JTable getTabelPemasukan() {
        return tabelPemasukan;
    }

    public JTextField getTxtNoPemasukan() {
        return txtNoPemasukan;
    }

    public JTextField getTxtRekening() {
        return txtRekening;
    }

    public JTextField getTxtUangTunai() {
        return txtUangTunai;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        dataPemasukan = new javax.swing.JLabel();
        no_pemasukan = new javax.swing.JLabel();
        anggota = new javax.swing.JLabel();
        donatur = new javax.swing.JLabel();
        rekening = new javax.swing.JLabel();
        uangTunai = new javax.swing.JLabel();
        txtNoPemasukan = new javax.swing.JTextField();
        txtIdAnggota = new javax.swing.JTextField();
        txtIdDonatur = new javax.swing.JTextField();
        txtRekening = new javax.swing.JTextField();
        txtUangTunai = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPemasukan = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(250, 245, 224));
        setPreferredSize(new java.awt.Dimension(600, 480));

        dataPemasukan.setFont(new java.awt.Font("Century Gothic", 1, 26)); // NOI18N
        dataPemasukan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dataPemasukan.setText("DATA PEMASUKAN");

        no_pemasukan.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        no_pemasukan.setText("Nomor Pemasukan :");

        anggota.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        anggota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        anggota.setText("ID Anggota :");

        donatur.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        donatur.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        donatur.setText("ID Donatur :");

        rekening.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        rekening.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rekening.setText("Rekening :");

        uangTunai.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        uangTunai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        uangTunai.setText("Uang Tunai :");

        txtNoPemasukan.setEditable(false);
        txtNoPemasukan.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtNoPemasukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoPemasukanActionPerformed(evt);
            }
        });

        txtRekening.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        txtUangTunai.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        btnReset.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnTambah.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tabelPemasukan.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tabelPemasukan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane2.setViewportView(tabelPemasukan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataPemasukan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(anggota, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(donatur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rekening, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(uangTunai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtUangTunai, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtRekening, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdDonatur, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdAnggota, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(no_pemasukan)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNoPemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReset)
                                .addGap(18, 18, 18)
                                .addComponent(btnTambah)
                                .addGap(18, 18, 18)
                                .addComponent(btnUbah)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus)))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(dataPemasukan)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(no_pemasukan)
                    .addComponent(txtNoPemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(anggota)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIdAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdDonatur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(donatur))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRekening, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rekening))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUangTunai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uangTunai))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnTambah)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNoPemasukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoPemasukanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoPemasukanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        controller.resetPemasukan(this);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        controller.insertPemasukan(this);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        controller.updatePemasukan(this);
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        controller.deletePemasukan(this);
    }//GEN-LAST:event_btnHapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anggota;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel dataPemasukan;
    private javax.swing.JLabel donatur;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel no_pemasukan;
    private javax.swing.JLabel rekening;
    private javax.swing.JTable tabelPemasukan;
    private javax.swing.JTextField txtIdAnggota;
    private javax.swing.JTextField txtIdDonatur;
    private javax.swing.JTextField txtNoPemasukan;
    private javax.swing.JTextField txtRekening;
    private javax.swing.JTextField txtUangTunai;
    private javax.swing.JLabel uangTunai;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChange(PemasukanModel model) {
        txtNoPemasukan.setText(model.getNo_pemasukan() + "");
        txtIdAnggota.setText(model.getId_anggota());
        txtIdDonatur.setText(model.getId_donatur());
        txtRekening.setText(String.valueOf(model.getRekening()));
        txtUangTunai.setText(String.valueOf(model.getUang_tunai()));
    }

    @Override
    public void onInsert(Pemasukan pemasukan) {
        tabelPemasukanModel.add(pemasukan);
    }

    @Override
    public void onUpdate(Pemasukan pemasukan) {
        int index = tabelPemasukan.getSelectedRow();
        tabelPemasukanModel.set(index, pemasukan);
    }

    @Override
    public void onDelete() {
        int index = tabelPemasukan.getSelectedRow();
        tabelPemasukanModel.remove(index);
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        try {
            Pemasukan model = tabelPemasukanModel.get(tabelPemasukan.getSelectedRow());
            txtNoPemasukan.setText(model.getNo_pemasukan() + "");
            txtIdAnggota.setText(model.getId_anggota());
            txtIdDonatur.setText(model.getId_donatur());
            txtRekening.setText(model.getRekening() + "");
            txtUangTunai.setText(model.getUang_tunai() + "");
        } catch (IndexOutOfBoundsException exception) {
        }
    }
    
    public void loadDatabase() throws SQLException, PemasukanException {
        PemasukanDao dao = Koneksi.getPemasukanDao();
        tabelPemasukanModel.setList(dao.selectAllPemasukan());
        
    }
}