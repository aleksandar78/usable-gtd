package org.devliberty.usablegtd.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.fasterxml.jackson.databind.ObjectMapper;

@ApplicationScoped
public class AppProducer {

	public AppProducer() {}

	@Produces @GTD
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}
	
}
