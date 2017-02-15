package servlet;

import io.muic.ooc.MySQL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(
        name = "EditServlet",
        urlPatterns = {"/edit"}
)
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Enter edit doGet");
        System.out.println("receive: " + req.getParameter("editUser"));
        MySQL mySQL = new MySQL();
        String username = req.getParameter("editUser");
        String firstname = "";
        String lastname = "";
        String email = "";
        try {
            ResultSet rs = mySQL.querySelect("SELECT * FROM user_account WHERE username = '" + username + "'");
            while (rs.next()) {
                firstname = rs.getString("firstname");
                lastname = rs.getString("lastname");
                email = rs.getString("email");
            }

        } catch (Exception e) {
            System.out.println("Error while query from database");
        }

        req.setAttribute("username", username);
        req.setAttribute("firstname", firstname);
        req.setAttribute("lastname", lastname);
        req.setAttribute("email", email);
        req.getRequestDispatcher("WEB-INF/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Enter edit doPost");
        MySQL mySQL = new MySQL();
        System.out.println(req.getParameter("username"));
        mySQL.query("UPDATE user_account SET email = '" + req.getParameter("email") + "', firstname = '" + req.getParameter("firstname") + "', lastname = '" + req.getParameter("lastname") + "' WHERE username = '" + req.getParameter("username") + "'");
        resp.sendRedirect("user");
    }
}
