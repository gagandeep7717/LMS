package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class view_005ftransit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>View Transit Details</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("\t<img id=\"top\" src=\"top.png\" alt=\"\">\n");
      out.write("        <h3>Transit details</h3>\n");
      out.write("         <table>\n");
      out.write("                        ");

                        try {
                        String order = request.getParameter("order");
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "root");
                        String query = "select * from transit where Order_no";
                        Statement st = conn.createStatement();
                        ResultSet rs = st.executeQuery(query);
                        
      out.write("\n");
      out.write("                        <tr><td>Order no</td><td>Current Place</td><td>Expected date</td></tr>\n");
      out.write("                        ");

                        while (rs.next()){
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                        <tr><td><input type=\"text\" name=\"Order_no\" value=\"");
      out.print(rs.getString("Order_no"));
      out.write("\"></td><td><input type=\"text\" name=\"cur_place\" value=\"");
      out.print(rs.getString("cur_place"));
      out.write("\"></td><td><input type=\"text\" name=\"last_act\" value=\"");
      out.print(rs.getString("last_act"));
      out.write("\"></td></tr>\n");
      out.write("                        ");

                        }
                        }
                        catch(Exception e){}
                        
      out.write("\n");
      out.write("                        </table>\n");
      out.write("\t\t<div id=\"footer\">\n");
      out.write("\t\t<a href=\"index.html\">Logistics Management System.</a>\n");
      out.write("                </div>\n");
      out.write("\t<img id=\"bottom\" src=\"bottom.png\" alt=\"\">\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
