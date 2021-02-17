/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.impl;

import id.dapoerberkahbandung.entity.Anggota;
import id.dapoerberkahbandung.entity.Donatur;
import id.dapoerberkahbandung.entity.Pemasukan;
import id.dapoerberkahbandung.error.AnggotaException;
import id.dapoerberkahbandung.error.DonaturException;
import id.dapoerberkahbandung.error.PemasukanException;
import id.dapoerberkahbandung.service.PemasukanDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dandi Ahmadin
 */
public class PemasukanDaoImpl implements PemasukanDao {
    
    private Connection connection;

    private final String insertPemasukan = "INSERT INTO pemasukan (tanggal, id_anggota, id_donatur, rekening, uang_tunai) VALUES (?, ?, ?, ?, ?)"; 
    private final String updatePemasukan = "UPDATE pemasukan SET tanggal=?, id_anggota=?, id_donatur=?, rekening=?, uang_tunai=? WHERE no_pemasukan=?"; 
    private final String deletePemasukan = "DELETE FROM pemasukan WHERE no_pemasukan=?"; 
    private final String getNoPemasukan = "SELECT * FROM pemasukan WHERE no_pemasukan=?"; 
    private final String selectAllPemasukan = "SELECT pemasukan.no_pemasukan, pemasukan.tanggal, anggota.nama, donatur.nama, pemasukan.rekening, pemasukan.uang_tunai FROM pemasukan, anggota, donatur WHERE pemasukan.id_anggota=anggota.id_anggota AND pemasukan.id_donatur=donatur.id_donatur ORDER BY no_pemasukan";
    private final String selectNameAnggota = "SELECT nama FROM anggota ORDER BY nama";
    private final String getIdAnggota = "SELECT id_anggota FROM anggota WHERE nama=?";
    private final String selectNameDonatur = "SELECT nama FROM donatur ORDER BY nama";
    private final String getIdDonatur = "SELECT id_donatur FROM donatur WHERE nama=?";
    
    public PemasukanDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insertPemasukan(Pemasukan pemasukan) throws PemasukanException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPemasukan, Statement.RETURN_GENERATED_KEYS);
            Date dateSQL = new Date(pemasukan.getTanggal().getTime());
            statement.setDate(1, dateSQL);
            statement.setString(2, pemasukan.getId_anggota());
            statement.setString(3, pemasukan.getId_donatur());
            statement.setInt(4, pemasukan.getRekening());
            statement.setInt(5, pemasukan.getUang_tunai());
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
            Date dateSQL = new Date(pemasukan.getTanggal().getTime());
            statement.setDate(1, dateSQL);
            statement.setString(2, pemasukan.getId_anggota());
            statement.setString(3, pemasukan.getId_donatur());
            statement.setInt(4, pemasukan.getRekening());
            statement.setInt(5, pemasukan.getUang_tunai());
            statement.setInt(6, pemasukan.getNo_pemasukan());
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
                pemasukan.setTanggal(result.getDate("tanggal"));
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
                pemasukan.setTanggal(result.getDate(2));
                pemasukan.setId_anggota(result.getString(3));
                pemasukan.setId_donatur(result.getString(4));
                pemasukan.setRekening(result.getInt(5));
                pemasukan.setUang_tunai(result.getInt(6));
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
    
    @Override
    public List<Anggota> selectNameAnggota() throws AnggotaException{
        Statement statement = null;
        List<Anggota> list = new ArrayList<Anggota>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectNameAnggota);
            Anggota anggota = null;
            while (result.next()) {
                anggota = new Anggota();
                anggota.setNama(result.getString("nama"));
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
    
    @Override
    public Anggota getIdAnggota(String nama) throws AnggotaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getIdAnggota);
            statement.setString(1, nama);
            
            ResultSet result = statement.executeQuery();
            
            Anggota anggota = null;
            if(result.next()) {
                anggota = new Anggota();
                anggota.setId_anggota(result.getString("id_anggota"));
            } else {
                throw new AnggotaException("Anggota dengan nama : " + nama + " tidak dapat ditemukan!");
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
            
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public List<Donatur> selectNameDonatur() throws DonaturException {
        Statement statement = null;
        List<Donatur> list = new ArrayList<Donatur>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectNameDonatur);
            Donatur donatur = null;
            while (result.next()) {
                donatur = new Donatur();
                donatur.setNama(result.getString("nama"));
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
    
    @Override
    public Donatur getIdDonatur(String nama) throws DonaturException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getIdDonatur);
            statement.setString(1, nama);
            
            ResultSet result = statement.executeQuery();
            
            Donatur donatur = null;
            if(result.next()) {
                donatur = new Donatur();
                donatur.setId_donatur(result.getString("id_donatur"));
            } else {
                throw new DonaturException("Donatur dengan nama : " + nama + " tidak dapat ditemukan!");
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
            
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

}
