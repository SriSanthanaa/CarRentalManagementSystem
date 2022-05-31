//Servlet that invokes for the action Add new Car
package com.sriadmin.usermanage.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.sql.SQLException;

import com.sriadmin.usermanage.dao.CarDao;
import com.sriadmin.usermanage.model.Car;

/**
 * Servlet implementation class InsertServlet
 */
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarServlet() {
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
		String carname = request.getParameter("carname");
		String cartype = request.getParameter("cartype");
		String avail_from = request.getParameter("avail_from");
		Car c = new Car();
		c.setCarname(carname);
		c.setCartype(cartype);
		c.setAvail_from(avail_from);
		int st = CarDao.insertCar(c);
		try{
			if(st!=0) {
			 jakarta.servlet.http.HttpSession session = request.getSession(true);	    
	         session.setAttribute("currentUser",c); 
	         response.sendRedirect("index.jsp");
		}
		else 
	          response.sendRedirect("Fail.jsp");
		}catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}

}

