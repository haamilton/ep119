package br.com.hsj.ep119.api.business;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hsj.ep119.api.domain.User;
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
	 */
	public List<User> findAll() {
		List<User> users = null;
		try {
			users = dataRepository.getUsers();
			
			if (users == null) {
				users = Collections.emptyList();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	/**
	 * Método utilizado para buscar um usuário pelo ID
	 * 
	 * @param _id Identificador do usuário
	 * @return {@link User}
	 */
	public User findById(Integer _id) {
		if (_id == null) {
			return null;
		}
		
		User user = null;
		
		try {
			user = dataRepository.getUser(_id);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} 
		
		return user;
	}
	
}
