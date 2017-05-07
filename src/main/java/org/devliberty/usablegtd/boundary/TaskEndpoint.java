package org.devliberty.usablegtd.boundary;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.devliberty.usablegtd.control.TaskRepository;
import org.devliberty.usablegtd.entity.Task;

@RequestScoped
@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskEndpoint {
	
	@Inject
	private TaskRepository repository;
	
	@POST
	public Response create(final Task task) {
		Long id = repository.create(task);
		return Response.created(UriBuilder.fromResource(TaskEndpoint.class)
				.path(String.valueOf(id))
				.build())
				.build();
	}

}

