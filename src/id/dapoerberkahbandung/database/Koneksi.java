/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import id.dapoerberkahbandung.impl.AnggotaDaoImpl;
import id.dapoerberkahbandung.service.AnggotaDao;
import java.sql.SQLException;

/**
 *
 * @author Dandi Ahmadin
 */
public class Koneksi {
    private static Connection connection;
    private static AnggotaDao anggotaDao;
    
    public static Connection getConnection() throws SQLException {
        if(connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/yayasan_dapoer_berkah_bandung");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = (Connection) dataSource.getConnection();
        }
        
        return connection;
    }
    
    public static AnggotaDao getAnggotaDao() throws SQLException {
        if (anggotaDao == null) {
            anggotaDao = new AnggotaDaoImpl(getConnection());
        }
        
        return anggotaDao;
    }
    
}
