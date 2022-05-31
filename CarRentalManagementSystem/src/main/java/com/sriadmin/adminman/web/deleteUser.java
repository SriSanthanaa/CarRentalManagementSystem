//To delete the user Servlet
package com.sriadmin.adminman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sriadmin.adminman.dao.UserAdminDao;
import com.sriadmin.usermanage.model.*;

/**
 * Servlet implementation class deleteUser
 */
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUser() {
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
		int userid = Integer.parseInt(request.getParameter("userid"));
		User u = new User();
		u.setUserid(userid);
		int st = UserAdminDao.deleteUser(userid);
		try {
			if(st!=0) {
				jakarta.servlet.http.HttpSession session = request.getSession(true);	    
				session.setAttribute("currentSessionUser",u); 
				response.sendRedirect("userindex.jsp");
			}
			else {
				response.sendRedirect("searchres1.jsp");
			}
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}


}
