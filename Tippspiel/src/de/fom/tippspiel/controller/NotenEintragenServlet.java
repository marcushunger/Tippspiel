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
import de.fom.tippspiel.dao.UsermodulDao;
import de.fom.tippspiel.persistence.Modul;
import de.fom.tippspiel.persistence.User;
import de.fom.tippspiel.persistence.Usermodul;
import de.fom.tippspiel.view.Message;

public class NotenEintragenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private UsermodulDao usermodulDao;
	@Inject
	private PersonDao personDao;

	List<Message> errors = new ArrayList<Message>();

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Message message = new Message("n", "");
		errors.clear();
		String action = request.getParameter("action");
		User u = (User) request.getSession().getAttribute("user");
		try {
			if (action.equals("actionreal")) {
				String smodulId = request.getParameter("modulreal");
				String snotereal = request.getParameter("notereal");
				if (smodulId.isEmpty() || snotereal.isEmpty()) {
					message.setMessage("Bitte gültige Werte eintragen");
					errors.add(message);
					request.setAttribute("errors", errors);
					request.getSession().setAttribute("user", personDao.read(u.getId()));
					request.getRequestDispatcher("/noteeintragen.html").forward(request, response);
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
					errors.add(message);
					request.setAttribute("errors", errors);
					request.getSession().setAttribute("user", personDao.read(u.getId()));
					request.getRequestDispatcher("/noteeintragen.html").forward(request, response);
				} else {
					Integer modulId = Integer.parseInt(smodulId);
					double notetipp = Double.parseDouble(snotereal);
					Modul m = usermodulDao.readModul(modulId);
					usermodulDao.tippEintragen(m, notetipp, u);
				}
			}
		} catch (Exception e) {
			message.setMessage(e.getCause().getMessage());
			errors.add(message);
			request.setAttribute("errors", errors);
			request.getSession().setAttribute("user", personDao.read(u.getId()));
			request.getRequestDispatcher("/noteeintragen.html").forward(request, response);
		}
		request.getSession().setAttribute("user", personDao.read(u.getId()));
		request.getRequestDispatcher("/noteeintragen.html").forward(request, response);
		// response.sendRedirect(request.getContextPath() +
		// "/noteeintragen.html");
	}
}
