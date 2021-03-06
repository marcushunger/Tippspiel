package de.fom.tippspiel.persistence;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Modul {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // weil autoincrement
	private Integer id;
	private String bezeichnung;
	private Integer creditpoints;

	// @ManyToMany
	// @JoinTable(name = "studiengangmodul", joinColumns = @JoinColumn(name =
	// "fidgruppe", referencedColumnName = "id"), inverseJoinColumns =
	// @JoinColumn(name = "fidstudiengang", referencedColumnName = "id"))
	@ManyToMany(mappedBy = "module")
	private ArrayList<Studiengang> studiengaenge = new ArrayList<>();

	@OneToMany(mappedBy = "modul")
	private ArrayList<Usermodul> user = new ArrayList<>();

	public Integer getCreditpoints() {
		return creditpoints;
	}

	public void setCreditpoints(Integer creditpoints) {
		this.creditpoints = creditpoints;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public ArrayList<Studiengang> getStudiengaenge() {
		return studiengaenge;
	}

	public void setStudiengaenge(ArrayList<Studiengang> studiengaenge) {
		this.studiengaenge = studiengaenge;
	}

	public ArrayList<Usermodul> getUser() {
		return user;
	}

	public void setUser(ArrayList<Usermodul> user) {
		this.user = user;
	}

}
