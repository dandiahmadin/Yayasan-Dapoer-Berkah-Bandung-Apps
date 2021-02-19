/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.impl;

import id.dapoerberkahbandung.error.PemasukanException;
import id.dapoerberkahbandung.error.PengeluaranException;
import id.dapoerberkahbandung.service.BerandaDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dandi Ahmadin
 */
public class BerandaDaoImpl implements BerandaDao{
    
    private Connection connection;
    private final String getSaldoPemasukan = "SELECT SUM(pemasukan.rekening) + SUM(pemasukan.uang_tunai) FROM pemasukan"; 
    private final String getSaldoPengeluaran = "SELECT SUM(pengeluaran.rekening) + SUM(pengeluaran.uang_tunai) FROM pengeluaran"; 

    public BerandaDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public int getSaldoPemasukan() throws PemasukanException{
        Statement statement = null;
        int hasil = 0;
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(getSaldoPemasukan);
            if(result.next()) {
                hasil = result.getInt(1);
            }
            connection.commit();
        } catch (SQLException e){
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
            
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
        return hasil;
    }

    @Override
    public int getSaldoPengeluaran() throws PengeluaranException{
        Statement statement = null;
        int hasil = 0;
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(getSaldoPengeluaran);
            if(result.next()) {
                hasil = result.getInt(1);
            }
            connection.commit();
        } catch (SQLException e){
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
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
        return hasil;
    }
    

    
    
}
