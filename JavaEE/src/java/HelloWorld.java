/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pengguna PC 11
 */
@WebServlet(urlPatterns = {"/HelloWorld"})
public class HelloWorld extends HttpServlet {
    private String message;
    
    @Override
    public void init() throws ServletException{
        // do required initialization
        message = "Hello World";
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set response content type
        response.setContentType("text/html");
        // actual logic goes here
        PrintWriter out = response.getWriter();
        String nama = request.getParameter("nama");
        // out.println -> keluar kat browser
        // System.out.println() -> keluar kat console
        out.println("<h1>" + message + " " + nama + "</h1>");
    }   
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set response content type
        response.setContentType("text/html");
        // actual logic goes here
        PrintWriter out = response.getWriter();
        String nama = request.getParameter("nama");
        int umur = Integer.parseInt(request.getParameter("umur"));
        // out.println -> keluar kat browser
        // System.out.println() -> keluar kat console
        out.println("<h1>Nama : " + nama + " Umur : " + umur + "</h1>");
    }   
    
}
