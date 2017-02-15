package servlet;

import io.muic.ooc.MySQL;
import io.muic.ooc.User;

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
        name = "UserServlet",
        urlPatterns = {"/user"}
)
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            displayUsers(req);
            req.getRequestDispatcher("/user.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Enter user doGet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Enter user doPost");
        if ("delete".equals(req.getParameter("deleteAction"))) {
            System.out.println("Delete action");
            System.out.println(req.getParameter("deleteUser"));
            try {
                System.out.println("");
                MySQL mySQL = new MySQL();
                mySQL.query("DELETE FROM user_account WHERE username = '" + req.getParameter("deleteUser") + "'");
                displayUsers(req);
                req.getRequestDispatcher("user.jsp").forward(req, resp);
            } catch (Exception e) {
                System.out.println("Error while deleting user from database");
            }

        } else {
            resp.sendRedirect("register");
        }


    }

    private void displayUsers(HttpServletRequest req) throws Exception{
        MySQL mySQL = new MySQL();
        List<User> allUser = mySQL.generateUserInfo();
        req.setAttribute("allUser", allUser);
    }

}
