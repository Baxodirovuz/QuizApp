### QuizApp

```Java
 private final ThreadLocal<Connection> connectionThreadLocal = ThreadLocal.withInitial(
            () -> {
                try {
                    DriverManager.registerDriver(new Driver());
                    return DriverManager.getConnection(
                            "database.url",
                            "database.username",
                            "database.password"
                    );
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
    );
