package de.fom.tippspiel.dao;

import de.fom.tippspiel.controller.DaoException;
import de.fom.tippspiel.persistence.Gruppe;
import de.fom.tippspiel.persistence.User;

public interface GruppeDao {

	public Gruppe register(String bezeichnung, User user) throws DaoException;
}
