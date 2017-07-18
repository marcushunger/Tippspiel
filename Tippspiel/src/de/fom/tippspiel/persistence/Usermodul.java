package de.fom.tippspiel.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Usermodul {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // weil autoincrement
	private Integer id;
	private double notetipp;
	private double notereal;
	@ManyToOne
	@JoinColumn(name = "fiduser")
	private User user;
	@ManyToOne
	@JoinColumn(name = "fidmodul")
	private Modul modul;

	// Berechnung erfolgt �ber NoteeintrageForm
	@Transient
	private int abweichung;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getNotetipp() {
		return notetipp;
	}

	public void setNotetipp(double noteTipp) {
		this.notetipp = noteTipp;
	}

	public double getNotereal() {
		return notereal;
	}

	public void setNotereal(double noteReal) {
		this.notereal = noteReal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Modul getModul() {
		return modul;
	}

	public void setModul(Modul modul) {
		this.modul = modul;
	}

	public int getAbweichung() {
		return abweichung;
	}

	public void setAbweichung(int abweichung) {
		this.abweichung = abweichung;
	}
}
