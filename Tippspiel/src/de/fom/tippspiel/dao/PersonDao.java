package de.fom.tippspiel.dao;

import java.util.ArrayList;
import java.util.List;

import de.fom.tippspiel.controller.DaoException;
import de.fom.tippspiel.persistence.Gruppe;
import de.fom.tippspiel.persistence.Studiengang;
import de.fom.tippspiel.persistence.User;

public interface PersonDao {

	public User read(Integer id) throws DaoException;

	public Studiengang readStudiengang(Integer id) throws DaoException;

	public void save(User p) throws DaoException;

	public User delete(Integer id) throws DaoException;

	public List<User> list() throws DaoException;

	public User login(String email, String password) throws DaoException;

	public boolean updatePassword(String email, String oldpassword, String newpassword) throws DaoException;

	// TODO Passwort nicht als String schieben
	public User register(String name, String email, String passwort) throws DaoException;

	public User update(User p, String username, String email, String passwort) throws DaoException;

	public boolean checkEmail(String value, int id) throws DaoException;

	public void register(String bezeichnung, User user, Studiengang studiengang) throws DaoException;

	public ArrayList<Gruppe> listGroups() throws DaoException;

	public ArrayList<Studiengang> listStudy() throws DaoException;

	public Gruppe readGruppe(Integer id) throws DaoException;

	public void registerGruppe(Gruppe gruppe, User user) throws DaoException;

}
