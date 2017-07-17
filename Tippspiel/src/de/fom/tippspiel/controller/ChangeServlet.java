package de.fom.tippspiel.controller;

import java.io.IOException;

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

//@WebServlet("/j_security_check")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		if (BCrypt.checkpw(request.getParameter("passphrasealt"), u.getPassphrase())) {

			u = personDao.update(u, request.getParameter("username"), request.getParameter("emailalt"),
					request.getParameter("passwortneu"));

			request.getSession().setAttribute("user", personDao.read(u.getId()));
			response.sendRedirect(request.getContextPath() + "/home.html");
			return;
		} else {
			// TODO Fehler passwörter stimmen nicht über ein
		}

	}
}
