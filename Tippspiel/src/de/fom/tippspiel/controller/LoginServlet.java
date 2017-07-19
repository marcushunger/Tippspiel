package de.fom.tippspiel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionalException;

import de.fom.tippspiel.dao.PersonDao;
import de.fom.tippspiel.persistence.User;
import de.fom.tippspiel.view.Message;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Message> errors = new ArrayList<Message>();
	@Inject
	private PersonDao personDao;

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			User user = personDao.login(request.getParameter("j_username"), request.getParameter("j_password"));
			if (user != null) {
				request.getSession().setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "/home.html");
				return;
			} else {
				Message m = new Message("j_password", "Bitte Passwort überprüfen");
				errors.add(m);
				request.setAttribute("errors", errors);
			}
		} catch (TransactionalException e) {
			Message m = new Message("trans", "TransEx");
			errors.add(m);
			request.setAttribute("errors", errors);
		} catch (PersistenceException e) {
			Message m = new Message("persist", "PersisEx");
			errors.add(m);
			request.setAttribute("errors", errors);
		} catch (DaoException e) {
			Message m = new Message("dao", "DaoEx");
			errors.add(m);
			request.setAttribute("errors", errors);
		}

		request.getRequestDispatcher("/login.jsp").forward(request, response);

	}
}
