package io.muic.ooc.basicLogin;

import java.sql.*;

/**
 * Created by Thanaphat on 11/2/2560.
 */
public class MySQL {
    enum TestTableColumns {
        id, name
    }

    private final String jdbcDriverStr;
    private final String jdbcURL;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public MySQL(String jdbcDriverStr, String jdbcURL) {
        this.jdbcDriverStr = jdbcDriverStr;
        this.jdbcURL = jdbcURL;
    }

    public void readData() throws Exception {
        try {
            Class.forName(jdbcDriverStr);
            connection = DriverManager.getConnection(jdbcURL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from webapp.test_table;");
            getResultSet(resultSet);
            preparedStatement = connection.prepareStatement("insert into webapp.test_table values (default,?)");
            preparedStatement.setString(1, "insert test from java");
            preparedStatement.executeUpdate();
        } finally {
            close();
        }
    }

    private void getResultSet(ResultSet resultSet) throws Exception {
        while (resultSet.next()) {
            Integer id = resultSet.getInt(TestTableColumns.id.toString());
            String text = resultSet.getString(TestTableColumns.name.toString());
            System.out.println("id: " + id);
            System.out.println("text: " + text);
        }
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
        }
    }
}
