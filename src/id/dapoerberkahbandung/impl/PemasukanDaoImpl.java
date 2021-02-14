/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.impl;

import com.mysql.jdbc.Statement;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import id.dapoerberkahbandung.entity.Pemasukan;
import id.dapoerberkahbandung.error.PemasukanException;
import id.dapoerberkahbandung.service.PemasukanDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dandi Ahmadin
 */
public class PemasukanDaoImpl implements PemasukanDao {
    
    private Connection connection;
    
    private final String insertPemasukan = "INSERT INTO pemasukan (tanggal, id_anggota, id_donatur, rekening, uang_tunai) VALUES (?, ?, ?, ?, ?)"; 
    
    public PemasukanDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insertPemasukan(Pemasukan pemasukan) throws PemasukanException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPemasukan, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, pemasukan.getTanggal());
            statement.setString(2, pemasukan.getAnggota().getId_anggota());
            statement.setString(3, pemasukan.getDonatur().getId_donatur());
            statement.setInt(4, pemasukan.getRekening());
            statement.setInt(5, pemasukan.getTunai());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePemasukan(String no_pemasukan) throws PemasukanException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pemasukan getPemasukan(String no_pemasukan) throws PemasukanException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pemasukan> selectAllPemasukan() throws PemasukanException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
