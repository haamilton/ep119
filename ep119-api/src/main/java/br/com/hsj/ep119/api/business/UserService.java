package br.com.hsj.ep119.api.business;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hsj.ep119.api.domain.User;
import br.com.hsj.ep119.api.exception.ApplicationException;
import br.com.hsj.ep119.api.exception.UserNotFoundException;
import br.com.hsj.ep119.api.repository.DataRepository;

/**
 * 
 * Classe que mantém as regras negociais referentes a Usuários
 *
 * @author Hamilton dos Santos Junior
 * @date 11 de mai de 2016
 *
 */
@Service
public class UserService {
	
	@Autowired
	private DataRepository dataRepository;

	/**
	 * Método utilizado para buscar todos os usuários
	 * 
	 * @return Lista de Usuários {@link User}
	 * @throws ApplicationException 
	 */
	public List<User> findAll() throws ApplicationException {
		List<User> users = null;
		try {
			users = dataRepository.findUsers();
			
			if (users == null) {
				users = Collections.emptyList();
			}
		} catch (IOException e) {
			throw new ApplicationException(e);
		} catch (URISyntaxException e) {
			throw new ApplicationException(e);
		}
		
		return users;
	}
	
	/**
	 * Método utilizado para buscar um usuário pelo ID
	 * 
	 * @param _id Identificador do usuário
	 * @return {@link User}
	 * @throws UserNotFoundException 
	 * @throws ApplicationException 
	 */
	public User findById(Integer _id) throws UserNotFoundException, ApplicationException {
		if (_id == null) {
			throw new UserNotFoundException("Id é um campo obrigatório.");
		}
		
		User user = null;
		
		try {
			user = dataRepository.findById(_id);
		} catch (IOException e) {
			throw new ApplicationException(e);
		} catch (URISyntaxException e) {
			throw new ApplicationException(e);
		} 
		
		if (user == null) {
			throw new UserNotFoundException(String.format("Usuário não encontrado com o ID: %s.", _id));
		}
		
		return user;
	}

	/**
	 * Método utilizado para buscar um usuário pelo Email
	 * 
	 * @param _email Email do usuário
	 * @return {@link User}
	 * @throws UserNotFoundException 
	 * @throws ApplicationException 
	 */
	public User findByEmail(String _email) throws UserNotFoundException, ApplicationException {
		if (_email == null || "".equalsIgnoreCase(_email)) {
			throw new UserNotFoundException("Email é um campo obrigatório.");
		}
		
		User user = null;
		
		try {
			user = dataRepository.findByEmail(_email);
		} catch (IOException e) {
			throw new ApplicationException(e);
		} catch (URISyntaxException e) {
			throw new ApplicationException(e);
		} 
		
		if (user == null) {
			throw new UserNotFoundException(String.format("Usuário não encontrado com o Email: %s.", _email));
		}
		
		return user;
	}
	
}
