//Registring new user servlet
package com.sriadmin.usermanage.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sriadmin.usermanage.dao.UserDao;
import com.sriadmin.usermanage.model.User;

/**
 * Servlet implementation class UserServlet1
 */
public class UserServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
		    	 user = UserDao.login(user);
		    	 if (user.isValid())
		    	 {
			        
		    		 jakarta.servlet.http.HttpSession session = request.getSession(true);	    
		    		 session.setAttribute("currentSessionUser",user); 
		    		 response.sendRedirect("indexUser.jsp"); //logged-in page      		
		    	 }
		     } 
		}catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}

	

}
