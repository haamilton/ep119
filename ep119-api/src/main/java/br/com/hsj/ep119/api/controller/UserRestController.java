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
import br.com.hsj.ep119.api.exception.ApplicationException;
import br.com.hsj.ep119.api.exception.UserNotFoundException;

/**
 * 
 * Interface de acesso aos métodos implementados para Usuários
 *
 * @author Hamilton dos Santos Junior
 * @date 12 de mai de 2016
 *
 */
@RestController
public class UserRestController extends AbstractRestController {

	@Autowired
	private UserService userService;  
	
	
	
	/**
	 * Método utilizado para retornar todos os usuários cadastrados
	 * @return Lista de usuários {@link User}
	 * @throws ApplicationException 
	 */
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() throws ApplicationException {
		List<User> users = userService.findAll();
		
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> findById(@PathVariable("id") int id) throws UserNotFoundException, ApplicationException {
        User user = userService.findById(id);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/user/email/{email}", method = RequestMethod.GET)
    public ResponseEntity<User> findByEmail(@PathVariable("email") String _email) throws UserNotFoundException, ApplicationException {
        User user = userService.findByEmail(_email);

        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
