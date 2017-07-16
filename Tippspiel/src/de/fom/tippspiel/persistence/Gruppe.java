package de.fom.tippspiel.persistence;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Gruppe {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //weil autoincrement
	private Integer id;
	private String bezeichnung;
	@JoinColumn(name="fidstudiengang")
	private Studiengang studiengang;
	@ManyToMany(mappedBy="gruppen")
	private List<User> user;
	
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
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	

}
