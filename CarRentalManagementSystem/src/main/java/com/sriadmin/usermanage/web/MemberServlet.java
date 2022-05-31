package com.sriadmin.usermanage.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sriadmin.usermanage.dao.UserDao;
import com.sriadmin.usermanage.model.Member;

/**
 * Servlet implementation class MemberServlet
 */
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
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
		try {
			Member m = new Member();
			String username = request.getParameter("username");
			m.setUsername(request.getParameter("username"));
			m.setPwd(request.getParameter("pwd"));
			m = UserDao.memberLogin(m);
			if(m.isValid()) {
				  jakarta.servlet.http.HttpSession session = request.getSession(true);	    
		          session.setAttribute("currentSessionUser",m); 
		          request.setAttribute("username", username);
			      RequestDispatcher rd = request.getRequestDispatcher("indexUser.jsp");
			      rd.forward(request, response);
			}
			else {
				response.sendRedirect("loginFailed.jsp");
			}
		}catch (Throwable theException){
		     System.out.println(theException); 
		}
	}

	

}
