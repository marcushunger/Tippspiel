package de.fom.tippspiel.dao;

import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import de.fom.tippspiel.controller.DaoException;
import de.fom.tippspiel.persistence.User;

@Transactional
@Alternative
public class JpaPersonDao implements PersonDao {

	@Inject
	private EntityManager manager;

	@Override
	public User read(Integer id) throws DaoException {

		// TypedQuery<User> query = manager.createQuery("select p from User p
		// WHERE p.id = :id", User.class);
		// return query.setParameter("id", id).getSingleResult();
		return manager.find(User.class, id);
	}

	@Override
	public User register(String name, String email, String passwort) throws DaoException {

		User p = new User();
		p.setEmail(email);
		p.setUsername(name);
		p.setPassphrase(passwort);
		// TODO richtige werte hashen aber es reicht dann einer + salt
		// p.setPassphrase_md5("1d028378e12ca6bdafa3b8b21bc5a9ea".toCharArray());
		p.setPassphrase_sha2(
				"d739ed5b76982107147faa7883d4112f057e5a3b7efc137e2b9eb962e0f6cf395eee5e1c696f1113f29b29154dee55682a35088d7c599561ceb5f2654ff1c1aa"
						.toCharArray());
		p.setPassphrase_sha2_salted(
				"b85a97216050884f0b20f8382063241daeff7a196322a3b68b7ce58290ac4786867f2e4069750fa2bf39d9175c3d2a6cb7be7fbc59165cd58976689c7e7dc328"
						.toCharArray());
		p.setSalt("8wk8Sr5Pd98B6yLwyzSK9qEe0EAEQ4AjogY1YE1OPbs=");

		manager.persist(p);

		return p;

	}

	@Override
	public User update(User p, String name, String email, String passwort) throws DaoException {

		if (checkEmail(email, p.getId()) == false) {
			p.setEmail(email);
			p.setUsername(name);
			p.setPassphrase(passwort);
			// TODO richtige werte hashen aber es reicht dann einer + salt
			// p.setPassphrase_md5("1d028378e12ca6bdafa3b8b21bc5a9ea".toCharArray());
			// p.setPassphrase_sha2("d739ed5b76982107147faa7883d4112f057e5a3b7efc137e2b9eb962e0f6cf395eee5e1c696f1113f29b29154dee55682a35088d7c599561ceb5f2654ff1c1aa".toCharArray());
			// p.setPassphrase_sha2_salted("b85a97216050884f0b20f8382063241daeff7a196322a3b68b7ce58290ac4786867f2e4069750fa2bf39d9175c3d2a6cb7be7fbc59165cd58976689c7e7dc328".toCharArray());
			// p.setSalt("8wk8Sr5Pd98B6yLwyzSK9qEe0EAEQ4AjogY1YE1OPbs=");
			manager.merge(p);
		}
		return p;

	}

	@Override
	public void save(User p) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public User delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> list() throws DaoException {
		return manager.createQuery("select p from User p ", User.class).getResultList();
	}

	@Override
	public User login(String email, String password) throws DaoException {

		// TODO Passworthash nehmen aktuell einfacher Passwortvergleich ohne
		// verschlüsselung
		// JPA hat wohl keine sha2 funktion -
		// TypedQuery<Person> queryLogin = manager.createQuery("select p from
		// Person p WHERE p.email = :email and p.passphrase_sha2_salted =
		// sha2(CONCAT(:password, p.salt), 512)", Person.class);
		TypedQuery<User> queryLogin = manager
				.createQuery("select p from User p WHERE p.email = :email and p.passphrase = :password", User.class);
		queryLogin.setParameter("email", email);
		queryLogin.setParameter("password", password);
		try {
			return queryLogin.getSingleResult();
		} catch (Exception e) {
			throw new DaoException("Login fehlgeschlagen", null);
		}

	}

	@Override
	public boolean updatePassword(String email, String oldpassword, String newpassword) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkEmail(String value, int id) throws DaoException {
		TypedQuery<User> queryMail = manager.createQuery("select p from User p WHERE p.email = :email", User.class);
		queryMail.setParameter("email", value);
		try {
			if (queryMail.getSingleResult().getId() == id) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}

	}
}