package servlet;

import io.muic.ooc.MySQL;
import org.apache.commons.lang.StringUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;

/**
 * Created by ice on 2/15/17.
 */

@WebServlet(
        name = "IndexServlet",
        urlPatterns = {"/index.jsp"}
)
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookieUser = (String) req.getSession().getAttribute("cookie");
        if (isValidUser(cookieUser)) {
            System.out.println("User is authenticate from cookie");
            resp.sendRedirect("user");

        } else {
            System.out.println("User is not authenticate from cookie");
            req.setAttribute("cookie", cookieUser);
            resp.sendRedirect("login");
        }
    }

    private Boolean isValidUser(String cookieUser) {
        String username = "";
        MySQL mySQL = new MySQL();
        try {
            ResultSet rs = mySQL.querySelect("SELECT username FROM user_account WHERE username = '" + cookieUser + "'");

            while (rs.next()) {
                username = rs.getString("username");
            }

        } catch (Exception e) {

        } finally {
            mySQL.close();
        }
        return cookieUser != null && StringUtils.equals(cookieUser, username);
    }
}
