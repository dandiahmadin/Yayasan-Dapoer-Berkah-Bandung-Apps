/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.dapoerberkahbandung.impl;

import id.dapoerberkahbandung.entity.Kebutuhan;
import id.dapoerberkahbandung.error.KebutuhanException;
import id.dapoerberkahbandung.service.KebutuhanDao;
import java.sql.Connection;
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
public class KebutuhanDaoImpl implements KebutuhanDao{
    
    private Connection connection;
    private final String insertKebutuhan = "INSERT INTO kebutuhan(id_kebutuhan, kebutuhan) VALUES (?, ?)";
    private final String updateKebutuhan = "UPDATE kebutuhan SET kebutuhan=? WHERE id_kebutuhan=?";
    private final String deleteKebutuhan = "DELETE FROM kebutuhan WHERE id_kebutuhan=?";
    private final String getKebutuhan = "SELECT * FROM kebutuhan WHERE id_kebutuhan=?";
    private final String selectAll = "SELECT * FROM kebutuhan";
    private final String autoInsertId = "SELECT id_kebutuhan FROM kebutuhan";
    private String id_no = "0000";
    private String id = null;
    
    public KebutuhanDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    
    @Override
    public String autoGenerateId() {
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
            
            id = "D".concat(String.format("%03d", no));
            
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
        return id;
 
    }

    @Override
    public void insertKebutuhan(Kebutuhan kebutuhan) throws KebutuhanException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertKebutuhan);
            statement.setString(1, kebutuhan.getId_kebutuhan());
            statement.setString(2, kebutuhan.getKebutuhan());
            statement.executeUpdate();
            connection.commit();
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
    public void updateKebutuhan(Kebutuhan kebutuhan) throws KebutuhanException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateKebutuhan);
            statement.setString(1, kebutuhan.getKebutuhan());
                        
            statement.setString(4, kebutuhan.getId_kebutuhan());
            statement.executeUpdate();
            connection.commit();
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
    public void deleteKebutuhan(String id_kebutuhan) throws KebutuhanException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteKebutuhan);
            statement.setString(1, id_kebutuhan);
            
            statement.executeUpdate();
            
            connection.commit();
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
            
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public Kebutuhan getKebutuhan(String id_kebutuhan) throws KebutuhanException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getKebutuhan);
            statement.setString(1, id_kebutuhan);
            
            ResultSet result = statement.executeQuery();
            
            Kebutuhan kebutuhan = null;
            
            if (result.next()) {
                kebutuhan = new Kebutuhan();
                kebutuhan.setId_kebutuhan(result.getString("id_kebutuhan"));
                kebutuhan.setKebutuhan(result.getString("kebutuhan"));
                } else {
                throw new KebutuhanException("Kebutuhan dengan id kebutuhan" + id_kebutuhan + " tidak ditemukan!");
            }
            connection.commit();
            return kebutuhan;
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
            
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public List<Kebutuhan> selectAllKebutuhan() throws KebutuhanException {
        Statement statement = null;
        List<Kebutuhan> list = new ArrayList<Kebutuhan>();
        
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            while (result.next()) {
                Kebutuhan kebutuhan = new Kebutuhan();
                kebutuhan.setId_kebutuhan(result.getString("id_kebutuhan"));
                kebutuhan.setKebutuhan(result.getString("kebutuhan"));
                               
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
            
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
}
