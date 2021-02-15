/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.impl;

import id.dapoerberkahbandung.entity.Pengeluaran;
import id.dapoerberkahbandung.error.PengeluaranException;
import id.dapoerberkahbandung.service.PengeluaranDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alfi Nurizkya
 */
public class PengeluaranDaoImpl implements PengeluaranDao{
    
    private Connection connection;

    private final String insertPengeluaran = "INSERT INTO pengeluaran (id_anggota, id_kebutuhan, rekening, uang_tunai) VALUES (?, ?, ?, ?)";
    private final String updatePengeluaran = "UPDATE pengeluaran SET id_anggota=?, id_kebutuhan=?, rekening=?, uang_tunai=? WHERE no_pengeluaran=?";
    private final String deletePengeluaran = "DELETE FROM pengeluaran WHERE no_pengeluaran=?";
    private final String getPengeluaran = "SELECT * FROM pengeluaran WHERE no_pengeluaran=?";
    private final String selectAllPengeluaran = "SELECT * FROM pengeluaran";
    
    public PengeluaranDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insertPengeluaran(Pengeluaran pengeluaran) throws PengeluaranException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPengeluaran, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, pengeluaran.getId_anggota());
            statement.setString(2, pengeluaran.getId_kebutuhan());
            statement.setInt(3, pengeluaran.getRekening());
            statement.setInt(4, pengeluaran.getUang_tunai());
            
            statement.executeUpdate();
            
            ResultSet result = statement.getGeneratedKeys();
            
            if(result.next()) {
                pengeluaran.setNo_pengeluaran(result.getInt(1));
            }
            
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PengeluaranException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }
            
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void updatePengeluaran(Pengeluaran pengeluaran) throws PengeluaranException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePengeluaran);
            
            statement.setString(1, pengeluaran.getId_anggota());
            statement.setString(2, pengeluaran.getId_kebutuhan());
            statement.setInt(3, pengeluaran.getRekening());
            statement.setInt(4, pengeluaran.getUang_tunai());
            statement.setInt(5, pengeluaran.getNo_pengeluaran());
            statement.executeUpdate();
            
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PengeluaranException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }
            
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void deletePengeluaran(int no_pengeluaran) throws PengeluaranException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deletePengeluaran);
            statement.setInt(1, no_pengeluaran);
            statement.executeUpdate();
                     
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PengeluaranException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }
            
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    @Override
    public Pengeluaran getPengeluaran(int no_pengeluaran) throws PengeluaranException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getPengeluaran);
            statement.setInt(1, no_pengeluaran);
            
            ResultSet result = statement.executeQuery();
            Pengeluaran pengeluaran = null;
            
            if(result.next()) {
                pengeluaran.setNo_pengeluaran(result.getInt("no_pengeluaran"));
                pengeluaran.setId_anggota(result.getString("id_anggota"));
                pengeluaran.setId_kebutuhan(result.getString("id_kebutuhan"));
                pengeluaran.setRekening(result.getInt("rekening"));
                pengeluaran.setUang_tunai(result.getInt("uang_tunai"));
            } else {
                throw new PengeluaranException("Nomor Pemasukan " + no_pengeluaran + " tidak dapat ditemukan!");
            }
            connection.commit();
            return pengeluaran;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PengeluaranException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }
            
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    @Override
    public List<Pengeluaran> selectAllPengeluaran() throws PengeluaranException {
        Statement statement = null;
        List<Pengeluaran> list = new ArrayList<Pengeluaran>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(selectAllPengeluaran);
            Pengeluaran pengeluaran = null;
            
            while (result.next()) {
                pengeluaran = new Pengeluaran();
                pengeluaran.setNo_pengeluaran(result.getInt(1));
                pengeluaran.setId_anggota(result.getString(2));
                pengeluaran.setId_kebutuhan(result.getString(3));
                pengeluaran.setRekening(result.getInt(4));
                pengeluaran.setUang_tunai(result.getInt(5));
                list.add(pengeluaran);
            } 
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PengeluaranException(e.getMessage());
            
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
}
