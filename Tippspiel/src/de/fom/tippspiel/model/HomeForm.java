package de.fom.tippspiel.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import de.fom.tippspiel.persistence.Gruppe;
import de.fom.tippspiel.persistence.User;
import de.fom.tippspiel.persistence.Usermodul;

public class HomeForm {

	private ArrayList<Gruppe> listgrupen = new ArrayList<Gruppe>();

	public ArrayList<Gruppe> getListgrupen() {
		return listgrupen;
	}

	public void setListgrupen(ArrayList<Gruppe> listgrupen) {
		this.listgrupen = listgrupen;
	}

	public HomeForm(HttpServletRequest request, User user) {
		User u = user;
		// ArrayList<Gruppe> gruppen = u.getGruppen();
		for (Gruppe gruppe : user.getGruppen()) {
			// Gruppe g = gruppe;
			// ArrayList<User> listuser = g.getUser();
			for (User user2 : gruppe.getUser()) {
				// User u2 = user2;
				int abweichungSumme = 0;
				for (Usermodul usermodul : user2.getModule()) {
					if (usermodul.getNotereal() > 0) {
						double diff = usermodul.getNotereal() - usermodul.getNotetipp();
						double teiler = 0.3;
						int abweichung = Math.abs((int) (diff / teiler));
						abweichungSumme += abweichung;
					}
				}
				user2.setSumme(abweichungSumme);

			}
			listgrupen.add(gruppe);
		}
	}
}
