<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/pms/assets/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="/pms/assets/css/pms.css">        
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
        <title>PMS Login</title>
    </head>
    <body>
        <%
            String no = request.getParameter("no");
            if(no != null){
                out.print("<div class='alert alert-danger'>Wrong Staff ID and Password</div>");
            }
        %>
        <div class="col-md-4" style="background-color: #b8daff">
            <form method="post" action="/pms/login">
                <div>Staff ID</div>
                <div><input class="form-control" size="20" type="text" name="staff_id"></div>
                <div>Password</div>
                <div><input type="password" name="pwd"></div>
                <div><button type="submit" class="btn btn-primary">Login</button></div>
            </form>
        </div>
    </body>
</html>
