package de.fom.tippspiel.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Studiengangmodul {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //weil autoincrement
	private Integer id;
	@JoinColumn(name="fidstudiengang")
	private Studiengang studiengang;
	@JoinColumn(name="fidmodul")
	private Modul modul;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Studiengang getStudiengang() {
		return studiengang;
	}
	public void setStudiengang(Studiengang studiengang) {
		this.studiengang = studiengang;
	}
	public Modul getModul() {
		return modul;
	}
	public void setModul(Modul modul) {
		this.modul = modul;
	}

}
