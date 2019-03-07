import model.StudentModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/student"})
public class StudentController extends HttpServlet {
        
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
        //int studId = Integer.parseInt(request.getParameter("id"));
        //StudentModel stud = new StudentModel().getOne(studId);        
        //request.setAttribute("stud", stud); // output forward to JSP
        RequestDispatcher dispatch = request.getRequestDispatcher("student_detail.jsp");
        dispatch.forward(request, response);
    }    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
        int studId = Integer.parseInt(request.getParameter("id"));
        StudentModel stud = new StudentModel().getOne(studId);        
        request.setAttribute("stud", stud); // output forward to JSP
        RequestDispatcher dispatch = request.getRequestDispatcher("student_detail.jsp");
        dispatch.forward(request, response);
    } 
    
}
