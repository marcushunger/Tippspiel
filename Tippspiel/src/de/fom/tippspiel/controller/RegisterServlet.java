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

public class RegisterServlet extends HttpServlet {
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
			User user = personDao.register(request.getParameter("j_name"), request.getParameter("j_username"),
					request.getParameter("j_password"));

			if (user != null) {
				request.getSession().setAttribute("user", personDao.read(user.getId()));
				response.sendRedirect(request.getContextPath() + "/home.html");
				return;
			}
		} catch (TransactionalException e) {
			Message m = new Message("trans", "Username oder Passwort bereits vergeben");
			errors.add(m);
			request.setAttribute("errors", errors);
		} catch (PersistenceException e) {
			Message m = new Message("persist", "Username oder Passwort bereits vergeben");
			errors.add(m);
			request.setAttribute("errors", errors);
		} catch (DaoException e) {
			Message m = new Message("dao", "Username oder Passwort bereits vergeben");
			errors.add(m);
			request.setAttribute("errors", errors);
		}

		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
}
