/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.impl;

import id.dapoerberkahbandung.entity.Anggota;
import id.dapoerberkahbandung.error.AnggotaException;
import id.dapoerberkahbandung.service.AnggotaDao;
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
public class AnggotaDaoImpl implements AnggotaDao {
    
    private Connection connection;
    private final String insertAnggota = "INSERT INTO anggota(id_anggota, nama, alamat, no_telp) VALUES (?, ?, ?, ?)";
    private final String updateAnggota = "UPDATE anggota SET nama=?, alamat=?, no_telp=? WHERE id_anggota=?";
    private final String deleteAnggota = "DELETE FROM anggota WHERE id_anggota=?";
    private final String getAnggota = "SELECT * FROM anggota WHERE id_anggota=?";
    private final String selectAll = "SELECT * FROM anggota";
    
    
    public AnggotaDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    

    @Override
    public void insertAnggota(Anggota anggota) throws AnggotaException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertAnggota);
            statement.setString(1, anggota.getId_anggota());
            statement.setString(2, anggota.getNama());
            statement.setString(3, anggota.getAlamat());
            statement.setString(4, anggota.getNo_telp());
            statement.executeUpdate();
            connection.commit();
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new AnggotaException(e.getMessage());
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
    public void updateAnggota(Anggota anggota) throws AnggotaException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateAnggota);
            statement.setString(1, anggota.getNama());
            statement.setString(2, anggota.getAlamat());
            statement.setString(3, anggota.getNo_telp());
            statement.setString(4, anggota.getId_anggota());
            
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new AnggotaException(e.getMessage());
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
    public void deleteAnggota(String id_anggota) throws AnggotaException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteAnggota);
            statement.setString(1, id_anggota);
            
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new AnggotaException(e.getMessage());
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
    public Anggota getAnggota(String id_anggota) throws AnggotaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getAnggota);
            statement.setString(1, id_anggota);
            
            ResultSet result = statement.executeQuery();
            
            Anggota anggota = null;
            
            if (result.next()) {
                anggota = new Anggota();
                anggota.setId_anggota(result.getString("id_anggota"));
                anggota.setNama(result.getString("nama"));
                anggota.setAlamat(result.getString("alamat"));
                anggota.setNo_telp(result.getString("no_telp"));
            } else {
                throw new AnggotaException("Pelanggan dengan id anggota " + id_anggota + " tidak ditemukan!");
            }
            connection.commit();
            return anggota;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new AnggotaException(e.getMessage());
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
    public List<Anggota> selectAllAnggota() throws AnggotaException {
        Statement statement = null;
        List<Anggota> list = new ArrayList<Anggota>();
        
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            while (result.next()) {
                Anggota anggota = new Anggota();
                anggota.setId_anggota(result.getString("id_anggota"));
                anggota.setNama(result.getString("nama"));
                anggota.setAlamat(result.getString("alamat"));
                anggota.setNo_telp(result.getString("no_telp"));
                
                list.add(anggota);
            }
            connection.commit();
            return list;
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new AnggotaException(e.getMessage());
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
