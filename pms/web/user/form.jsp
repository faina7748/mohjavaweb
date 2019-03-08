<%@page import="models.UserModel"%>
<div class="container">
    <%@include file="../include/header.jsp" %>
    <div class="container-fluid">
        <legend>User Registration</legend>
        <form method="post" action="/pms/user?act=insert">
            <div class="row">
                <div class="col-md-1">Name</div>
                <div class="col-md-4"><input class="form-control" type="text" name="name" value=""></div>
            </div>
            <div class="row">
                <div class="col-md-1">&nbsp;</div>
                <div class="col-md-4">&nbsp;</div>
            </div>
            <div class="row">
                <div class="col-md-1">Password</div>
                <div class="col-md-4"><input class="form-control" type="password" name="pwd" value=""></div>
            </div>
            <div class="row">
                <div class="col-md-1">&nbsp;</div>
                <div class="col-md-4">&nbsp;</div>
            </div>
            <div class="row">
                <div class="col-md-1">Gender</div>
                <div class="col-md-4">
                    <input type="radio" name="gender" value="M"> Male
                    <input type="radio" name="gender" value="F"> Female
                </div>
            </div>
            <div class="row">
                <div class="col-md-1">&nbsp;</div>
                <div class="col-md-4">&nbsp;</div>
            </div>
            <div class="row">
                <div class="col-md-1">Role</div>
                <div class="col-md-4">
                    <select class="form-control" name="role">
                        <option value="1">Admin</option>
                        <option value="2">User</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-md-1">&nbsp;</div>
                <div class="col-md-4">&nbsp;</div>
            </div>
            <div class="row">
                <div class="col-md-1"><input type="hidden" name="id" value="0"></div>
                <div class="col-md-4">
                    <button class="btn btn-primary" type="submit">Save</button> 
                    <button class="btn btn-primary" type="reset">Reset</button>
                </div>
            </div>
        </form>
    </div>    
    <%@include file="../include/footer.jsp" %>
</div>