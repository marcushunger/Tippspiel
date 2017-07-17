package de.fom.tippspiel.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Studiengang {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // weil autoincrement
	private Integer id;
	private String bezeichnung;
	private String uni;
	@ManyToMany(mappedBy = "studiengaenge")
	private List<Modul> module = new ArrayList<>();

	public List<Modul> getModule() {
		return module;
	}

	public void setModule(List<Modul> module) {
		this.module = module;
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

	public String getUni() {
		return uni;
	}

	public void setUni(String uni) {
		this.uni = uni;
	}

}
