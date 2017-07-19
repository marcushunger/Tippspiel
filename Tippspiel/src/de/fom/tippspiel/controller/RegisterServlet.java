package de.fom.tippspiel.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fom.tippspiel.dao.PersonDao;
import de.fom.tippspiel.persistence.User;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private PersonDao personDao;

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = personDao.register(request.getParameter("j_name"), request.getParameter("j_username"),
				request.getParameter("j_password"));

		if (user != null) {
			request.getSession().setAttribute("user", personDao.read(user.getId()));
			response.sendRedirect(request.getContextPath() + "/home.html");
			return;
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
}
