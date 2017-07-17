package de.fom.tippspiel.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // weil autoincrement
	private Integer id;
	private String email;
	private String username;
	private String passphrase;
	private char[] passphrase_sha2;
	private char[] passphrase_sha2_salted;
	private String salt;
	@ManyToMany
	@JoinTable(name = "usergruppe", joinColumns = @JoinColumn(name = "fiduser", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "fidgruppe", referencedColumnName = "id"))
	private List<Gruppe> gruppen = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	// @JoinTable(name = "usermodul", joinColumns = @JoinColumn(name =
	// "fiduser", referencedColumnName = "id"), inverseJoinColumns =
	// @JoinColumn(name = "fidmodul", referencedColumnName = "id"))
	private List<Usermodul> module = new ArrayList<>();

	public User() {
	}

	public User(String email, String passphrase) {
		this.setEmail(email);
		this.passphrase = passphrase;
	}

	public User(Integer id, String email, String firstname, String lastname, Date birthday) {
		this.id = id;
		this.setEmail(email);
		// this.firstname = firstname;
		// this.lastname = lastname;
		// this.birthday = birthday;
	}

	public User(Integer id, String firstname, String lastname, String email, Date birthday, Double height,
			Integer companyid, String comment, boolean newsletter) {
		this.id = id;
		this.username = firstname;
		this.setEmail(email);
		// this.birthday = birthday;
		// this.height = height;
		// this.companyid = companyid;
		// this.comment = comment;
		// this.newsletter = newsletter;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassphrase() {
		return passphrase;
	}

	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}

	public char[] getPassphrase_sha2_salted() {
		return passphrase_sha2_salted;
	}

	public void setPassphrase_sha2_salted(char[] passphrase_sha2_salted) {
		this.passphrase_sha2_salted = passphrase_sha2_salted;
	}

	public char[] getPassphrase_sha2() {
		return passphrase_sha2;
	}

	public void setPassphrase_sha2(char[] passphrase_sha2) {
		this.passphrase_sha2 = passphrase_sha2;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public List<Gruppe> getGruppen() {
		return gruppen;
	}

	public void setGruppen(List<Gruppe> gruppen) {
		this.gruppen = gruppen;
	}

	public List<Usermodul> getModule() {
		return module;
	}

	public void setModule(List<Usermodul> module) {
		this.module = module;
	}

}
