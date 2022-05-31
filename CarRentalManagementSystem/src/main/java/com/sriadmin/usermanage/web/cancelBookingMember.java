package com.sriadmin.usermanage.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sriadmin.usermanage.dao.CarDao;
import com.sriadmin.usermanage.model.Car;

/**
 * Servlet implementation class cancelBooking
 */
public class cancelBookingMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cancelBookingMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int carid = Integer.parseInt(request.getParameter("carid"));
		Car c = new Car();
		String username = request.getParameter("username");
		try {
			int st = CarDao.returnCar(carid, username);
			if(st >= 0) {
				jakarta.servlet.http.HttpSession session = request.getSession(true);	    
		         session.setAttribute("currentUser",c); 
		         request.setAttribute("username", username);
		         RequestDispatcher rd = request.getRequestDispatcher("bookingDetailsU.jsp");
		         rd.forward(request, response);
			}
			else {
				response.sendRedirect("ActionFailedMember.jsp");
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
