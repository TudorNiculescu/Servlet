package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType( "text/html" );
        PrintWriter writer = response.getWriter();

        String username = req.getParameter( "username" );
        String password = req.getParameter( "password" );
        System.out.println(username);

        writer.append( "Username is: " + username + "<br>" + "<input type = text/>" );
    }
}
