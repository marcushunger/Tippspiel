package de.fom.tippspiel.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import de.fom.tippspiel.persistence.Modul;
import de.fom.tippspiel.persistence.Usermodul;
import de.fom.tippspiel.view.Message;

public class NoteeintragenForm {

	private double notetipp = 0;
	private double notereal = 0;

	private double[] noten = { 1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0, 3.3, 3.7, 4.0, 4.3, 4.7, 5.0, 5.3, 5.7, 6.0 };
	private Integer abweichung = 0;

	private ArrayList<Modul> listmodule;
	private ArrayList<Usermodul> listusermodule;
	private ArrayList<Usermodul> listusermodulem;

	public NoteeintragenForm(HttpServletRequest request, ArrayList<Modul> listeModule,
			ArrayList<Usermodul> listeUsermodule) {

		for (Usermodul usermodul : listeUsermodule) {
			if (usermodul.getNotereal() > 0) {
				double diff = usermodul.getNotereal() - usermodul.getNotetipp();
				double teiler = 0.3;
				int abweichung = (int) (diff / teiler);
				usermodul.setAbweichung(abweichung);
			}
		}

		listmodule = listeModule;
		listusermodule = listeUsermodule;
		listusermodulem = (ArrayList<Usermodul>) listeUsermodule.clone();
		for (Iterator iterator = listusermodulem.iterator(); iterator.hasNext();) {
			Usermodul usermodul = (Usermodul) iterator.next();
			if (usermodul.getNotereal() > 0) {
				iterator.remove();
			}
		}
	}

	// public Person getPerson() {
	// Person p = new Person();
	// p.setId(id);
	// p.setGender(gender);
	// p.setFirstname(firstname);
	// p.setLastname(lastname);
	// p.setEmail(email);
	// if(StringUtils.isNotBlank(birthday)){
	// try {
	// p.setBirthday(dateFormat.parse(birthday));
	// } catch (ParseException e) {
	// e.printStackTrace();
	// }
	// }
	// if(StringUtils.isNotBlank(height)){
	// try {
	// p.setHeight(decimalFormat.parse(height).doubleValue());
	// } catch (ParseException e) {
	// e.printStackTrace();
	// }
	// }
	// p.setCompanyid(companyid);
	// p.setNewsletter(newsletter);
	// p.setComment(comment);
	// p.setInterests(interests);
	// return p;
	// }

	public void validate(List<Message> errors) {

	}

	public double getNotetipp() {
		return notetipp;
	}

	public void setNotetipp(double notetipp) {
		this.notetipp = notetipp;
	}

	public double getNotereal() {
		return notereal;
	}

	public void setNotereal(double notereal) {
		this.notereal = notereal;
	}

	public double[] getNoten() {
		return noten;
	}

	public void setNoten(double[] noten) {
		this.noten = noten;
	}

	public Integer getAbweichung() {
		return abweichung;
	}

	public void setAbweichung(Integer abweichung) {
		this.abweichung = abweichung;
	}

	public ArrayList<Modul> getListmodule() {
		return listmodule;
	}

	public void setListmodule(ArrayList<Modul> listmodule) {
		this.listmodule = listmodule;
	}

	public ArrayList<Usermodul> getListusermodule() {
		return listusermodule;
	}

	public void setListusermodule(ArrayList<Usermodul> listusermodule) {
		this.listusermodule = listusermodule;
	}

	public ArrayList<Usermodul> getListusermodulem() {
		return listusermodulem;
	}

	public void setListusermodulem(ArrayList<Usermodul> listusermodulem) {
		this.listusermodulem = listusermodulem;
	}
}
