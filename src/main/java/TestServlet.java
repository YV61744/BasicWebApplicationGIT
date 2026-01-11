

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //Added a comment line here
    /**
     * Default constructor updated. 
     */
    public TestServlet() {

		System.out.println("New Line added Here from VS Code Branch");
		System.out.println("New Line added Here by Dev3");
		
		system.out.println("one more Line added Here by Dev2");
		system.out.println("New Line added Here");
        // TODO Auto-generated constructor stub
    }
	 public newmethodVSCODEBranch() {

		System.out.println("New method added Here from Branch");
	 public newmethodMASTERBranch() {

		System.out.println("New method added Here from MASTER");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at code updated here from VS Code Branch: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Added a New meesage here
		doGet(request, response);
	}

}
