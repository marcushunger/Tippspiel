package de.fom.tippspiel.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import de.fom.tippspiel.persistence.Gruppe;
import de.fom.tippspiel.persistence.Studiengang;
import de.fom.tippspiel.persistence.User;
import de.fom.tippspiel.persistence.Usermodul;

public class HomeForm {

	private ArrayList<Gruppe> listgrupen = new ArrayList<Gruppe>();
	private ArrayList<User> listuser = new ArrayList<User>();
	private Gruppe auswahlgruppe = new Gruppe();

	public ArrayList<User> getListuser() {
		return listuser;
	}

	public void setListuser(ArrayList<User> listuser) {
		this.listuser = listuser;
	}

	public ArrayList<Gruppe> getListgrupen() {
		return listgrupen;
	}

	public void setListgrupen(ArrayList<Gruppe> listgrupen) {
		this.listgrupen = listgrupen;
	}

	public Gruppe getAuswahlgruppe() {
		return auswahlgruppe;
	}

	public void setAuswahlgruppe(Gruppe auswahlgruppe) {
		this.auswahlgruppe = auswahlgruppe;
	}

	public HomeForm(HttpServletRequest request, User user) {
		User u = user;
		listgrupen = u.getGruppen();
	}

	public HomeForm(HttpServletRequest request, User us, Gruppe gruppe) {
		auswahlgruppe = gruppe;
		User u = us;
		listgrupen = u.getGruppen();
		Studiengang stud = gruppe.getStudiengang();
		for (User user2 : gruppe.getUser()) {
			// User u2 = user2;
			int abweichungSumme = 0;
			for (Usermodul usermodul : user2.getModule()) {
				if (usermodul.getModul().getStudiengaenge().contains(stud)) {
					if (usermodul.getNotereal() > 0) {
						double diff = usermodul.getNotereal() - usermodul.getNotetipp();
						double teiler = 0.3;
						int abweichung = Math.abs((int) (diff / teiler));
						abweichungSumme += abweichung;
					}
				}
			}
			user2.setSumme(abweichungSumme);
			listuser.add(user2);
		}
	}
}
