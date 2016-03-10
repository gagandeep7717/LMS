
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author GagandeepSingh
 */
//@WebServlet(name = "signup", )
public class signup extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	/**Process the HTTP Get request*/
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String connectionURL = "jdbc:mysql://localhost:3306/lms";
		Connection connection=null;
		ResultSet rs;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//get the variables entered in the form
		String F_name = request.getParameter("F_name");
		String L_name = request.getParameter("L_name");
		String C_no = request.getParameter("C_no");
		String user_name = request.getParameter("user_name");
		String pass = request.getParameter("pass");
		try {
			// Load the database driver
			//Class.forName("org.gjt.mm.mysql.Driver");
                        Class.forName("com.mysql.jdbc.Driver");
			// Get a Connection to the database
			connection = DriverManager.getConnection(connectionURL, "root", "root"); 
			//Add the data into the database
			String sql = "insert into signup values (?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, F_name);
			pst.setString(2, L_name);
			pst.setString(3, C_no);
			pst.setString(4, user_name);
			pst.setString(5, pass);

			int numRowsChanged = pst.executeUpdate();
			// show that the new account has been created
			out.println(" Hello : ");
			out.println(" '"+F_name+"'");
			pst.close();
		}
		catch(ClassNotFoundException e){
			out.println("Couldn't load database driver: " + e.getMessage());
		}
		catch(SQLException e){
			out.println("SQLException caught: " + e.getMessage());
		}
		catch (Exception e){
			out.println(e);
		}
		finally {
			// Always close the database connection.
			try {
				if (connection != null) connection.close();
			}
			catch (SQLException ignored){
				out.println(ignored);
			}
		}
	}
}