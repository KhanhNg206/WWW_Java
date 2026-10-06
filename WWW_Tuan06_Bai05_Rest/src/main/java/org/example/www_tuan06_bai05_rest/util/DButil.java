package org.example.www_tuan06_bai05_rest.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

    private static final String URL =
            "jdbc:mariadb://localhost:3306/employee_management";

    private static final String USER = "root";

    private static final String PASSWORD = "sapassword";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không tìm thấy MariaDB JDBC Driver", e);
        }

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}
