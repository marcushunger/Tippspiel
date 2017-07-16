package de.fom.tippspiel.model;

import java.util.*;

import org.apache.commons.lang3.*;

import de.fom.tippspiel.persistence.*;
import de.fom.tippspiel.view.Message;

public class ChangeForm {
	
	private Integer id;
	private String username;
	private String email;
	private String passphrase;
	
	public ChangeForm(User p){
		id = p.getId();
//		gender = p.getGender();
//		firstname = p.getFirstname();
//		lastname = p.getLastname();
		email = p.getEmail();
//		if(p.getBirthday()!=null){
//			birthday = dateFormat.format(p.getBirthday());
//		}
//		if(p.getHeight()!=null){
//			height =decimalFormat.format(p.getHeight());
//		}
		username = p.getUsername();
		passphrase = p.getPassphrase();
//		newsletter = p.isNewsletter();
//		comment = p.getComment();
	}
	
	/*public ChangeForm(HttpServletRequest request, DateFormat dateFormat, NumberFormat decimalFormat){
		this(dateFormat, decimalFormat);
		if(StringUtils.isNotBlank(request.getParameter("id"))){
			id = Integer.parseInt(request.getParameter("id"));
		}
		if(StringUtils.isNotBlank(request.getParameter("gender"))){
			gender = Gender.valueOf(request.getParameter("gender"));
		}else{
			gender = Gender.U;
		}
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		email = request.getParameter("email");
		birthday = request.getParameter("birthday");
		height = request.getParameter("height");
		if(StringUtils.isNotBlank(request.getParameter("companyid"))){
			companyid = Integer.parseInt(request.getParameter("companyid"));
		}
		newcompany = request.getParameter("newcompany");
		if(request.getParameter("newsletter")!=null){
			newsletter = true;
		}
		comment = request.getParameter("comment");
		interests = new HashSet<>();
		String[] sa = request.getParameterValues("interests");
		if(sa!=null){
			for (String string : sa) {
				interests.add(Integer.parseInt(string));
			}
		}
	}*/
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


	public User getPerson() {
		User p = new User();
		p.setId(id);
		p.setEmail(email);
		p.setUsername(username);
		p.setPassphrase(passphrase);

		return p;
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

	public void setPassphrase(String passwort) {
		this.passphrase = passwort;
	}

	public void validate(List<Message> errors) {
		if(StringUtils.isBlank(email)){
			errors.add(new Message("email", "Email required"));
		}
	}
	
	
}
