package de.fom.tippspiel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fom.tippspiel.dao.PersonDao;
import de.fom.tippspiel.persistence.Gruppe;
import de.fom.tippspiel.persistence.Studiengang;
import de.fom.tippspiel.persistence.User;
import de.fom.tippspiel.view.Message;

public class GroupsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Message> errors = new ArrayList<Message>();

	@Inject
	private PersonDao personDao;

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Message m = new Message("g", "");
		String action = request.getParameter("action");
		User u = (User) request.getSession().getAttribute("user");
		if (action.equals("actionanlegen")) {
			String bezeichnung = request.getParameter("bez");
			String sstudiengangId = request.getParameter("studiengang");
			if (bezeichnung.isEmpty() || sstudiengangId.isEmpty()) {
				m.setMessage("Bitte Gruppennamen und Studiengang angeben");
				errors.add(m);
				request.setAttribute("errors", errors);
			} else {
				Integer studiengangId = Integer.parseInt(sstudiengangId);
				Studiengang studiengang = personDao.readStudiengang(studiengangId);
				personDao.register(bezeichnung, u, studiengang);
			}
		} else if (action.equals("actionbeitritt")) {
			String sgruppenId = request.getParameter("allegruppen");
			if (sgruppenId.isEmpty()) {
				m.setMessage("Bitte Gruppe auswählen");
				errors.add(m);
				request.setAttribute("errors", errors);
			} else {
				Integer gruppenId = Integer.parseInt(sgruppenId);
				Gruppe gruppe = personDao.readGruppe(gruppenId);
				personDao.registerGruppe(gruppe, u);
			}
		}
		request.getSession().setAttribute("user", personDao.read(u.getId()));
		response.sendRedirect(request.getContextPath() + "/groups.html");
	}
}
