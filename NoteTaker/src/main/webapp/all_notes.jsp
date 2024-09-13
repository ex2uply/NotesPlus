<%@ page import="org.hibernate.Session" %>
<%@ page import="com.helper.FactoryProvider" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="com.entities.Note" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> ALL your saved notes</title>
    <%@include file="all_js_css.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <br>
    <h1>All Notes: </h1>
    <div class="row">
        <div class = "col-12">
                <%
                Session s = FactoryProvider.getFactory().openSession();
                org.hibernate.query.Query q = s.createQuery("from Note");
                List<Note> ls = q.list();
                for(Note note: ls){%>
            <div class="card mt-3" >
                <div class="card-body">
                    <h5 class="card-title"><%=note.getTitle()%></h5>
                    <p class="card-text">
                        <%=note.getContent()%></p>
                        <br>
                        <%=note.getAddedDate()%>
                    <br>
                    <div class="container">
                        <a href="deleteservlet?id=<%=note.getId()%>" class="btn btn-danger">Delete</a>
                        <a href="editpage.jsp?id=<%=note.getId()%>" class="btn btn-primary">Update</a>

                    </div>

                </div>
            </div>
            <%
                }
                s.close();
            %>
        </div>
    </div>

</div>
</body>
</html>
