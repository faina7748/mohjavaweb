package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UserModel;

@WebServlet(name = "user", urlPatterns = {"/user"})
public class user extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String gender = request.getParameter("gender");
        String role = request.getParameter("role");
        
        UserModel user = new UserModel();
        user.setName(name);
        user.setPwd(pwd);
        user.setGender(gender);
        user.setRole(role);
        if(id.equals("0")){
            user.insert();            
        }else{
            int id2 = Integer.parseInt(id);
            //user.update(id2);
        }
        //request.getRequestDispatcher("/pms/index.jsp").forward(request, response); // forward bawa data tambahan
        response.sendRedirect("/pms/index.jsp"); // tak bawa apa2 data
        
    }    

}
