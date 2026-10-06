package org.example.www_tuan06_bai05.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DButil {

    private static DataSource dataSource;

    static {
        try {
            Context initContext = new InitialContext();

            Context envContext =
                    (Context) initContext.lookup("java:/comp/env");

            dataSource =
                    (DataSource) envContext.lookup("jdbc/EmployeeDB");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(
                    "Cannot initialize DataSource", e
            );
        }
    }

    public static Connection getConnection()
            throws SQLException {

        return dataSource.getConnection();
    }
}
