package com.sriadmin.adminman.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sriadmin.adminman.dao.UserAdminDao;
import com.sriadmin.usermanage.model.Member;

/**
 * Servlet implementation class deleteMember
 */
public class deleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		Member m = new Member();
		m.setUserid(userid);
		int st = UserAdminDao.deleteMember(userid);
		try {
			if(st!=0) {
				jakarta.servlet.http.HttpSession session = request.getSession(true);	    
				session.setAttribute("currentSessionMember",m); 
				response.sendRedirect("memberindex.jsp");
			}
			else {
				response.sendRedirect("searchres1.jsp");
			}
		} catch (Throwable theException) {
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
