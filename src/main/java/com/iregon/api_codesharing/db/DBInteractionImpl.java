package com.iregon.api_codesharing.db;

import com.iregon.api_codesharing.model.DatabaseCredentials;
import java.io.IOException;
import java.io.InputStream;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBInteractionImpl implements DBInteraction {

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private boolean isConnected = false;

    public DBInteractionImpl() {
    }

    public void connect() throws
            IOException,
            ClassNotFoundException,
            SQLException 
    {
        DatabaseCredentials credentials = this.readCredentials();

        String jdbcDriver = credentials.getDriver();
        String dbUrl = credentials.getUrl();
        String dbUser = credentials.getUsername();
        String dbPasswd = credentials.getPassword();

        Class.forName(jdbcDriver);
//        this.isConnected = true;
        this.conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
        this.isConnected = true;
    }

    public ResultSet excuteQuery(String query) {
        if (!isConnected) {
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);
            } catch (SQLException ex) {
                Logger.getLogger(DBInteractionImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return rs;
        }
        return null;
    }

    public void closeConnection() {
        try {
            if (stmt != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBInteractionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBInteractionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private DatabaseCredentials readCredentials() throws IOException {

        Properties properties = new Properties();
        DatabaseCredentials credentials = new DatabaseCredentials();
        InputStream fileStream = this.getClass().getClassLoader()
                .getResourceAsStream("database.conf");

        /*Reading properties... */
        properties.load(fileStream);
        credentials.setDriver(properties.getProperty("driver"));
        credentials.setUrl(properties.getProperty("url"));
        credentials.setUsername(properties.getProperty("username"));
        credentials.setPassword(properties.getProperty("password"));

        return credentials;
    }

}
