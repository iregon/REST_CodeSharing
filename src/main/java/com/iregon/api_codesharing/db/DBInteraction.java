package com.iregon.api_codesharing.db;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DBInteraction {

    void connect() throws
            IOException,
            ClassNotFoundException,
            SQLException;

    ResultSet excuteQuery(String query);

    void closeConnection();
}
