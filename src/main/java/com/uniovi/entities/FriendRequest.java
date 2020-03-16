package com.uniovi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TREQUEST")
public class FriendRequest {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private User requestingUser;

	@ManyToOne
	private User requestedUser;

	public FriendRequest() {
	}

	public FriendRequest(User requestingUser, User requestedUser) {
		super();
		this.requestingUser = requestingUser;
		this.requestedUser = requestedUser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getRequestingUser() {
		return requestingUser;
	}

	public void setRequestingUser(User requestingUser) {
		this.requestingUser = requestingUser;
	}

	public User getRequestedUser() {
		return requestedUser;
	}

	public void setRequestedUser(User requestedUser) {
		this.requestedUser = requestedUser;
	}

}
