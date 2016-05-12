package br.com.hsj.ep119.api.repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.hsj.ep119.api.converter.Converter;
import br.com.hsj.ep119.api.domain.User;
import br.com.hsj.ep119.api.domain.UserRepository;

/**
 * 
 * Classe responsável por armazenar os dados da aplicação
 * 
 * @author Hamilton dos Santos Junior
 * @date 11 de mai de 2016
 *
 */
@Repository
public class DataRepository {

	@Autowired
	private Converter converter;
	
	List<User> users = null;
	
	/**
	 * Metodo utilizado para buscar todos os usuarios cadastrados
	 * 
	 * @return Lista de {@link User}
	 * @throws IOException Excecão gerada ao recuperar as informações de usuários do XML
	 * @throws URISyntaxException Excecão gerada ao recuperar as informações de usuários do XML
	 */
	public List<User> findUsers() throws IOException, URISyntaxException {
		loadUsers();
		
		return users;
	}
	
	/**
	 * Métoo utilizado para buscar um {@link User} pelo ID
	 * @param _id Id do usuários consultado
	 * @return {@link User}
	 * @throws IOException Excecão gerada ao recuperar as informações de usuários do XML
	 * @throws URISyntaxException Excecão gerada ao recuperar as informações de usuários do XML
	 * @throws IllegalArgumentException Caso o id do usuário for null
	 */
	public User findById(Integer _id) throws IOException, URISyntaxException {
		if (_id == null) {
			throw new IllegalArgumentException("O Id é um campo obrigatório.");
		}
		
		loadUsers();

		User user = null;
		
		for (User aux : users) {
			if (_id.equals(aux.getId())) {
				user = aux;
			}
		}
		
		return user;
	}
	
	
	/**
	 * Métoo utilizado para buscar um {@link User} pelo email
	 * @param _id Id do usuários consultado
	 * @return {@link User}
	 * @throws IOException Excecão gerada ao recuperar as informações de usuários do XML
	 * @throws URISyntaxException Excecão gerada ao recuperar as informações de usuários do XML
	 * @throws IllegalArgumentException Caso o id do usuário for null
	 */
	public User findByEmail(String _email) throws IOException, URISyntaxException {
		if (_email == null || "".equalsIgnoreCase(_email)) {
			throw new IllegalArgumentException("O Email é um campo obrigatório.");
		}
		
		loadUsers();

		User user = null;
		
		for (User aux : users) {
			if (_email.equals(aux.getEmail())) {
				user = aux;
				break;
			}
		}
		
		return user;
	}

	private void loadUsers() throws IOException, URISyntaxException {
		if (users == null) {
			UserRepository repository = (UserRepository) converter.doUnMarshaling("/user.xml");
			users = repository.getUsers();
		}
	}
	
}
