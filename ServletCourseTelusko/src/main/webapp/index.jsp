<%@ page import="org.hibernate.*" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.projects.ex2uply.Student" %>


<html>
<head>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="whole-body">
    <%
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        int i = Integer.parseInt(num1);
        int j = Integer.parseInt(num2);
        int k = i + j;
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        Session hibernateSession = factory.openSession();
//        Student student = (Student) hibernateSession.get(Student.class,1);
//        System.out.println(student.getCity());
//        // Close the Hibernate session
//        hibernateSession.close();
//        factory.close();
    %>
</div>
<div>
</div>
</body>
</html>


