/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.impl;

import id.dapoerberkahbandung.entity.Pemasukan;
import id.dapoerberkahbandung.error.PemasukanException;
import id.dapoerberkahbandung.service.PemasukanDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dandi Ahmadin
 */
public class PemasukanDaoImpl implements PemasukanDao {
    
    private Connection connection;

    private final String insertPemasukan = "INSERT INTO pemasukan (id_anggota, id_donatur, rekening, uang_tunai) VALUES (?, ?, ?, ?)"; 
    private final String updatePemasukan = "UPDATE pemasukan SET id_anggota=?, id_donatur=?, rekening=?, uang_tunai=? WHERE no_pemasukan=?"; 
    private final String deletePemasukan = "DELETE FROM pemasukan WHERE no_pemasukan=?"; 
    private final String getNoPemasukan = "SELECT * FROM pemasukan WHERE no_pemasukan=?"; 
    private final String selectAllPemasukan = "SELECT pemasukan.no_pemasukan, anggota.id_anggota, donatur.id_donatur, pemasukan.rekening, pemasukan.uang_tunai FROM pemasukan, anggota, donatur WHERE pemasukan.id_anggota=anggota.id_anggota AND pemasukan.id_donatur=donatur.id_donatur";
    
    public PemasukanDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insertPemasukan(Pemasukan pemasukan) throws PemasukanException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPemasukan, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pemasukan.getId_anggota());
            statement.setString(2, pemasukan.getId_donatur());
            statement.setInt(3, pemasukan.getRekening());
            statement.setInt(4, pemasukan.getUang_tunai());
            statement.executeUpdate();
            
            ResultSet result = statement.getGeneratedKeys();
            
            if(result.next()) {
                pemasukan.setNo_pemasukan(result.getInt(1));
            }
            connection.commit();
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PemasukanException(e.getMessage());
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
    public void updatePemasukan(Pemasukan pemasukan) throws PemasukanException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePemasukan);
            statement.setString(1, pemasukan.getId_anggota());
            statement.setString(2, pemasukan.getId_donatur());
            statement.setInt(3, pemasukan.getRekening());
            statement.setInt(4, pemasukan.getUang_tunai());
            statement.setInt(5, pemasukan.getNo_pemasukan());
            statement.executeUpdate();
                     
            connection.commit();
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PemasukanException(e.getMessage());
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
    public void deletePemasukan(int no_pemasukan) throws PemasukanException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deletePemasukan);
            statement.setInt(1, no_pemasukan);
            statement.executeUpdate();
                     
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PemasukanException(e.getMessage());
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
    public Pemasukan getPemasukan(int no_pemasukan) throws PemasukanException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getNoPemasukan);
            statement.setInt(1, no_pemasukan);
            
            ResultSet result = statement.executeQuery();
            Pemasukan pemasukan = null;
            
            if(result.next()) {
                pemasukan.setNo_pemasukan(result.getInt("no_pemasukan"));
                pemasukan.setId_anggota(result.getString("id_anggota"));
                pemasukan.setId_donatur(result.getString("id_donatur"));
                pemasukan.setRekening(result.getInt("rekening"));
                pemasukan.setUang_tunai(result.getInt("uang_tunai"));
            } else {
                throw new PemasukanException("Nomor Pemasukan " + no_pemasukan + " tidak dapat ditemukan!");
            }
            connection.commit();
            return pemasukan;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PemasukanException(e.getMessage());
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
    public List<Pemasukan> selectAllPemasukan() throws PemasukanException {
        Statement statement = null;
        List<Pemasukan> list = new ArrayList<Pemasukan>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(selectAllPemasukan);
            Pemasukan pemasukan = null;
            
            while (result.next()) {
                pemasukan = new Pemasukan();
                pemasukan.setNo_pemasukan(result.getInt(1));
                pemasukan.setId_anggota(result.getString(2));
                pemasukan.setId_donatur(result.getString(3));
                pemasukan.setRekening(result.getInt(4));
                pemasukan.setUang_tunai(result.getInt(5));
                list.add(pemasukan);
            } 
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PemasukanException(e.getMessage());
            
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
