package com.sriadmin.adminman.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sriadmin.usermanage.dao.UserDao;

/**
 * Servlet implementation class acceptMember
 */
public class acceptMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public acceptMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int requestid = Integer.parseInt(request.getParameter("requestid"));
			int st = UserDao.acceptMember(requestid);
			if(st != 0) {
				response.sendRedirect("memberindex.jsp");
			}
			else {
				response.sendRedirect("ActionFailedmem.jsp");
			}
		}catch(Throwable theException) {
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
