package br.com.hsj.ep119.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hsj.ep119.api.business.UserService;
import br.com.hsj.ep119.api.domain.User;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;  
	
	// ------------------- Retrieve All Users --------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.find();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

}
