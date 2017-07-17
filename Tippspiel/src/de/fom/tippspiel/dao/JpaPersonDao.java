package de.fom.tippspiel.dao;

import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

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
		// if (checkEmail(email, p.getId()) == false) {
		// p.setEmail(email);
		// p.setUsername(name);
		// p.setPassphrase(passwort);
		// // TODO richtige werte hashen aber es reicht dann einer + salt
		// //
		// p.setPassphrase_md5("1d028378e12ca6bdafa3b8b21bc5a9ea".toCharArray());
		// //
		// p.setPassphrase_sha2("d739ed5b76982107147faa7883d4112f057e5a3b7efc137e2b9eb962e0f6cf395eee5e1c696f1113f29b29154dee55682a35088d7c599561ceb5f2654ff1c1aa".toCharArray());
		// //
		// p.setPassphrase_sha2_salted("b85a97216050884f0b20f8382063241daeff7a196322a3b68b7ce58290ac4786867f2e4069750fa2bf39d9175c3d2a6cb7be7fbc59165cd58976689c7e7dc328".toCharArray());
		// // p.setSalt("8wk8Sr5Pd98B6yLwyzSK9qEe0EAEQ4AjogY1YE1OPbs=");

		System.out.println("Lukas Email: " + u.getEmail());
		System.out.println("Lukas Username: " + u.getUsername());
		System.out.println("Lukas Email: " + u.getPassphrase());

		manager.merge(u);
		// }
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
	public User login(String email, String password) throws DaoException {

		TypedQuery<User> queryLogin = manager.createQuery("select p from User p WHERE p.email = :email", User.class);
		queryLogin.setParameter("email", email);
		User user = queryLogin.getSingleResult();

		System.out.println("Lukas boolen: " + BCrypt.checkpw(password, queryLogin.getSingleResult().getPassphrase()));

		if (user != null) {
			if (BCrypt.checkpw(password, queryLogin.getSingleResult().getPassphrase())) {
				return user;
			}
		} else {
			// TODO Hier wäre eine Meldung gut, dass login nicht klappt ,
			// passwort falsch
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