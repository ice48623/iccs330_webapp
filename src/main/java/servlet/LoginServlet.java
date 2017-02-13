package servlet;

import io.muic.ooc.MySQL;
import io.muic.ooc.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ice on 2/13/17.
 */

@WebServlet(
        name = "LoginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {

    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String MYSQL_URL = "jdbc:mysql://localhost/webapp?"
            + "user=root&password=programsicom&useSSL=false";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            MySQL mySQL = new MySQL(MYSQL_DRIVER, MYSQL_URL);
            List<User> allUser = mySQL.generateUserInfo();
            req.setAttribute("allUser", allUser);

            System.out.println(allUser.size());
            req.getRequestDispatcher("/login.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Enter doGet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        resp.sendRedirect("register.jsp");
    }


}
