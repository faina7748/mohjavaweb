<%@page import="models.ProjectModel"%>
<div class="container">
    <%@include file="../include/header.jsp" %>
    <div class="container-fluid">
        <legend>Project Registration</legend>
        <form method="post" action="/pms/project">
            <% ProjectModel proj = (ProjectModel)request.getAttribute("proj");   %>
            <div class="row">
                <div class="col-md-1">Title</div>
                <div class="col-md-4"><input class="form-control" type="text" name="title" value="<%=proj.getTitle()%>"></div>
            </div>
            <div class="row">
                <div class="col-md-1">&nbsp;</div>
                <div class="col-md-4">&nbsp;</div>
            </div>
            <div class="row">
                <div class="col-md-1">Description</div>
                <div class="col-md-4"><textarea class="form-control" name="description"><%=proj.getDesc()%></textarea></div>
            </div>
            <div class="row">
                <div class="col-md-1">&nbsp;</div>
                <div class="col-md-4">&nbsp;</div>
            </div>
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-4"><button class="btn btn-primary" type="submit">Save</button> <button class="btn btn-primary" type="reset">Reset</button></div>
            </div>
        </form>
    </div>    
    <%@include file="../include/footer.jsp" %>
</div>
