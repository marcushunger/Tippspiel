package de.fom.tippspiel.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Usermodul {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //weil autoincrement
	private Integer id;
	private double noteTipp;
	private double noteReal;
	@JoinColumn(name="fiduser")
	private User user;
	@JoinColumn(name="fidmodul")
	private Modul modul;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getNoteTipp() {
		return noteTipp;
	}
	public void setNoteTipp(double noteTipp) {
		this.noteTipp = noteTipp;
	}
	public double getNoteReal() {
		return noteReal;
	}
	public void setNoteReal(double noteReal) {
		this.noteReal = noteReal;
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
