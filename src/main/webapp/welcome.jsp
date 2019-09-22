<%@ page import="java.time.LocalDateTime"%>
<html>
<head>

</head>
Current date is: <%= LocalDateTime.now()%>

<body>
User name is: <%= request.getParameter("username")%>
<br>

<%
    String[] cars = request.getParameterValues("cars");
    for(int i = 0; i < cars.length; ++i) {
    out.println(cars[i]);
    }
%>
<br>
Password is: <%= request.getParameter("password")%>



</body>
</html>