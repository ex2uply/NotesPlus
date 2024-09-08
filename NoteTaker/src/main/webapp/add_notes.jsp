<%--
  Created by IntelliJ IDEA.
  User: adity
  Date: 9/8/2024
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Notes</title>
    <%@include file="all_js_css.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <br>
    <%--    this is add form--%>
    <form action="saveNotes" method="post">
        <div class="form-group">
            <label for="title" style="font-size: large">+</label>
            <input
                    name="title"
                    type="text"
                   class="form-control"
                   id="title"
                   aria-describedby="emailHelp"
                   placeholder="Enter Title"
                   required
            >
        </div>
        <div class="form-group">
            <label for="content">Description</label>
            <textarea id="content"
                      required
                      placeholder="Write here"
                      class="form-control"
                      name="content"
                      style="padding: 10px; line-height: 1.5; height: 150px;"></textarea>

        </div>
        <div class="container text-center">
            <button type="submit" class="btn btn-primary">Add</button>
        </div>
    </form>
</div>
</body>
</html>
