package org.devliberty.usablegtd.control;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.devliberty.usablegtd.entity.Task;
import org.devliberty.usablegtd.entity.User;


@ApplicationScoped
@Transactional
public class TaskRepository {

	@Inject
	private UserRepository userRepository;
	
	private EntityManager em;
	
	public TaskRepository() {}

	@Inject
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public Long create(Task task) {
		User cu = userRepository.getCurrentUser();
		task.setUser(cu);
		task.setState(TaskState.TODO.name());
		em.persist(task);
		return task.getId();
	}
	
	public Optional<Task> byId(Long id) {
		return Optional.ofNullable(em.find(Task.class, id));
	}
	
}
