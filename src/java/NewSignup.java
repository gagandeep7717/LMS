import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GagandeepSingh
 */
@WebServlet(urlPatterns = {"/NewSignup"})
public class NewSignup extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String connectionURL = "jdbc:mysql://localhost:3306/lms";
		Connection connection=null;
		ResultSet rs;
		response.setContentType("text/html");
	
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
			response.sendRedirect("con_login.html");
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
	}  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
