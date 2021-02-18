/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.impl;

import id.dapoerberkahbandung.entity.Anggota;
import id.dapoerberkahbandung.entity.Kebutuhan;
import id.dapoerberkahbandung.entity.Pengeluaran;
import id.dapoerberkahbandung.error.AnggotaException;
import id.dapoerberkahbandung.error.KebutuhanException;
import id.dapoerberkahbandung.error.PengeluaranException;
import id.dapoerberkahbandung.service.PengeluaranDao;
import java.sql.Connection;
import java.sql.Date;
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

    private final String insertPengeluaran = "INSERT INTO pengeluaran (tanggal, id_anggota, id_kebutuhan, rekening, uang_tunai) VALUES (?, ?, ?, ?, ?)";
    private final String updatePengeluaran = "UPDATE pengeluaran SET tanggal=?, id_anggota=?, id_kebutuhan=?, rekening=?, uang_tunai=? WHERE no_pengeluaran=?";
    private final String deletePengeluaran = "DELETE FROM pengeluaran WHERE no_pengeluaran=?";
    private final String getPengeluaran = "SELECT * FROM pengeluaran WHERE no_pengeluaran=?";
    private final String selectAllPengeluaran = "SELECT pengeluaran.no_pengeluaran, pengeluaran.tanggal, anggota.nama, kebutuhan.nama, pengeluaran.rekening, pengeluaran.uang_tunai FROM pengeluaran, anggota, kebutuhan WHERE pengeluaran.id_anggota = anggota.id_anggota AND pengeluaran.id_kebutuhan = kebutuhan.id_kebutuhan";
    private final String selectNameAnggota = "SELECT nama FROM anggota ORDER BY nama";
    private final String selectNameKebutuhan = "SELECT nama FROM kebutuhan ORDER BY nama";
    private final String getIdAnggota = "SELECT id_anggota FROM anggota WHERE nama=?";
    private final String getIdKebutuhan = "SELECT id_kebutuhan FROM kebutuhan WHERE nama=?";
    
    public PengeluaranDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insertPengeluaran(Pengeluaran pengeluaran) throws PengeluaranException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPengeluaran, Statement.RETURN_GENERATED_KEYS);
            Date dateSQL = new Date(pengeluaran.getTanggal().getTime());
            statement.setDate(1, dateSQL);
            statement.setString(2, pengeluaran.getId_anggota());
            statement.setString(3, pengeluaran.getId_kebutuhan());
            statement.setInt(4, pengeluaran.getRekening());
            statement.setInt(5, pengeluaran.getUang_tunai());
            
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
            Date dateSQL = new Date(pengeluaran.getTanggal().getTime());
            statement.setDate(1, dateSQL);
            statement.setString(2, pengeluaran.getId_anggota());
            statement.setString(3, pengeluaran.getId_kebutuhan());
            statement.setInt(4, pengeluaran.getRekening());
            statement.setInt(5, pengeluaran.getUang_tunai());
            statement.setInt(6, pengeluaran.getNo_pengeluaran());
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
                pengeluaran.setTanggal(result.getDate("tanggal"));
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
                pengeluaran.setTanggal(result.getDate(2));
                pengeluaran.setId_anggota(result.getString(3));
                pengeluaran.setId_kebutuhan(result.getString(4));
                pengeluaran.setRekening(result.getInt(5));
                pengeluaran.setUang_tunai(result.getInt(6));
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

    @Override
    public List<Anggota> selectNameAnggota() throws AnggotaException {
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
            
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public List<Kebutuhan> selectNameKebutuhan() throws KebutuhanException {
        Statement statement = null;
        List<Kebutuhan> list = new ArrayList<Kebutuhan>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectNameKebutuhan);
            Kebutuhan kebutuhan = null;
            while (result.next()) {
                kebutuhan = new Kebutuhan();
                kebutuhan.setNama_kebutuhan(result.getString("nama"));
                list.add(kebutuhan);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new KebutuhanException(e.getMessage());
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
        } catch (AnggotaException | SQLException e) {
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
    public Kebutuhan getIdKebutuhan(String nama) throws KebutuhanException {
       PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getIdKebutuhan);
            statement.setString(1, nama);
            
            ResultSet result = statement.executeQuery();
            Kebutuhan kebutuhan = null;
            
            if(result.next()) {
                kebutuhan = new Kebutuhan();
                kebutuhan.setId_kebutuhan(result.getString("id_kebutuhan"));
            } else {
                throw new KebutuhanException("Kebutuhan dengan nama : " + nama + " tidak dapat ditemukan!");
            }
            connection.commit();
            return kebutuhan;
        } catch (KebutuhanException | SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new KebutuhanException(e.getMessage());
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
