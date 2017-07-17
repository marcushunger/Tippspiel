package de.fom.tippspiel.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getNoteTipp() {
		return notetipp;
	}

	public void setNoteTipp(double noteTipp) {
		this.notetipp = noteTipp;
	}

	public double getNoteReal() {
		return notereal;
	}

	public void setNoteReal(double noteReal) {
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
}
