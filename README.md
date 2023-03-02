### Connection

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
```
# Get connection
```Java
protected Connection getConnection() {
        return connectionThreadLocal.get();
    }
```


## Maven driver

```Maven
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.5.3</version>
        </dependency>
```
