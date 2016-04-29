package br.com.hsj.ep119.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hsj.ep119.api.domain.User;

@RestController
public class UserRestController {

	// ------------------- Retrieve All Users --------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = createUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	private List<User> createUsers() {
		List<User> users = new ArrayList<User>();
		
		for (Long i = 1L; i < 21; i++) {
			users.add(new User(i, "Nome: " + i, "email" + i + "@gmail.com"));
		}
		
		return users;
	}
}
