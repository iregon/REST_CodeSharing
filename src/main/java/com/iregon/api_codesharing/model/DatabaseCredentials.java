package com.iregon.api_codesharing.model;

/**
 * Class that contains database's connection informations
 * like JDBC Driver used, database url, username and password
 * @author Alessandro
 */
public class DatabaseCredentials {

    private String driver, url, username, password;

    public DatabaseCredentials() {
    }
    
    public String getDriver() {
        return driver;
    }
    
    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
