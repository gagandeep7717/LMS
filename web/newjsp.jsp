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
        <title>Consumers form</title>
    </head>
    <body>
	<img id="top" src="top.png" alt="">
	<table>
                        <%
                        try {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "root");
                        String query = "select * from consumer";
                        Statement st = conn.createStatement();
                        ResultSet rs = st.executeQuery(query);
                        %>
                        <tr><td>Company name</td><td>Type of goods</td><td>Quantity</td><td>Pickup place</td><td>Pickup Date</td><td>Delivery place</td><td>Delivery date</td></tr>
                        <%
                        while (rs.next()){
                        %>
                        <tr>
                        <tr><td><input type="text" name="name" value="<%=rs.getString("c_name")%>"></td><td><input type="text" name="goods" value="<%=rs.getString("type_good")%>"></td><td><input type="text" name="quantity" value="<%=rs.getString("quantity")%>"></td><td><input type="text" name="pick_place" value="<%=rs.getString("p_con_place")%>"></td><td><input type="text" name="pick_Date" value="<%=rs.getString("p_con_date")%>"></td><td><input type="text" name="del_place" value="<%=rs.getString("d_con_place")%>"></td><td><input type="text" name="del_date" value="<%=rs.getString("d_con_date")%>"></td></tr>
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
