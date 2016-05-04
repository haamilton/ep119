package br.com.hsj.ep119.api.business;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hsj.ep119.api.converter.Converter;
import br.com.hsj.ep119.api.domain.User;
import br.com.hsj.ep119.api.domain.UserRepository;

@Service
public class UserService {

	@Autowired
	private Converter converter;
	
	public List<User> find() {
		
		try {
			return createUsers();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	private List<User> createUsers() throws IOException, URISyntaxException {
//		List<User> users = new ArrayList<User>();
//		User user = (User) converter.doUnMarshaling("/user.xml");
//		users.add(user);
		
	
		UserRepository repository = (UserRepository) converter.doUnMarshaling("/user.xml");
		
		return repository.getUsers();
	}


	public void setConverter(Converter converter) {
		this.converter = converter;
	}
	
	
}
