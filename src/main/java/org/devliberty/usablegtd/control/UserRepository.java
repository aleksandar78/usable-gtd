package org.devliberty.usablegtd.control;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.devliberty.usablegtd.entity.User;

@ApplicationScoped
public class UserRepository {

	private EntityManager em;
	
	public UserRepository() {}

	@Inject
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public User getCurrentUser() {
		return em.find(User.class, userId());
	}
	
	/*
	 *  Fake validator return constant 
	 *  user id.
	 *  
	 *  Future release - token auth validation
	 *  
	 */
	private Integer userId() {
		return 1;
	}
	
}
