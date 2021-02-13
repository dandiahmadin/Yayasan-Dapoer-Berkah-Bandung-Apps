/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.impl;

import id.dapoerberkahbandung.entity.Donatur;
import id.dapoerberkahbandung.error.DonaturException;
import id.dapoerberkahbandung.service.DonaturDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dandi Ahmadin
 */
public class DonaturDaoImpl implements DonaturDao{
    
    private Connection connection;
    private final String insertDonatur = "INSERT INTO donatur(id_donatur, nama, alamat, no_telp) VALUES (?, ?, ?, ?)";
    private final String updateDonatur = "UPDATE donatur SET nama=?, alamat=?, no_telp=? WHERE id_donatur=?";
    private final String deleteDonatur = "DELETE FROM donatur WHERE id_donatur=?";
    private final String getDonatur = "SELECT * FROM donatur WHERE id_donatur=?";
    private final String selectAll = "SELECT * FROM donatur";
    private final String autoInsertId = "SELECT id_donatur FROM donatur";
    private String id_no = "0000";
    private String id = null;
    
    public DonaturDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    
    @Override
    public void autoGenerateId() {
        Statement statement = null;
                
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(autoInsertId);
            
            if (result.last()) {
                id_no = result.getString("id_donatur");
                id_no = id_no.substring(1, 4);
            }
            
            Integer no = Integer.parseInt(id_no);
            no++;
            
            id = "A".concat(String.format("%03s", id_no));
            
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
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
    public void insertDonatur(Donatur donatur) throws DonaturException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertDonatur);
            statement.setString(1, donatur.getId_donatur());
            statement.setString(2, donatur.getNama());
            statement.setString(3, donatur.getAlamat());
            statement.setString(4, donatur.getNo_telp());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new DonaturException(e.getMessage());
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
    public void updateDonatur(Donatur donatur) throws DonaturException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateDonatur);
            statement.setString(1, donatur.getNama());
            statement.setString(2, donatur.getAlamat());
            statement.setString(3, donatur.getNo_telp());
            
            statement.setString(4, donatur.getId_donatur());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new DonaturException(e.getMessage());
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
    public void deleteDonatur(String id_donatur) throws DonaturException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteDonatur);
            statement.setString(1, id_donatur);
            
            statement.executeUpdate();
            
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new DonaturException(e.getMessage());

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

    @Override
    public Donatur getDonatur(String id_donatur) throws DonaturException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getDonatur);
            statement.setString(1, id_donatur);
            
            ResultSet result = statement.executeQuery();
            
            Donatur donatur = null;
            
            if (result.next()) {
                donatur = new Donatur();
                donatur.setId_donatur(result.getString("id_donatur"));
                donatur.setNama(result.getString("nama"));
                donatur.setAlamat(result.getString("alamat"));
                donatur.setNo_telp(result.getString("no_telp"));
            } else {
                throw new DonaturException("Pelanggan dengan id donatur" + id_donatur + " tidak ditemukan!");
            }
            connection.commit();
            return donatur;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new DonaturException(e.getMessage());
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

    @Override
    public List<Donatur> selectAllDonatur() throws DonaturException {
        Statement statement = null;
        List<Donatur> list = new ArrayList<Donatur>();
        
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            while (result.next()) {
                Donatur donatur = new Donatur();
                donatur.setId_donatur(result.getString("id_donatur"));
                donatur.setNama(result.getString("nama"));
                donatur.setAlamat(result.getString("alamat"));
                donatur.setNo_telp(result.getString("no_telp"));
                
                list.add(donatur);
            }
            connection.commit();
            return list;
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new DonaturException(e.getMessage());
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
