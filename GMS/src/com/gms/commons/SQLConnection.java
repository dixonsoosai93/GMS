package com.gms.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLConnection {

    static {
        try {
            Class.forName(DBConfig.SQL_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection() throws SQLException {
        Connection con =  DriverManager.getConnection(DBConfig.SQL_CONNECTION_URL, DBConfig.SQL_USERNAME, DBConfig.SQL_PASSWORD);
        return con;
    }
    
    public static void closeConnection(Connection con) throws SQLException {
        con.close();
    }
    
    public static void closeStatement(Statement st) throws SQLException {
        st.close();
    }
    
    public static void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }
}