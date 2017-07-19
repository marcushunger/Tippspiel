package de.fom.tippspiel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import de.fom.tippspiel.dao.PersonDao;
import de.fom.tippspiel.persistence.User;
import de.fom.tippspiel.view.Message;

//@WebServlet("/j_security_check")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Message> errors = new ArrayList<Message>();

	@Inject
	private PersonDao personDao;

	// private static final String loginsql = "select * from wp.person p where
	// p.email = ? and p.passphrase_sha2_salted = sha2(CONCAT(?, salt), 512)";

	@Override
	public void init(ServletConfig config) throws ServletException {

		// DB Verbindungen zur Verf�gung stellen
		try {
			String s = config.getServletContext().getInitParameter("datasource");
			InitialContext initialContext = new InitialContext();
			@SuppressWarnings("unused")
			DataSource wp = (DataSource) initialContext.lookup(s);
			// wp = (DataSource)config.getServletContext().getAttribute("ds");
			// personDao = new JdbcPersonDao(wp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = (User) request.getSession().getAttribute("user");
		errors.clear();
		try {
			if (BCrypt.checkpw(request.getParameter("passphrasealt"), u.getPassphrase())) {

				u = personDao.update(u, request.getParameter("usernamealt"), request.getParameter("emailalt"),
						request.getParameter("passphraseneu"));
			} else {
				Message m = new Message("c", "Fehler beim ändern der Nutzerdaten");
				errors.add(m);
				request.setAttribute("errors", errors);
				request.getSession().setAttribute("user", personDao.read(u.getId()));
				request.getRequestDispatcher("/change.html").forward(request, response);
			}
		} catch (Exception e) {
			Message m = new Message("", e.getCause().getMessage());
			errors.add(m);
			request.setAttribute("errors", errors);
			request.getSession().setAttribute("user", personDao.read(u.getId()));
			request.getRequestDispatcher("/change.html").forward(request, response);
		}
		request.getSession().setAttribute("user", personDao.read(u.getId()));
		response.sendRedirect(request.getContextPath() + "/change.html");
	}
}
