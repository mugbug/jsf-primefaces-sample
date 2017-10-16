/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Fetin2017.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Leonardo Saldanha
 */
public class MySQLConnection {
    public static String connectionStatus = "Could not establish connection.";
    
    public MySQLConnection() {
        
    }
    
    public static Connection getMySQLConnection() {
        Connection connection = null;
        
        try { 
            //Loading JDBC driver
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            
            //Database metadata
            String serverName = "localhost:3306";
            String database   = "mydb";
            String url = "jdbc:mysql://" + serverName + "/" + database + "?autoReconnect=true&useSSL=false";
            
            //Database instance credentials
            String username = "root";
            String password = "Petcovic10";
            
            connection = DriverManager.getConnection(url, username, password);
            
            //Connection test
            if (connection != null) {
                connectionStatus = "Database was connected succesfully";
                
            }
            else {
                connectionStatus = "Could not connect to database";
            }
            return connection;
        }
        catch (ClassNotFoundException e) {
            System.out.println("Driver not found. Error: " + e);
            return null;
        }
        catch (SQLException e) {
            System.out.println("Could not connect to database. Error: " + e);
            return null;
        }
    }
    
    //Returns the connection status
    public static String getConnectionStatus() {
        return connectionStatus;
    }
    
    public static boolean closeConnection() {
        try {
            MySQLConnection.getMySQLConnection().close();
            
            return true;
        }
        catch (SQLException e) {
            return false;
        }
    }
    
    public static Connection restartConnection() {
        closeConnection();
        return MySQLConnection.getMySQLConnection();
    }
}
