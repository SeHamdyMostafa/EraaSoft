package org.student.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521/orclpdb";

    private static final String USER = "system";
    private static final String PASSWORD = "01281190072H@m";

    public static Connection getConnection() throws Exception {

        Class.forName("oracle.jdbc.OracleDriver");

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}