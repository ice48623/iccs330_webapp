package servlet;

import io.muic.ooc.Hash;
import io.muic.ooc.MySQL;
import io.muic.ooc.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(
        name = "RegisterServlet",
        urlPatterns = {"/register"}
)

public class RegisterServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Enter register doPost");

        try {
            User user = new User();
            user.setUsername(req.getParameter("username"));
            user.setPassword(Hash.genHash(user.getUsername(), req.getParameter("password")));
            user.setFirstname(req.getParameter("firstname"));
            user.setLastname(req.getParameter("lastname"));
            user.setEmail(req.getParameter("email"));

            MySQL mySQL = new MySQL();
            mySQL.insertToDB(user);
            System.out.println("Insert new user successfully");
            resp.sendRedirect("user");
        } catch (Exception e) {
            System.out.println("Unable to insert new user");
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Enter register doGet");
        // Checking whether current user is still valid (username exists in DB)
        MySQL mySQL = new MySQL();
        Boolean authenticate = mySQL.isAuthenticate((String) req.getSession().getAttribute("cookie"));
        if (!authenticate) {
            //revoke access, redirect to login page
            req.getSession().invalidate();
            resp.sendRedirect("login");
        } else {
            req.getRequestDispatcher("WEB-INF/register.jsp").forward(req, resp);
        }

    }
}
