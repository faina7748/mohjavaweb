package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.UserModel;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        session.invalidate(); // destroy session
        response.sendRedirect("/pms/pub/login.jsp");
    }  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String staffid = request.getParameter("staff_id"); //req.getParameter("")
        String pwd = request.getParameter("pwd");
        
        UserModel user = new UserModel();
        if(user.isExist(staffid, pwd)){
            // user wujud
            HttpSession sess = request.getSession();
            sess.setAttribute("loggedin",true);
            sess.setAttribute("user", user); // save an obj into session
            
            response.sendRedirect("/pms/project");
        }else{            
            // user x wujud
            response.sendRedirect("/pms/pub/login.jsp?no");
        }
     
        
        
        
        
        
    }   

}
