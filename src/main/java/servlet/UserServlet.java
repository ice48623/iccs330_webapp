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
        name = "UserServlet",
        urlPatterns = {"/user"}
)
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
//            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/user.jsp");
//            rd.include(req, resp);
            MySQL mySQL = new MySQL();
            List<User> allUser = mySQL.generateUserInfo();
            req.setAttribute("allUser", allUser);

            System.out.println(allUser.size());
            req.getRequestDispatcher("/user.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Enter doGet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        resp.sendRedirect("register");
    }


}
