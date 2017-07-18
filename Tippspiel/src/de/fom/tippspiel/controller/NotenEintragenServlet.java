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

import de.fom.tippspiel.dao.PersonDao;
import de.fom.tippspiel.dao.UsermodulDao;
import de.fom.tippspiel.persistence.Modul;
import de.fom.tippspiel.persistence.User;
import de.fom.tippspiel.persistence.Usermodul;
import de.fom.tippspiel.view.Message;

//@WebServlet("/j_security_check")
public class NotenEintragenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private UsermodulDao usermodulDao;
	@Inject
	private PersonDao personDao;

	// private static final String loginsql = "select * from wp.person p where
	// p.email = ? and p.passphrase_sha2_salted = sha2(CONCAT(?, salt), 512)";

	@Override
	public void init(ServletConfig config) throws ServletException {

		// DB Verbindungen zur Verfï¿½gung stellen
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
		Message message = new Message("n", "");
		String action = request.getParameter("action");
		User u = (User) request.getSession().getAttribute("user");
		if (action.equals("actionreal")) {
			String smodulId = request.getParameter("modulreal");
			String snotereal = request.getParameter("notereal");
			if (smodulId.isEmpty() || snotereal.isEmpty()) {
				message.setMessage("Bitte gültige Werte eintragen");
			} else {
				Integer modulId = Integer.parseInt(smodulId);
				double notereal = Double.parseDouble(snotereal);
				Usermodul um = usermodulDao.readUserModul(modulId);
				usermodulDao.realEintragen(um, notereal);
			}
		} else if (action.equals("actiontipp")) {
			String smodulId = request.getParameter("modultipp");
			String snotereal = request.getParameter("notetipp");
			if (smodulId.isEmpty() || snotereal.isEmpty()) {
				message.setMessage("Bitte gültige Werte eintragen");
			} else {
				Integer modulId = Integer.parseInt(smodulId);
				double notetipp = Double.parseDouble(snotereal);
				Modul m = usermodulDao.readModul(modulId);
				usermodulDao.tippEintragen(m, notetipp, u);
			}
		}
		request.getSession().setAttribute("errors", message);
		request.getSession().setAttribute("user", personDao.read(u.getId()));
		response.sendRedirect(request.getContextPath() + "/noteeintragen.html");
	}
}
