package az.hackathon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Qalib on 3/13/2016.
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/serc"})
public class SearchServlet extends HttpServlet {

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        String path = "search.jsp";
        Boolean forward = true;
        if(act.equals("search")){
            path = "search.jsp";
            forward = true;
    }
        if (forward) request.getRequestDispatcher("/WEB-INF/views/" + path).forward(request, response);
        else response.sendRedirect(path);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
}
