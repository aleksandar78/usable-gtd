package org.devliberty.usablegtd.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@ApplicationScoped
public class AppProducer {

	public AppProducer() {}

	@Produces
	@PersistenceContext(unitName="usablegtd-persistence-unit")
	EntityManager em;
	
	@Produces @GTD
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}
	
}
