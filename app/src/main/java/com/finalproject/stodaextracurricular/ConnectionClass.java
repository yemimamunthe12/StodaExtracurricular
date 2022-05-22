package com.finalproject.stodaextracurricular;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    private static final String DEFAULT_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DEFAULT_URL = "jdbc:oracle:thin:@ec2-54-188-53-95.us-west-2.compute.amazonaws.com:1521:xe";
    private static final String DEFAULT_USERNAME = "hr";
    private static final String DEFAULT_PASSWORD = "mima";

    private Connection connection;

    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            createConnection();
        } catch (Exception se) {
            Log.e("ConnectionClass ->", se.getMessage());
        }
        return connection;
    }

    public void createConnection() {
        try {
            Class.forName(DEFAULT_DRIVER);
            this.connection = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
        } catch (ClassNotFoundException | java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}