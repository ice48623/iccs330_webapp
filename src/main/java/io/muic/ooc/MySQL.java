package io.muic.ooc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thanaphat on 11/2/2560.
 */
public class MySQL {

//    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
//    public static final String MYSQL_URL = "jdbc:mysql://localhost/webapp?"
//            + "user=root&password=programsicom&useSSL=false";

    private final String jdbcDriverStr ="com.mysql.jdbc.Driver";
    private final String jdbcURL = "jdbc:mysql://localhost/webapp?"
            + "user=root&password=programsicom&useSSL=false";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

//    public MySQL(String jdbcDriverStr, String jdbcURL) {
//        this.jdbcDriverStr = jdbcDriverStr;
//        this.jdbcURL = jdbcURL;
//    }

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
            String text = resultSet.getString("username");
            System.out.println("text: " + text);
        }
    }

    public Boolean isValidUser(String username, String password) throws Exception {
        String hashed = Hash.genHash(username, password);
        ResultSet rs = querySelect("select * from webapp.user_account where username= '" + username + "'");

        String user = null;
        String passwd = null;

        while (rs.next()) {
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
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            allUser.add(user);

        }
        close();
        return allUser;
    }


    public ResultSet querySelect(String query) throws Exception{
        try {
            Class.forName(jdbcDriverStr);
            connection = DriverManager.getConnection(jdbcURL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
        }
        return resultSet;
    }

    public void insertToDB(User user) {

        try {
            java.sql.Statement stmt;
            Class.forName(jdbcDriverStr);
            connection = DriverManager.getConnection(jdbcURL);

            stmt = connection.createStatement();
            String create_sql = "INSERT INTO user_account (username, password, email, firstname, lastname) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getEmail() + "', '"+ user.getFirstname() +"', '" + user.getLastname() +"')";
            stmt.execute(create_sql);


        } catch (Exception e) {
            System.out.println("Unable to insert new user");
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void query(String query) {
        try {
            java.sql.Statement stmt;
            Class.forName(jdbcDriverStr);
            connection = DriverManager.getConnection(jdbcURL);

            // Initialized stmt with connection
            stmt = connection.createStatement();

            // Delete user from database
            String query_stmt = query;
            stmt.execute(query_stmt);
            System.out.println("Query user successfully");
        } catch (Exception e) {
            System.out.println("Unable to delete user");
        } finally {
            close();
        }

    }

    public void close() {
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
