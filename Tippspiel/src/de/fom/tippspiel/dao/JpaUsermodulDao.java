package de.fom.tippspiel.dao;

import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import de.fom.tippspiel.controller.DaoException;
import de.fom.tippspiel.persistence.Modul;
import de.fom.tippspiel.persistence.User;
import de.fom.tippspiel.persistence.Usermodul;

@Transactional
@Alternative
public class JpaUsermodulDao implements UsermodulDao {

	@Inject
	private EntityManager manager;

	@Override
	public List<Usermodul> list(Integer id) throws DaoException {

		TypedQuery<Usermodul> queryLogin = manager.createQuery("select u from Usermodul u WHERE u.user.id = :id",
				Usermodul.class);
		queryLogin.setParameter("id", id);
		List<Usermodul> usermodule = queryLogin.getResultList();
		return usermodule;
	}

	@Override
	public void tippEintragen(Modul m, double tipp, User u) throws DaoException {
		User user = u;
		Usermodul um = new Usermodul();
		um.setModul(m);
		um.setNotetipp(tipp);
		um.setUser(user);
		user.getModule().add(um);
		manager.merge(user);
	}

	@Override
	public Modul readModul(Integer id) throws DaoException {
		return manager.find(Modul.class, id);
	}

	@Override
	public void realEintragen(Usermodul m, double real) throws DaoException {
		Usermodul um = m;
		m.setNotereal(real);
		manager.merge(um);

	}

	@Override
	public Usermodul readUserModul(Integer id) throws DaoException {
		return manager.find(Usermodul.class, id);
	}

}
