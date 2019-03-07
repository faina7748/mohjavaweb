package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ProjectModel;

@WebServlet(name = "Project", urlPatterns = {"/project"})
public class Project extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if(action != null){
            int id = Integer.parseInt(request.getParameter("id"));
            ProjectModel proj = new ProjectModel();
            
            if(action.equals("edit")){
               // display form with original data 
               proj = proj.getOne(id);
               request.setAttribute("proj", proj); // output forward to form
               request.getRequestDispatcher("project/form.jsp").forward(request, response);
               
            }else if(action.equals("del")){
                proj.delete(id);
            }
        }
        //ArrayList list = new models.ProjectModel().getAll();
        ArrayList list = new ProjectModel().getAll();
        request.setAttribute("list", list); // output forward to JSP
        RequestDispatcher dispatch = request.getRequestDispatcher("project/list.jsp");
        dispatch.forward(request, response);
        
    }  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String title = request.getParameter("title");
        String desc = request.getParameter("description");
        ProjectModel proj = new ProjectModel();
        proj.setTitle(title);
        proj.setDesc(desc);
        proj.insert();
        //request.getRequestDispatcher("project/list.jsp").forward(request, response); // forward bawa data tambahan
        response.sendRedirect("project"); // tak bawa apa2 data
        
    }  
}
