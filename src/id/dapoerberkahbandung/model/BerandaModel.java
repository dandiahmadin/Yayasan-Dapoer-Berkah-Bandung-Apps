/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.model;

import com.sun.javafx.binding.StringFormatter;
import id.dapoerberkahbandung.database.Koneksi;
import id.dapoerberkahbandung.error.PemasukanException;
import id.dapoerberkahbandung.error.PengeluaranException;
import id.dapoerberkahbandung.service.BerandaDao;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author Dandi Ahmadin
 */
public class BerandaModel {
    private String saldo, saldoPemasukan, saldoPengeluaran;
    
    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getSaldoPemasukan() {
        return saldoPemasukan;
    }

    public void setSaldoPemasukan(String saldoPemasukan) {
        this.saldoPemasukan = saldoPemasukan;
    }

    public String getSaldoPengeluaran() {
        return saldoPengeluaran;
    }

    public void setSaldoPengeluaran(String saldoPengeluaran) {
        this.saldoPengeluaran = saldoPengeluaran;
    }
   
    public String getSaldoAll() throws SQLException, PemasukanException, PengeluaranException {
        BerandaDao dao = Koneksi.getBerandaDao();
        
        DecimalFormat kurs = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols simbol = new DecimalFormatSymbols();
        simbol.setCurrencySymbol("Rp ");
        simbol.setGroupingSeparator('.');
        kurs.setDecimalFormatSymbols(simbol);

        setSaldo(kurs.format(dao.getSaldoPemasukan()-dao.getSaldoPengeluaran()).replaceAll(",00", ""));
        return getSaldo();
    }
    
    public String getSaldoPemasukanAll() throws SQLException, PemasukanException {
        BerandaDao dao = Koneksi.getBerandaDao();

        DecimalFormat kurs = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols simbol = new DecimalFormatSymbols();
        simbol.setCurrencySymbol("Rp ");
        simbol.setGroupingSeparator('.');
        kurs.setDecimalFormatSymbols(simbol);
        
        setSaldoPemasukan(kurs.format(dao.getSaldoPemasukan()).replaceAll(",00", ""));
        return getSaldoPemasukan();
    }
    
    public String getSaldoPengeluaranAll() throws SQLException, PengeluaranException {
        BerandaDao dao = Koneksi.getBerandaDao();
        
        DecimalFormat kurs = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols simbol = new DecimalFormatSymbols();
        simbol.setCurrencySymbol("Rp ");
        simbol.setGroupingSeparator('.');
        kurs.setDecimalFormatSymbols(simbol);

        setSaldoPengeluaran(kurs.format(dao.getSaldoPengeluaran()).replaceAll(",00", ""));
        return getSaldoPengeluaran();
    }
}
