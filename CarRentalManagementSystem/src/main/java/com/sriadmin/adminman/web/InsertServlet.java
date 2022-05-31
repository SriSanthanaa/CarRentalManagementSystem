//Insert a new user Servlet
package com.sriadmin.adminman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sriadmin.usermanage.dao.UserDao;
import com.sriadmin.usermanage.model.User;

/**
 * Servlet implementation class InsertServlet
 */
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{	    

		     User user = new User();
		     user.setUsername(request.getParameter("username"));
		     user.setPwd(request.getParameter("pwd"));
		     user.setFullname(request.getParameter("fullname"));
		     user.setEmail_id(request.getParameter("email_id"));
		     user.setAddress(request.getParameter("address"));
		     String ph_no = request.getParameter("ph_no");
		     user.setPh_no(ph_no);

		     int st = UserDao.register(user);
			   		    
		     if(st!=0) {
			        
		    		 jakarta.servlet.http.HttpSession session = request.getSession(true);	    
		    		 session.setAttribute("currentSessionUser",user); 
		    		 response.sendRedirect("userindex.jsp"); //logged-in page      	
		     }
		     else {
		    	 response.sendRedirect("Fail.jsp");
		     }
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
