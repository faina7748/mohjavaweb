<%@page import="models.ProjectModel"%>
<%@page import="java.util.ArrayList"%>
<div class="container">
    <%@include file="../include/header.jsp" %>
    <div class="container-fluid">
        <br><h3>KKM Project List</h3>  
        <div class="float-right"><a href="/pms/project/form.jsp" class="btn btn-info btn-sm"><i class="fas fa-clinic-medical"></i> Add Project</a></div>
        <div class="row"><p>&nbsp;</p></div>
        <form method="post" action="/pms/project">            
            <div class="row">
                <div class="col-md-1">Title</div> 
                <div class="col-md-2"><input type="text" name="title" class="form-control"></div> 
                <div class="col-md-1">Description</div> 
                <div class="col-md-2"><input type="text" name="desc" class="form-control"></div> 
                <div class="col-md-2"><button type="submit" name="search" class="btn btn-primary"><i class="fas fa-search"></i> Search</div> 
            </div>
        </form>
        <table class="table table-hover table-striped dynamic">
            <thead>
              <tr>
                <th scope="col" class="text-center">No.</th>
                <th scope="col">Title</th>
                <th scope="col">Description</th>
                <th scope="col" class="text-center">Action</th>
              </tr>
            </thead>
            <tbody>
                <%                    
                ArrayList list = (ArrayList)request.getAttribute("list");  

                for(int i=0; i<list.size();i++){
                    ProjectModel proj = (ProjectModel)list.get(i); 
                %>
                <tr>
                    <th scope="row" class="text-center"><%= i+1 %>.</th>
                    <td><%= proj.getTitle() %></td>
                    <td><%= proj.getDesc() %></td>
                    <td class="text-center">
                        <a href="/pms/project?id=<%= proj.getId()%>&action=edit" class="btn btn-success btn-sm"><i class="fas fa-edit"></i></a> 
                        <a href="/pms/project?id=<%= proj.getId()%>&action=del" class="btn btn-danger btn-sm"><i class="fas fa-trash"></i></a>
                    </td>
                </tr>
                <% } %>                    
            </tbody>
        </table>
    </div>  
    <br>
    <%@include file="../include/footer.jsp" %>
</div>
