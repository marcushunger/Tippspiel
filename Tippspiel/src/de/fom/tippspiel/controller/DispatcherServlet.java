package de.fom.tippspiel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

import de.fom.tippspiel.dao.PersonDao;
import de.fom.tippspiel.dao.UsermodulDao;
import de.fom.tippspiel.model.ChangeForm;
import de.fom.tippspiel.model.NoteeintragenForm;
import de.fom.tippspiel.persistence.Modul;
import de.fom.tippspiel.persistence.User;
import de.fom.tippspiel.persistence.Usermodul;
import de.fom.tippspiel.view.Message;

//@WebServlet(urlPatterns="*.html")
public class DispatcherServlet extends HttpServlet {

	@Inject
	private PersonDao personDao;

	@Inject
	private UsermodulDao usermodulDao;

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// DB Verbindungen zur Verf�gung stellen
		try {
			String s = config.getServletContext().getInitParameter("datasource");
			InitialContext initialContext = new InitialContext();
			DataSource wp = (DataSource) initialContext.lookup(s);
			// personDao = new JdbcPersonDao(wp); //Auskommentiert weil
			// PersonDao injected wird
			// masterDataDao = new JdbcMasterDataDao(wp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("RequestURI: " + request.getRequestURI());
		String[] sa = StringUtils.split(request.getServletPath(), "/.\\");
		String forward = null;
		Message message = new Message("", "");
		// request.getSession().setAttribute("errors", message);
		switch (sa[0]) {
		case "home":
			forward = "home";
			break;
		case "change":
			// checkMessage("c", request);
			forward = "change";
			User cP = (User) request.getSession().getAttribute("user");
			ChangeForm cform = new ChangeForm(cP);
			request.setAttribute("cform", cform);
			break;
		case "groups":
			checkMessage("g", request);
			forward = listGroups(request);
			break;
		case "index":
			forward = list(request);
			break;
		case "personlist":
			forward = list(request);
			break;
		case "noteeintragen":
			checkMessage("n", request);
			forward = "noteeintragen";
			ArrayList<Usermodul> listeUsermodule = ((User) request.getSession().getAttribute("user")).getModule();
			ArrayList<Modul> listeModule = ((User) request.getSession().getAttribute("user")).getGruppen().get(0)
					.getStudiengang().getModule();
			NoteeintragenForm nform = new NoteeintragenForm(request, listeModule, listeUsermodule);
			request.setAttribute("nform", nform);
			break;
		case "doku":
			forward = "doku";
			break;
		case "logout":
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			break;
		default:
			break;
		}
		if (forward != null) {
			request.setAttribute("forward", forward);
			request.getRequestDispatcher("/WEB-INF/jsp/" + forward + ".jsp").forward(request, response);
		}

	}

	private String list(HttpServletRequest request) throws DaoException {
		String forward;
		request.setAttribute("personlist", personDao.list());
		// User muss irgendwann neu geladen werden!!
		request.setAttribute("gruppenlist", ((User) request.getSession().getAttribute("user")).getGruppen());
		forward = "personlist";
		return forward;
	}

	private String listGroups(HttpServletRequest request) throws DaoException {
		String forward;
		request.setAttribute("user", (User) request.getSession().getAttribute("user"));
		request.setAttribute("gruppenlist", ((User) request.getSession().getAttribute("user")).getGruppen());
		forward = "groups";
		return forward;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	private void checkMessage(String field, HttpServletRequest request) {
		if ((Message) request.getSession().getAttribute("errors") != null) {
			if (!((Message) request.getSession().getAttribute("errors")).getField().equals(field)) {
				Message message = new Message("", "");
				request.getSession().setAttribute("errors", message);
			}
		}
	}
}
