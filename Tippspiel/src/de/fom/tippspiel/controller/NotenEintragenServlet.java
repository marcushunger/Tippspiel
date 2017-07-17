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

import de.fom.tippspiel.dao.UsermodulDao;
import de.fom.tippspiel.persistence.Modul;
import de.fom.tippspiel.persistence.User;

//@WebServlet("/j_security_check")
public class NotenEintragenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private UsermodulDao usermodulDao;

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
		String action = request.getParameter("action");

		if (action.equals("actionreal")) {
			// Submit reale Note
		} else if (action.equals("actiontipp")) {
			Modul m = ((User) request.getSession().getAttribute("user")).getGruppen().get(0).getStudiengang()
					.getModule().get(0);
			System.out.println(m.getBezeichnung());
			usermodulDao.tippEintragen(m, 2.7, (User) request.getSession().getAttribute("user"));
		}
	}
}
