package org.devliberty.usablegtd.boundary;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.devliberty.usablegtd.config.GTD;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@ApplicationScoped
@Path("/helthcheck")
@Produces(MediaType.APPLICATION_JSON)
public class HealthCheckEndpoint {

	@Inject
	@ConfigurationValue("project.stage")
	String stageInfo;

	@Inject
	@GTD
	private ObjectMapper jsonMapper;
	
	@GET
	public Response getInfo() {
		ObjectNode info = jsonMapper.createObjectNode()
			.put("name", "Usable GTD")
			.put("stage", stageInfo);
		return Response.ok(info).build();
	}
	
}