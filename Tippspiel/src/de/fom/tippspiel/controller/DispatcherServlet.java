package de.fom.tippspiel.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import de.fom.tippspiel.dao.PersonDao;
import de.fom.tippspiel.model.ChangeForm;
import de.fom.tippspiel.model.GroupsForm;
import de.fom.tippspiel.model.HomeForm;
import de.fom.tippspiel.model.NoteeintragenForm;
import de.fom.tippspiel.persistence.User;
import de.fom.tippspiel.view.Message;

public class DispatcherServlet extends HttpServlet {

	@Inject
	private PersonDao personDao;

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("RequestURI: " + request.getRequestURI());
		String[] sa = StringUtils.split(request.getServletPath(), "/.\\");
		String forward = null;
		User us = (User) request.getSession().getAttribute("user");
		switch (sa[0]) {
		case "homegruppeuser":
			forward = "home";
			String gruppe = request.getParameter("gruppemitusern");
			System.out.println("Lukas: " + gruppe);
			HomeForm hformmitauswahlgruppe = new HomeForm(request, us);
			request.setAttribute("hformmitauswahlgruppe", hformmitauswahlgruppe);
			break;
		case "home":
			forward = "home";
			HomeForm hform = new HomeForm(request, us);
			request.setAttribute("hform", hform);
			break;
		case "change":
			checkMessage("c", request);
			forward = "change";
			ChangeForm cform = new ChangeForm(us);
			request.setAttribute("cform", cform);
			break;
		case "groups":
			checkMessage("g", request);
			forward = "groups";
			GroupsForm gform = new GroupsForm(request, us, personDao.listGroups(), personDao.listStudy());
			request.setAttribute("gform", gform);
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
			NoteeintragenForm nform = new NoteeintragenForm(request, us);
			request.setAttribute("nform", nform);
			break;
		case "doku":
			forward = "doku";
			break;
		case "impressum":
			forward = "impressum";
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
		request.setAttribute("gruppenlist", ((User) request.getSession().getAttribute("user")).getGruppen());
		forward = "personlist";
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
