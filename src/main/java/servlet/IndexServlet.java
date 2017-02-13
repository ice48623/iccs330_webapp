package servlet;

import io.muic.ooc.MySQL;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "IndexServlet",
        urlPatterns = {"/"}
)



public class IndexServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            MySQL mySQL = new MySQL();
            if (mySQL.isValidUser(req.getParameter("username"), req.getParameter("password"))) {
                resp.sendRedirect("login");
            } else {
                System.out.println("not valid user or password");
            }

        } catch (Exception e) {
            System.out.println("Error while login");
            e.printStackTrace();

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("webapp/jsp/login.jsp");


    }


}
