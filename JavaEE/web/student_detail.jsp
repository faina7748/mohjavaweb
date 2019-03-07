<%-- 
    Document   : student_detail
    Created on : Mar 6, 2019, 3:45:26 PM
    Author     : Pengguna PC 11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.StudentModel"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form method="POST" action="student">
            Student Id : <input type="text" name="id">
            <button type="submit">Submit</button>
        </form>
        <h4><u>Student Details:</u></h4>
        <%
            if(request.getAttribute("stud")!=null){
                StudentModel stud = (StudentModel) request.getAttribute("stud");  
                out.print("Id : " + stud.id + ". <br>");    
                out.print("Name : " + stud.name); 
            }
        %>
        
    </body>
</html>
