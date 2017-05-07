package org.devliberty.usablegtd.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tasks")
@NamedQueries({
	@NamedQuery(name=Task.FIND_ALL, query="SELECT t FROM Task t"),
	@NamedQuery(name=Task.FIND_BY_OWNER, query="SELECT t FROM Task t WHERE t.user.id = :userId AND t.state IN :states")
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Task.findAll";
	public static final String FIND_BY_OWNER = "Task.findByOwner";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="completed_at")
	private Date completedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Column(length=50)
	private String description;

	@Column(length=20)
	private String state;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="owner", nullable=false)
	private User user;
	
	@PrePersist
	void onPersist() {
		setCreatedAt(new Date());
	}
	
	public Task() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCompletedAt() {
		return this.completedAt;
	}

	public void setCompletedAt(Date completedAt) {
		this.completedAt = completedAt;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}