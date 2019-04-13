package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {

	public Usuario /*ou void?*/ createUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuario (id, nome, email, senha) "
				+ "VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.conectar(); 
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, usuario.getId());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getSenha());
			ps.execute();
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());

		}
		return usuario;
	}

	public void deleteUsuario(Usuario usuario) {
		String sqlDelete = "DELETE FROM usuario WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sqlDelete);) {
			ps.setInt(1, usuario.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void updateUsuario(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET nome=?, email=?, senha=? WHERE id=?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sqlUpdate);) {
			ps.setString(1, usuario.getNome());
			ps.setNString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, usuario.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public Usuario readUsuario(int id, Usuario usuario) {
		String sqlSelect = "SELECT nome, email, senha FROM usuario WHERE id =?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sqlSelect);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setSenha(rs.getString("senha"));
				} else {
					usuario.setId(-1);
					usuario.setNome(null);
					usuario.setEmail(null);
					usuario.setSenha(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}
	
}
