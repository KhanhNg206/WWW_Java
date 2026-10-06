package org.example.www_tuan06_bai06.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

    private static final String URL =
            "jdbc:mariadb://localhost:3306/QUANLYDANHMUC";

    private static final String USER = "root";
    private static final String PASSWORD = "sapassword";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("MARIADB DRIVER OK");
        } catch (ClassNotFoundException e) {
            System.out.println("MARIADB DRIVER NOT FOUND");
            e.printStackTrace();
        }

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}
