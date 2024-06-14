import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String grade = request.getParameter("grade");

        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setGrade(grade);

        request.setAttribute("student", student);
        RequestDispatcher rd = request.getRequestDispatcher("studentDetails.jsp");
        rd.forward(request, response);
    }
}