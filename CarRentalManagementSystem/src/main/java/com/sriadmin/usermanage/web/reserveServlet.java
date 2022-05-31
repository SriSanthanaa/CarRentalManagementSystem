//Reserve a car from user end
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
 * Servlet implementation class reserveServlet
 */
public class reserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reserveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int carid = Integer.parseInt(request.getParameter("carid"));
		String username = request.getParameter("username");
		String reserve_from = request.getParameter("reserve_from");
		String reserve_till = request.getParameter("reserve_till");
		//int days = Integer.parseInt(request.getParameter("days"));
		Car c = new Car();
		c = CarDao.findCar1(carid);
		try {
			if(c != null) {
				int st = CarDao.reserveCar(c, reserve_from, reserve_till, username);
				if(st != 0) {
					jakarta.servlet.http.HttpSession session = request.getSession(true);	    
			         session.setAttribute("currentUser",c); 
			         request.setAttribute("carid", c.getCarid());
			         RequestDispatcher rd = request.getRequestDispatcher("reservesuccess1.jsp");
			         rd.forward(request, response);
				}
				else {
					response.sendRedirect("reservefail1.jsp");
				}
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
