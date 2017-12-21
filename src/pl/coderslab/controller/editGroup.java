package pl.coderslab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.UserGroup;
import pl.coderslab.model.UserGroupDao;

/**
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class editGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("id");
		if (paramId != null && !paramId.equals("")) {

			request.setAttribute("id", paramId);

		}
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/EditGroup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("nameGr");
		String paramId = request.getParameter("id");
			
				int id = Integer.parseInt(paramId);
				UserGroupDao.editGroup(name, id);
				response.sendRedirect("panel");
			

		
		
		
	}
	

}
