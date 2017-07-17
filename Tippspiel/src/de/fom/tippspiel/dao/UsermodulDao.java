package de.fom.tippspiel.dao;

import java.util.*;

import de.fom.tippspiel.controller.DaoException;
import de.fom.tippspiel.persistence.*;

public interface UsermodulDao {
	
	public List<Usermodul> list(Integer id) throws DaoException;
	
}
