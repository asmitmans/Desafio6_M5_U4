package cl.fullstackjava.model.dto;

import java.sql.Timestamp;

public class User {
	private int id;
	private String email;
	private String nick;
	private String username;
	private String password;
	private int weight;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public User() {
		super();
	}

	public User(int id, String email, String nick, String username, String password, int weight, Timestamp createdAt,
			Timestamp updatedAt) {
		super();
		this.id = id;
		this.email = email;
		this.nick = nick;
		this.username = username;
		this.password = password;
		this.weight = weight;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
