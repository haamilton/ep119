package br.com.hsj.ep119.api.domain;

import java.util.List;

public class UserRepository {

	private List<User> users = null;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
