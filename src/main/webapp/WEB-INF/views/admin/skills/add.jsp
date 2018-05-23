<%@include file="../shared/header.jsp" %>
<h1>Add Skills</h1>
<form method="post" action="${SITE_URL}/admin/skills/save">
    <div class="form-group">
        <label>Name</label>
        <input type="text" name="name" class="form-control" required="required"/>
    </div>
    <button type="submit" class="btn btn-success">
        Save
    </button>
    <a href="${SITE_URL}/admin/skills" class="btn btn-danger">Back</a>
</form>
<%@include file="../shared/footer.jsp" %>