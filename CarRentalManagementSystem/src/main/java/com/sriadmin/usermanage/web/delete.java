//Servlet for deleting a car
package com.sriadmin.usermanage.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sriadmin.usermanage.dao.CarDao;
import com.sriadmin.usermanage.model.Car;

/**
 * Servlet implementation class delete
 */
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int carid = Integer.parseInt(request.getParameter("carid"));
		Car c = new Car();
		c.setCarid(carid);
		int st = CarDao.deleteCar(carid);
		try {
			if(st!=0) {
				jakarta.servlet.http.HttpSession session = request.getSession(true);	    
				session.setAttribute("currentSessionUser",c); 
				response.sendRedirect("index.jsp");
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
