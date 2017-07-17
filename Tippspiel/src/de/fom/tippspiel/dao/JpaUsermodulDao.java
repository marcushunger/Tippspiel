package de.fom.tippspiel.dao;

import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import de.fom.tippspiel.controller.DaoException;
import de.fom.tippspiel.persistence.Usermodul;

@Transactional
@Alternative
public class JpaUsermodulDao implements UsermodulDao{

	@Inject
	private EntityManager manager;

	@Override
	public List<Usermodul> list(Integer id) throws DaoException {

		TypedQuery<Usermodul> queryLogin = manager.createQuery("select u from Usermodul u WHERE u.user.id = :id", Usermodul.class);
		queryLogin.setParameter("id", id);
		List<Usermodul> usermodule = queryLogin.getResultList();
		return usermodule;
	}

}
