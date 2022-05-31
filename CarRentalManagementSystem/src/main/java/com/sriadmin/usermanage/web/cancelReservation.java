package com.sriadmin.usermanage.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sriadmin.usermanage.dao.CarDao;

/**
 * Servlet implementation class cancelReservation
 */
public class cancelReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cancelReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int carid = Integer.parseInt(request.getParameter("carid"));
		String username = request.getParameter("username");
		try {
			int st = CarDao.cancelReservation(carid, username);
			if(st != 0) {
				jakarta.servlet.http.HttpSession session = request.getSession(true);
				session.setAttribute("username", username);
				request.setAttribute("carid", carid);
		         RequestDispatcher rd = request.getRequestDispatcher("reserveDetails.jsp");
		         rd.forward(request, response);
			}
			else {
				response.sendRedirect("ActionFailedAdmin.jsp");
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
