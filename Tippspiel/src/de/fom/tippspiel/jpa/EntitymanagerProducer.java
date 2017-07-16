package de.fom.tippspiel.jpa;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntitymanagerProducer {
	
	@Produces
	@PersistenceContext(unitName="tippdatasource")
	public EntityManager manager;
	
	

}
