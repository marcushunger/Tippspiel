package de.fom.tippspiel.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
//@NamedQueries({
//	@NamedQuery(name = Usergruppe.GET_USER_GRUPPEN, query = "SELECT g.gruppe FROM Usergruppe g WHERE g.user.id = :userid")
//})
public class Usergruppe {
	
	public static final String GET_USER_GRUPPEN = "getUserGruppen";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //weil autoincrement
	private Integer id;
	@JoinColumn(name="fiduser")
	private User user;
	@JoinColumn(name="fidgruppe")
	private Gruppe gruppe;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Gruppe getGruppe() {
		return gruppe;
	}
	public void setGruppe(Gruppe gruppe) {
		this.gruppe = gruppe;
	}

}
