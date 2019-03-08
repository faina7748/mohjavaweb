<%@page import="models.UserModel"%>
<%
if(session.getAttribute("loggedin") == null){
    response.sendRedirect("/pms/pub/login.jsp");
    return;
}
// casting
UserModel user = (UserModel) session.getAttribute("user");
%>    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/pms/assets/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="/pms/assets/css/pms.css">
        <!--<link rel="stylesheet" type="text/css" href="/pms/assets/fontawesome-free-5.7.2-web/css/all.css">-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
        <title>PMS</title>
    </head>
    <body>
        <img src="/pms/assets/img/banner.jpg" height="30%" width="100%">
        <nav class="navbar navbar-light bg-light">
            <a class="navbar-brand" href="/pms/index.jsp"><span style="color:#005cbf"><i class="fas fa-home"></i> Home</span></a>
            <!--<span style="font-family:Monotype Corsiva;font-size:28px">Welcome to Project Management System</span>-->
            <h6>Welcome <%= user.getName()%></h6>
            <a class="navbar-brand" href="/pms/login?logout"><i class="fas fa-sign-out-alt"></i> </a>
        </nav>
        
