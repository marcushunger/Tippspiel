package de.fom.tippspiel.dao;

import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.TransactionalException;

import org.mindrot.jbcrypt.BCrypt;

import de.fom.tippspiel.controller.DaoException;
import de.fom.tippspiel.persistence.Gruppe;
import de.fom.tippspiel.persistence.Studiengang;
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
	public Studiengang readStudiengang(Integer id) throws DaoException {

		// TypedQuery<Studiengang> query = manager.createQuery("select * from
		// Studiengang p WHERE p.id = :id",
		// Studiengang.class);
		// return query.setParameter("id", id).getSingleResult();
		return manager.find(Studiengang.class, id);
	}

	@Override
	public User register(String name, String email, String passwort) throws DaoException {

		User p = new User();
		p.setEmail(email);
		p.setUsername(name);
		String salt = BCrypt.gensalt(12);
		String passHash = BCrypt.hashpw(passwort, BCrypt.gensalt(12));
		p.setPassphrase(passHash);
		p.setSalt(salt);
		p.setPassphrase_sha2_salted(passHash.toCharArray());
		p.setPassphrase_sha2(passHash.toCharArray());

		manager.persist(p);

		return p;

	}

	@Override
	public User update(User u, String username, String email, String passwortneu) throws DaoException {

		if (!u.getUsername().equals(username)) {
			u.setUsername(username);
		}

		if (!u.getEmail().equals(email)) {
			u.setEmail(email);
		}

		String salt = BCrypt.gensalt(12);
		String passHash = BCrypt.hashpw(passwortneu, BCrypt.gensalt(12));
		u.setPassphrase(passHash);
		u.setSalt(salt);
		u.setPassphrase_sha2_salted(passHash.toCharArray());
		u.setPassphrase_sha2(passHash.toCharArray());
		System.out.println("Lukas UPDATE USER START");
		System.out.println("Lukas Email: " + u.getEmail());
		System.out.println("Lukas Username: " + u.getUsername());
		System.out.println("Passwort: " + passwortneu);
		System.out.println("Lukas Passphrase: " + u.getPassphrase());
		System.out.println("Lukas Salt: " + u.getSalt());
		System.out.println("Lukas Username: " + u.getPassphrase_sha2().toString());
		System.out.println("Lukas Email: " + u.getPassphrase_sha2_salted().toString());
		System.out.println("Lukas UPDATE USER ENDE");
		manager.merge(u);

		return u;

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
	public User login(String email, String password) throws DaoException, PersistenceException, TransactionalException {

		TypedQuery<User> queryLogin = manager.createQuery("select p from User p WHERE p.email = :email", User.class);
		queryLogin.setParameter("email", email);
		User user = queryLogin.getSingleResult();

		System.out.println("Lukas: " + user.getPassphrase());
		System.out.println("Lukas: " + user.getEmail());
		System.out.println("Lukas: " + user.getSalt());
		System.out.println("Lukas boolen: " + BCrypt.checkpw(password, queryLogin.getSingleResult().getPassphrase()));

		if (user != null) {
			if (BCrypt.checkpw(password, queryLogin.getSingleResult().getPassphrase())) {
				return user;
			}
		}

		return null;
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

	@Override
	public void register(String bezeichnung, User user, Studiengang studiengang) throws DaoException {
		User u = user;
		Gruppe g = new Gruppe();

		g.setBezeichnung(bezeichnung);
		g.setStudiengang(studiengang);
		u.getGruppen().add(g);
		manager.merge(u);
	}
}