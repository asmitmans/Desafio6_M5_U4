package cl.fullstackjava.model.dao;

import java.util.List;

import cl.fullstackjava.model.dto.User;


public interface UserDAO {
	int create(User u);
	User read(int id);
	User read(String email);
	List<User> read();
	boolean update(User u);
	boolean delete(int id);
	boolean validateLogin(String email, String password);	
	boolean isEmailTaken(String email);
}
