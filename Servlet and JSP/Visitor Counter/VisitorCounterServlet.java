import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class VisitorCounterServlet extends HttpServlet {
    private static int visitorCount = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        visitorCount++;
        request.setAttribute("visitorCount", visitorCount);
        RequestDispatcher rd = request.getRequestDispatcher("visitorCounter.jsp");
        rd.forward(request, response);
    }
}