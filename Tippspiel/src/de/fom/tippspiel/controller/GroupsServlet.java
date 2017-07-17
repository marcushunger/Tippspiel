package de.fom.tippspiel.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fom.tippspiel.dao.PersonDao;
import de.fom.tippspiel.persistence.Studiengang;
import de.fom.tippspiel.persistence.User;

//@WebServlet("/j_security_check")
public class GroupsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private PersonDao personDao;

	@Override
	public void init(ServletConfig config) throws ServletException {

		// // DB Verbindungen zur Verf�gung stellen
		// try {
		// String s = config.getServletContext().getInitParameter("datasource");
		// InitialContext initialContext = new InitialContext();
		// @SuppressWarnings("unused")
		// DataSource wp = (DataSource) initialContext.lookup(s);
		// // wp = (DataSource)config.getServletContext().getAttribute("ds");
		// // personDao = new JdbcPersonDao(wp);
		// // personDao = new JpaPersonDao();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User cP = (User) request.getSession().getAttribute("user");
		System.out.println(cP.getEmail());
		Studiengang studiengang = cP.getGruppen().get(0).getStudiengang();
		System.out.println(studiengang.getUni());
		System.out.println(request.getParameter("bez"));
		personDao.register(request.getParameter("bez"), cP, studiengang);

		request.getSession().setAttribute("user", personDao.read(cP.getId()));
		response.sendRedirect(request.getContextPath() + "/groups.html");

		// request.getRequestDispatcher("/login.jsp").forward(request,
		// response);
	}
}
