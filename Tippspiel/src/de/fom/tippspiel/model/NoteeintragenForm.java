package de.fom.tippspiel.model;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import de.fom.tippspiel.persistence.Modul;
import de.fom.tippspiel.view.Message;

public class NoteeintragenForm {

	private double notetipp = 0;
	private double notereal = 0;

	private double[] noten = { 1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0, 3.3, 3.7, 4.0, 4.3, 4.7, 5.0, 5.3, 5.7, 6.0 };
	private Integer abweichung = 0;

	private List<Modul> listeusermodule;

	public NoteeintragenForm(HttpServletRequest request, List<Modul> listeModule) {

		if (StringUtils.isNotBlank(request.getParameter("notetipp"))) {
			notetipp = Float.parseFloat(request.getParameter("notetipp"));
		}
		if (StringUtils.isNotBlank(request.getParameter("notereal"))) {

			notereal = Float.parseFloat(request.getParameter("notereal"));
		}
		if (notetipp > 0 && notereal > 0) {
			int indexReal = Arrays.asList(noten).indexOf(notereal);
			int indexTipp = Arrays.asList(noten).indexOf(notetipp);

			abweichung = indexReal - indexTipp;
		}
		listeusermodule = listeModule;
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

	public List<Modul> getListeusermodule() {
		return listeusermodule;
	}

	public void setListeusermodule(List<Modul> listeusermodule) {
		this.listeusermodule = listeusermodule;
	}
}
