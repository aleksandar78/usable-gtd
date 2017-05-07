package org.devliberty.usablegtd.boundary;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
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

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		Optional<Task> opt = repository.byId(id);
		if (!opt.isPresent()) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(opt.get()).build();
	}

	@GET
	public List<Task> listAll(@QueryParam("start") final Integer startPosition,	@QueryParam("max") final Integer maxResult) {
		// no pagination required for now
		return repository.getAllForCurrentUser();
	}

}

