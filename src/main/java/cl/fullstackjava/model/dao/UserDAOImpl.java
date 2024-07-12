package cl.fullstackjava.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cl.fullstackjava.model.conexion.Conexion;
import cl.fullstackjava.model.dto.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public int create(User u) {
		int rowAffected = 0;
		String sql = "INSERT INTO usuarios (correo, nick, nombre, password, peso) VALUES "
				+ "(?, ?, ?, ?, ?)";
		
		try (Connection con = Conexion.getCon();
			PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setString(1, u.getEmail() );
			ps.setString(2, u.getNick());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getWeight());
			
			rowAffected = ps.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println("ERROR en método create()");
			ex.printStackTrace();
		}
		
		return rowAffected;
	}

	@Override
	public User read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateLogin(String email, String password) {
		User user = read(email);
		return user!=null && user.getPassword().equals(password);
	}

	@Override
	public boolean isEmailTaken(String email) {
		boolean result = false;
		String sql = "SELECT nombre FROM usuarios WHERE correo = ?";
		
		try (Connection c = Conexion.getCon();
			PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, email);
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					result = true;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("ERROR en metodo isEmailTaken()");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public User read(String email) {
		User user  = null;
		String sql = "SELECT id, correo, nick, nombre, password, peso, created_at, updated_at FROM usuarios WHERE correo = ?";
		
		try (Connection c = Conexion.getCon();
			PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, email);
						
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					user = new User();
					user.setId(rs.getInt("id"));
					user.setEmail(rs.getString("correo"));
					user.setNick(rs.getString("nick"));
					user.setUsername(rs.getString("nombre"));
					user.setPassword(rs.getString("password"));
					user.setWeight(rs.getInt("peso"));
					user.setCreatedAt(rs.getTimestamp("created_at"));
					user.setUpdatedAt(rs.getTimestamp("updated_at"));
				}
			}
				
		} catch (SQLException e) {
			System.out.println("ERROR en metodo validateLogin()");
			e.printStackTrace();
		}
		
		return user;
	}
	
		
}
