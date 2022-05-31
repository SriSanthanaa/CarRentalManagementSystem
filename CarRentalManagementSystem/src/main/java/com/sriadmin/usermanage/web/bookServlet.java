//Servlet for booking a car
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
 * Servlet implementation class bookServlet
 */
public class bookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookServlet() {
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
		int carid = Integer.parseInt(request.getParameter("carid"));
		String username = request.getParameter("username");
		String avail_from = request.getParameter("avail_from");
		String book_till = request.getParameter("book_till");
		//int days = Integer.parseInt(request.getParameter("days"));
		Car c = new Car();
		c.setAvail_from(avail_from);
		c = CarDao.findCar1(carid);
		try {
			if(c != null) {
				int st = CarDao.bookCar(c, book_till, username, avail_from);
				if(st >= 0) {
					jakarta.servlet.http.HttpSession session = request.getSession(true);	    
			         session.setAttribute("currentUser",c); 
			         request.setAttribute("carid", c.getCarid());
			         RequestDispatcher rd = request.getRequestDispatcher("booksuccessu.jsp");
			         rd.forward(request, response);
				}
				else if(st == -1) {
					response.sendRedirect("reservedu.jsp");
				}
				else {
					response.sendRedirect("bookingfail.jsp");
				}
			}
		}catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}

	
}
