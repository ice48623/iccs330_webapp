package io.muic.ooc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thanaphat on 11/2/2560.
 */
public class MySQL {

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

//    public void readData() throws Exception {
//        try {
//            Class.forName(jdbcDriverStr);
//            connection = DriverManager.getConnection(jdbcURL);
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("select * from webapp.user_account;");
//            getResultSet(resultSet);
////            preparedStatement = connection.prepareStatement("insert into webapp.user_account values (default,?)");
////            preparedStatement.setString(1, "insert test from java");
////            preparedStatement.executeUpdate();
//        } finally {
//            close();
//        }
//    }

    private void getResultSet(ResultSet resultSet) throws Exception {
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String text = resultSet.getString("username");
            System.out.println("id: " + id);
            System.out.println("text: " + text);
        }
    }

    public Boolean isValidUser(String username, String password) throws Exception {
        String hashed = Hash.genHash(username, password);
        ResultSet rs = querySelect("select * from webapp.user_account where username= '" + username + "'");

        Integer id = null;
        String user = null;
        String passwd = null;

        while (rs.next()) {
            id = rs.getInt("id");
            user = rs.getString("username");
            passwd = rs.getString("password");
        }

        rs.close();

        if (passwd.equals(password)) {
            return true;
        } else {
            return false;
        }

    }

    public List<User> generateUserInfo() throws Exception {
        ResultSet rs = querySelect("select * from webapp.user_account");
        List<User> allUser = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            allUser.add(user);
        }
        return allUser;
    }


    private ResultSet querySelect(String query) throws Exception{
        try {
            Class.forName(jdbcDriverStr);
            connection = DriverManager.getConnection(jdbcURL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

//            preparedStatement = connection.prepareStatement("insert into webapp.user_account values (default,?)");
//            preparedStatement.setString(1, "insert test from java");
//            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
        return resultSet;
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
