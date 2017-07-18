package de.fom.tippspiel.model;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import de.fom.tippspiel.persistence.Gruppe;
import de.fom.tippspiel.persistence.Studiengang;
import de.fom.tippspiel.persistence.User;

public class GroupsForm {

	private ArrayList<Gruppe> gruppenlist;
	private ArrayList<Gruppe> allegruppen;
	private ArrayList<Studiengang> studiengaenge;

	public GroupsForm(HttpServletRequest request, User user, ArrayList<Gruppe> alleGruppen,
			ArrayList<Studiengang> studienGaenge) {

		gruppenlist = user.getGruppen();
		allegruppen = alleGruppen;
		for (Iterator iterator = allegruppen.iterator(); iterator.hasNext();) {
			Gruppe gruppe = (Gruppe) iterator.next();
			ArrayList<User> alleuser = gruppe.getUser();
			for (User u : alleuser) {
				if (u.getId().equals(u.getId()))
					System.out.println("gelöscht");
				iterator.remove();
				break;
			}
		}
		studiengaenge = studienGaenge;
	}

	public ArrayList<Gruppe> getGruppenlist() {
		return gruppenlist;
	}

	public void setGruppenlist(ArrayList<Gruppe> gruppenlist) {
		this.gruppenlist = gruppenlist;
	}

	public ArrayList<Gruppe> getAllegruppen() {
		return allegruppen;
	}

	public void setAllegruppen(ArrayList<Gruppe> allegruppen) {
		this.allegruppen = allegruppen;
	}

	public ArrayList<Studiengang> getStudiengaenge() {
		return studiengaenge;
	}

	public void setStudiengaenge(ArrayList<Studiengang> studiengaenge) {
		this.studiengaenge = studiengaenge;
	}

}
