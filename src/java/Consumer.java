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
@WebServlet(urlPatterns = {"/Consumer"})
public class Consumer extends HttpServlet {

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
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String c_name = request.getParameter("c_name");
		String c_addr_city = request.getParameter("c_addr_city");
                String c_addr_state = request.getParameter("c_addr_state");
		String type_good = request.getParameter("type_good");
		String quantity = request.getParameter("quantity");
		String p_con_place = request.getParameter("p_con_place");
		String p_con_date = request.getParameter("p_con_date");
                String d_con_place = request.getParameter("d_con_place");
                String d_con_date = request.getParameter("d_con_date");
                try {
			// Load the database driver
			//Class.forName("org.gjt.mm.mysql.Driver");
                        Class.forName("com.mysql.jdbc.Driver");
			// Get a Connection to the database
			connection = DriverManager.getConnection(connectionURL, "root", "root"); 
			//Add the data into the database
			String sql = "insert into consumer values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, fname);
			pst.setString(2, lname);
			pst.setString(3, c_name);
			pst.setString(4, c_addr_city);
                        pst.setString(5, c_addr_state);
                        pst.setString(6, type_good);
                        pst.setString(7, quantity);
                        pst.setString(8, p_con_place);
                        pst.setString(9, p_con_date);
                        pst.setString(10, d_con_place);
                        pst.setString(11, p_con_date);
                       
			int numRowsChanged = pst.executeUpdate();
			// show that the new account has been created
			response.sendRedirect("index.html");
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
