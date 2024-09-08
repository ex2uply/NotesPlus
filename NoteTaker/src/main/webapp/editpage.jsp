<%@ page import="org.hibernate.Session" %>
<%@ page import="com.helper.FactoryProvider" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="com.entities.Note" %><%--
  Created by IntelliJ IDEA.
  User: adity
  Date: 9/8/2024
  Time: 11:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="all_js_css.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <br>
    <h1>Edit Your Note: </h1>
    <br>
    <%
        Integer id = Integer.parseInt(request.getParameter("id").trim());
        Session s = FactoryProvider.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        Note note = s.get(Note.class, id);

    %>
    <form action="updateservlet" method="post">
        <input value="<%= note.getId()%>" name="noteID" type="hidden">
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
                    value = <%= note.getTitle() %>
            >
        </div>
        <div class="form-group">
            <label for="content">Description</label>
            <textarea id="content"
                      required
                      placeholder="Write here"
                      class="form-control"
                      name="content"
                      style="padding: 10px; line-height: 1.5; height: 150px;"><%=note.getContent()%>
            </textarea>
        </div>
        <div class="container text-center">
            <button type="submit" class="btn btn-success">Update</button>
        </div>
    </form>

</body>
</html>
