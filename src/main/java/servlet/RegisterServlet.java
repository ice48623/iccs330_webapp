package servlet;

import io.muic.ooc.Hash;
import io.muic.ooc.MySQL;
import io.muic.ooc.User;

import javax.servlet.RequestDispatcher;
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
//        req.getRequestDispatcher("register.jsp").forward(req, resp);

        try {
            User user = new User();
            user.setUsername(req.getParameter("username"));
            System.out.println(user.getUsername());
            String pass = req.getParameter("password");
            System.out.println(pass);
            user.setPassword(pass);
            user.setFirstname(req.getParameter("firstname"));
            user.setLastname(req.getParameter("lastname"));
            user.setEmail(req.getParameter("email"));


            System.out.println(user.getPassword());
            MySQL mySQL = new MySQL();
            mySQL.insertToDB(user);
            System.out.println("Insert new user successfully");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Unable to insert new user");
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Enter register doGet");
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }
}
