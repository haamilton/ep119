package br.com.hsj.ep119.api.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hsj.ep119.api.domain.User;

@Service
public class UserService {

	public List<User> find() {
		
		return createUsers();
	}
	
	
	private List<User> createUsers() {
		List<User> users = new ArrayList<User>();
		
		for (int i = 1; i < 21; i++) {
			users.add(new User(i, "Nome: " + i, "email" + i + "@gmail.com"));
		}
		
		return users;
	}
}
