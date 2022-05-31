//Login page servlet
package com.sriadmin.usermanage.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sriadmin.usermanage.dao.CarDao;
import com.sriadmin.usermanage.dao.UserDao;
import com.sriadmin.usermanage.model.User;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		     String username = request.getParameter("username");

		     user = UserDao.login(user);
			   		    
		     if (user.isValid())
		     {
			        
		          jakarta.servlet.http.HttpSession session = request.getSession(true);	    
		          session.setAttribute("currentSessionUser",user); 
		          int st = CarDao.findCar();
		          System.out.println(st);
		          if(st != 0) {
		        	  request.setAttribute("username", username);
				      RequestDispatcher rd = request.getRequestDispatcher("userhome.jsp");
				      rd.forward(request, response); //logged-in page
		          }
		          else if(st == 0) {
		        	  request.setAttribute("username", username);
				      RequestDispatcher rd = request.getRequestDispatcher("noCars.jsp");
				      rd.forward(request, response); 
		          }
		     }
		     else if(user.isMember()) {
		    	 response.sendRedirect("gotoMember.jsp");
		     }
			        
		     else 
		          response.sendRedirect("invalidlogin.jsp"); //error page 
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
