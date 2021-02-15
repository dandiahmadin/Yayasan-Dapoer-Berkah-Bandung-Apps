/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import id.dapoerberkahbandung.impl.AnggotaDaoImpl;
import id.dapoerberkahbandung.impl.DonaturDaoImpl;
import id.dapoerberkahbandung.impl.KebutuhanDaoImpl;
import id.dapoerberkahbandung.impl.PemasukanDaoImpl;
import id.dapoerberkahbandung.service.AnggotaDao;
import id.dapoerberkahbandung.service.DonaturDao;
import id.dapoerberkahbandung.service.KebutuhanDao;
import id.dapoerberkahbandung.service.PemasukanDao;
import java.sql.SQLException;

/**
 *
 * @author Alfi Nurizkya
 */
public class Koneksi {
    private static Connection connection;
    private static AnggotaDao anggotaDao;
    private static DonaturDao donaturDao;
    private static KebutuhanDao kebutuhanDao;
    private static PemasukanDao pemasukanDao;
    
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
    
    public static DonaturDao getDonaturDao() throws SQLException {
        if (donaturDao == null) {
            donaturDao = new DonaturDaoImpl(getConnection());
        }
        
        return donaturDao;
    }
    
    public static KebutuhanDao getKebutuhanDao() throws SQLException {
        if (kebutuhanDao == null) {
            kebutuhanDao = new KebutuhanDaoImpl(getConnection());
        }
        
        return kebutuhanDao;
    }

    public static PemasukanDao getPemasukanDao() throws SQLException {
        if (pemasukanDao == null) {
            pemasukanDao = new PemasukanDaoImpl(getConnection());
        }
        
        return pemasukanDao;
    }

}
