package de.fom.tippspiel.dao;

import java.util.List;

import de.fom.tippspiel.controller.DaoException;
import de.fom.tippspiel.persistence.Modul;
import de.fom.tippspiel.persistence.User;
import de.fom.tippspiel.persistence.Usermodul;

public interface UsermodulDao {

	public List<Usermodul> list(Integer id) throws DaoException;

	public void tippEintragen(Modul m, double tipp, User u) throws DaoException;

}
