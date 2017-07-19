package de.fom.tippspiel.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import de.fom.tippspiel.persistence.Gruppe;
import de.fom.tippspiel.persistence.Studiengang;
import de.fom.tippspiel.persistence.User;

public class GroupsForm {

	private ArrayList<Gruppe> gruppenlist;
	private ArrayList<Gruppe> allegruppen = new ArrayList<Gruppe>();
	private ArrayList<Studiengang> studiengaenge;

	public GroupsForm(HttpServletRequest request, User user, ArrayList<Gruppe> alleGruppen,
			ArrayList<Studiengang> studienGaenge) {

		gruppenlist = user.getGruppen();
		allegruppen = alleGruppen;

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
