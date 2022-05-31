//Admin login Servlet
package com.sriadmin.adminman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sriadmin.adminman.dao.AdminDao;
import com.sriadmin.adminman.model.Admin;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{	    

		     Admin a = new Admin();
		     a.setAdmin_name(request.getParameter("admin_name"));
		     a.setPasswd(request.getParameter("passwd"));

		     a = AdminDao.login(a);
			   		    
		     if (a.isValid())
		     {
			        
		          jakarta.servlet.http.HttpSession session = request.getSession(true);	    
		          session.setAttribute("currentSessionUser",a); 
		          response.sendRedirect("adminhome.jsp"); //logged-in page      		
		     }
			        
		     else 
		          response.sendRedirect("invalidlogin1.jsp"); //error page 
		}catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
