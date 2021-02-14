/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.view;

import id.dapoerberkahbandung.controller.AnggotaController;
import id.dapoerberkahbandung.database.Koneksi;
import id.dapoerberkahbandung.entity.Anggota;
import id.dapoerberkahbandung.error.AnggotaException;
import id.dapoerberkahbandung.event.AnggotaListener;
import id.dapoerberkahbandung.model.AnggotaModel;
import id.dapoerberkahbandung.model.TabelAnggotaModel;
import id.dapoerberkahbandung.service.AnggotaDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Dandi Ahmadin
 */
public class AnggotaView extends javax.swing.JPanel implements AnggotaListener, ListSelectionListener {

    /**
     * Creates new form AnggotaView
     */
    
    private TabelAnggotaModel tabelAnggotaModel;
    private AnggotaModel model;
    private AnggotaController controller;
    
    public AnggotaView() throws SQLException {
        
        tabelAnggotaModel = new TabelAnggotaModel();
        model = new AnggotaModel();
        model.setListener(this);
        
        controller = new AnggotaController();
        controller.setModel(model);
        initComponents();
        tabelAnggota.setModel(tabelAnggotaModel);
        tabelAnggota.getSelectionModel().addListSelectionListener(this);
        
        model.resetAnggota();
    }

    public JTable getTabelAnggota() {
        return tabelAnggota;
    }

    public JTextArea getTxtAlamat() {
        return txtAlamat;
    }

    public JTextField getTxtIdAnggota() {
        return txtIdAnggota;
    }

    public JTextField getTxtNama() {
        return txtNama;
    }

    public JTextField getTxtNoTelp() {
        return txtNoTelp;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataAnggota = new javax.swing.JLabel();
        idAnggota = new javax.swing.JLabel();
        txtIdAnggota = new javax.swing.JTextField();
        nama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        alamat = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        noTelp = new javax.swing.JLabel();
        txtNoTelp = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelAnggota = new javax.swing.JTable();

        setBackground(new java.awt.Color(250, 245, 224));
        setPreferredSize(new java.awt.Dimension(600, 480));

        dataAnggota.setFont(new java.awt.Font("Century Gothic", 1, 26)); // NOI18N
        dataAnggota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dataAnggota.setText("Data Anggota");

        idAnggota.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        idAnggota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        idAnggota.setText("ID Anggota :");

        txtIdAnggota.setEditable(false);
        txtIdAnggota.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        nama.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nama.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nama.setText("Nama :");

        txtNama.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        alamat.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        alamat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        alamat.setText("Alamat :");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtAlamat.setColumns(20);
        txtAlamat.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtAlamat.setRows(5);
        jScrollPane2.setViewportView(txtAlamat);

        noTelp.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        noTelp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        noTelp.setText("Nomor Telepon :");

        txtNoTelp.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtNoTelp.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        btnReset.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnInsert.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnInsert.setText("Tambah");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnUpdate.setText("Ubah");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tabelAnggota.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelAnggota);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataAnggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(noTelp)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReset)
                                .addGap(18, 18, 18)
                                .addComponent(btnInsert)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete))
                            .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(dataAnggota)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idAnggota)
                    .addComponent(txtIdAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nama)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alamat)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noTelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnReset)
                    .addComponent(btnInsert)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
            // TODO add your handling code here:
        try {
            controller.resetAnggota(this);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        controller.insertAnggota(this);
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        controller.updateAnggota(this);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        controller.deleteAnggota(this);
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamat;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel dataAnggota;
    private javax.swing.JLabel idAnggota;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel noTelp;
    private javax.swing.JTable tabelAnggota;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtIdAnggota;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoTelp;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChange(AnggotaModel model) {
        txtIdAnggota.setText(model.getId_anggota());
        txtNama.setText(model.getNama());
        txtAlamat.setText(model.getAlamat());
        txtNoTelp.setText(model.getNo_telp());
    }

    @Override
    public void onInsert(Anggota anggota) {
        tabelAnggotaModel.add(anggota);
    }

    @Override
    public void onUpdate(Anggota anggota) {
        int index = tabelAnggota.getSelectedRow();
        tabelAnggotaModel.set(index, anggota);
    }

    @Override
    public void onDelete() {
        int index = tabelAnggota.getSelectedRow();
        tabelAnggotaModel.remove(index);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        try {
            Anggota model = tabelAnggotaModel.get(tabelAnggota.getSelectedRow());
            txtIdAnggota.setText(model.getId_anggota());
            txtNama.setText(model.getNama());
            txtAlamat.setText(model.getAlamat());
            txtNoTelp.setText(model.getNo_telp());
            
        } catch (IndexOutOfBoundsException ex) {
        }
    }
    
    public void loadDatabase() throws SQLException, AnggotaException {
        AnggotaDao dao = Koneksi.getAnggotaDao();
        tabelAnggotaModel.setList(dao.selectAllAnggota());
    }
}
