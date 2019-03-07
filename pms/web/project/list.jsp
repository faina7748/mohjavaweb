<%@page import="models.ProjectModel"%>
<%@page import="java.util.ArrayList"%>
<div class="container">
    <%@include file="../include/header.jsp" %>
    <div class="container-fluid">
        <br><h3>KKM Project List</h3>      
        <table class="table table-hover table-striped">
            <thead>
              <tr>
                <th scope="col" class="text-center">No.</th>
                <th scope="col">Title</th>
                <th scope="col">Description</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
                <%                    
                ArrayList list = (ArrayList)request.getAttribute("list");  

                for(int i=0; i<list.size();i++){
                    ProjectModel proj = (ProjectModel)list.get(i); 
                %>
                <tr>
                    <th scope="row" class="text-center"><%= proj.getId() %>.</th>
                    <td><%= proj.getTitle() %></td>
                    <td><%= proj.getDesc() %></td>
                    <td>
                        <a href="/pms/project?id=<%= proj.getId()%>&action=edit" class="btn btn-success btn-sm">Edit</a> 
                        <a href="/pms/project?id=<%= proj.getId()%>&action=del" class="btn btn-danger btn-sm">Del</a>
                    </td>
                </tr>
                <% } %>                    
            </tbody>
        </table>
    </div>  
    <br>
    <%@include file="../include/footer.jsp" %>
</div>
