/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Fetin2017.Controller.DAO;

import br.com.Fetin2017.Controller.MySQLConnection;
import br.com.Fetin2017.Model.ONG;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Leonardo Saldanha
 */
public class ONGDAO {
    private MySQLConnection MySQLObject = new MySQLConnection();
    private Connection connection = MySQLObject.getMySQLConnection();
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private ONG ong;
    
    public void read() {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM ONG");
            
            System.out.println("\nREAD");
            
            writeResultSet(resultSet);  
        }
        catch (Exception e) {
            System.out.println("Could not read database. Error: " + e);
        }
        finally {
            close();
        }
    }
    
    public void insert(ONG ong) {
        try {
            this.ong = ong;
            
            statement = connection.prepareStatement("INSERT INTO ONG VALUES (default, ?, ?, ?, ?, ?, default)");
            preparedStatement.setString(1, ong.getName());
            preparedStatement.setString(2, ong.getSite_url());
            preparedStatement.setString(3, ong.getLatitude());
            preparedStatement.setString(4, ong.getLongitude());
            preparedStatement.setString(5, ong.getAddress());
            preparedStatement.executeUpdate();
            
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM ONG WHERE name= " + ong.getName() + " ; ");
            
            resultSet = preparedStatement.executeQuery();
            
            System.out.println("\nINSERT");
            
            writeResultSet(resultSet);
            //insert data
        }
        catch (Exception e) {
            System.out.println("Could not read database. Error: " + e);
        }
        finally {
            close();
        }
    }
    
    public void delete(String name) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM ONG WHERE name= ? ; ");
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            
            System.out.println("\nDELETE");
        }
        catch (Exception e) {
            System.out.println("Could not read database. Error: " + e);
        }
        finally {
            close();
        }
    }
    
    public void update(String name, ONG ong) {
        try {
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("select * from ONG where name= " + name + " ; ");
            
            statement = connection.prepareStatement("UPDATE ONG SET name=?, site-url=?, latitude=?, longitude=?, address=? WHERE name= " + name + " ; ");
            preparedStatement.setString(1, ong.getName());
            preparedStatement.setString(2, ong.getSite_url());
            preparedStatement.setString(3, ong.getLatitude());
            preparedStatement.setString(4, ong.getLongitude());
            preparedStatement.setString(5, ong.getAddress());
            preparedStatement.executeUpdate();
                        
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM ONG WHERE name= " + name + " ; ");
            
            resultSet = preparedStatement.executeQuery();
            
            System.out.println("\nUPDATE");
            
            writeResultSet(resultSet);  
        }
        catch (Exception e) {
            System.out.println("Could not read database. Error: " + e);
        }
        finally {
            close();
        }
    }
    
    public void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("idONG");
            String name = resultSet.getString("name");
            String site_url = resultSet.getString("site-url");
            String latitude = resultSet.getString("latitude");
            String longitude = resultSet.getString("longitude");
            String address = resultSet.getString("address");
            int location_id = resultSet.getInt("Location_idAddress");
            
            ong = new ONG(id, name, site_url, latitude, longitude, address, location_id);
            
            System.out.println("ID: " + ong.getId());
            System.out.println("Name: " + ong.getName());
            System.out.println("URL: " + ong.getSite_url());
            System.out.println("Latitude: " + ong.getLatitude());
            System.out.println("Longitude: " + ong.getLongitude());
            System.out.println("Address: " + ong.getAddress());
            System.out.println("Location ID: " + ong.getLocation_id());
        }
    }
    
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        catch (Exception e) {
            System.out.println("Could not close database.");
        }
    }
}
