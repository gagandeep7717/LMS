<%-- 
    Document   : newjsp
    Created on : 6 Apr, 2013, 12:52:08 AM
    Author     : GagandeepSingh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import="java.sql.*"%>



<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Transit Details</title>
    </head>
    <body>
        
	<img id="top" src="top.png" alt="">
        <h3>Transit details</h3>
         <table>
                        <%
                        try {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "root");
                        String query = "select * from transit ";
                        Statement st = conn.createStatement();
                        ResultSet rs = st.executeQuery(query);
                        %>
                        <tr><td>Order no</td><td>Current Place</td><td>Expected date</td></tr>
                        <%
                        while (rs.next()){
                        %>
                        <tr>
                        <tr><td><input type="text" name="Order_no" value="<%=rs.getString("Order_no")%>"></td><td><input type="text" name="cur_place" value="<%=rs.getString("cur_place")%>"></td><td><input type="text" name="last_act" value="<%=rs.getString("last_act")%>"></td></tr>
                        <%
                        }
                        }
                        catch(Exception e){}
                        %>
                        </table>
		<div id="footer">
		<a href="index.html">Logistics Management System.</a>
                </div>
	<img id="bottom" src="bottom.png" alt="">
	</body>
</html>
