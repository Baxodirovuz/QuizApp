package dao;

import org.postgresql.Driver;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO<T, ID> {
    private static final ThreadLocal<Connection> connectionThreadLocal = ThreadLocal.withInitial(
            () -> {
                try {
                    DriverManager.registerDriver(new Driver());
                    return DriverManager.getConnection(
                            "jdbc:postgresql://localhost:5432/quiz_app?currentSchema=structure",
                            "postgres",
                            "root123"
                    );
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
    );


    protected static Connection getConnection() {
        return connectionThreadLocal.get();
    }
}
