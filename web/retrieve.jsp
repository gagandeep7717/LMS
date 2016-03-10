<%-- 
    Document   : retrieve
    Created on : 6 Apr, 2013, 12:28:55 AM
    Author     : GagandeepSingh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        

<table border="1">
<%
try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "root");
String query = "select * from signup";
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery(query);
%>
<tr><td>First Name</td><td>Last Name</td><td>Contact no</td><td>Username</td><td>Password</td></tr>
<%
while (rs.next()){
%>
<tr>
<tr><td><input type="text" name="name" value="<%=rs.getString("F_name")%>"></td><td><input type="text" name="L_name" value="<%=rs.getString("L_name")%>"></td><td><input type="text" name="contact" value="<%=rs.getString("C_no")%>"></td><td><input type="text" name="username" value="<%=rs.getString("user_name")%>"></td><td><input type="text" name="pass" value="<%=rs.getString("pass")%>"></td></tr>
<%
}
}
catch(Exception e){}
%>
</table>
    </body>
</html>
