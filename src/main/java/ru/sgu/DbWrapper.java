package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbWrapper {
    private String jdbcUrl;
    private String username;
    private String password;

    private Connection connection;
    private Statement statement;

    public DbWrapper(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection(
                this.jdbcUrl,
                this.username,
                this.password
        );

        this.statement = this.connection.createStatement();
    }

    public void close() throws SQLException {
        connection.close();
        statement.close();
    }

    public List<List<String>> executeQuery(String query, List<String> fields) throws SQLException {
        ResultSet resultSet = this.statement.executeQuery(query);

        List<List<String>> res = new ArrayList<>();
        while (resultSet.next()) {
            List<String> row = new ArrayList<>();
            for (String field : fields) {
                row.add(resultSet.getString(field));
            }
            res.add(row);
        }

        return res;
    }
}
