package br.com.hsj.ep119.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hsj.ep119.api.business.UserService;
import br.com.hsj.ep119.api.domain.User;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;  
	
	
	
	/**
	 * Método utilizado para retornar todos os usuários cadastrados
	 * @return
	 */
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAll();
		
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
