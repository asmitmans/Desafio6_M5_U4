package cl.fullstackjava.model.service;

import java.util.List;

import cl.fullstackjava.model.dao.UserDAO;
import cl.fullstackjava.model.dao.UserDAOImpl;
import cl.fullstackjava.model.dto.User;

public class UserService {
	private UserDAO userDAO = new UserDAOImpl();
	
	public boolean login(String email, String password) {
		return userDAO.validateLogin(email, password);
	}
	
	public User getUserByEmail(String email) {
		return userDAO.read(email);
	}
	
	public Response create(User u) {
		Response response = validateUser(u);
		if (!response.isSuccess()) {
			return response;
		}
		
		if (userDAO.isEmailTaken(u.getEmail())) {
			return new Response(false, "El email ya esta registrado.");
		}
		
        int result = userDAO.create(u);
        
        if (result > 0) {
        	return new Response(true, "Usuario creado correctamente.");
        } else {
        	return new Response(false, "Error al crear el usuario.");
        }
    }

	
	public boolean update(User u) {
		return userDAO.update(u);
	}
	
	public boolean delete(int id) {
		return userDAO.delete(id);
	}
	
	public User read(int id) {
		return userDAO.read(id);
	}
	
	public List<User> read() {
		return userDAO.read();
	}
	
	private Response validateUser(User u) {
		if (u.getEmail() == null || u.getEmail().isEmpty()) {
			return new Response(false, "El correo no puede estar vacío.");
		}
		if (u.getNick() == null || u.getNick().isEmpty()) {
			return new Response(false, "El nick no puede estar vacío.");
		}
		if (u.getUsername() == null || u.getUsername().isEmpty()) {
			return new Response(false, "El nombre no puede estar vacío.");
		}
		if (u.getPassword() == null || u.getPassword().isEmpty()) {
			return new Response(false, "La contraseña no puede estar vacía.");
		}
		if (u.getWeight() <= 0) {
			return new Response(false, "El peso debe ser mayor a 0.");
		}
		return new Response(true, "Validación exitosa.");
	}
	
	
}
