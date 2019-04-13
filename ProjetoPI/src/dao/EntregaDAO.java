package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Atividade;
import model.Entrega;
import model.Grupo;

public class EntregaDAO {
	
	public void createEntrega(Entrega entrega) {
		String sqlCreate = "INSERT INTO entrega (grupo_id, atividade_id, dt_cadastro) VALUES (?, ?, ?) ";
		
		Grupo grupo = new Grupo();
		Atividade atividade = new Atividade();
		
		try (Connection conn = ConnectionFactory.conectar(); 
				PreparedStatement ps = conn.prepareStatement(sqlCreate)) {
			ps.setInt(1, grupo.getId());
			ps.setInt(2, atividade.getId());			
			ps.setDate(3, (Date) entrega.getDtCadastro());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getStackTrace());

		}
	}
	
	public void deleteEntrega(Entrega entrega) {
		String sqlDelete = "DELETE FROM entrega WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sqlDelete);) {
			ps.setInt(1, entrega.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void updateEntrega(Entrega entrega) {
		String sqlUpdate = "UPDATE entrega SET grupo_id=?, atividade_id=?, dt_cadastro=? WHERE id=?";
		
		Grupo grupo = new Grupo();
		Atividade atividade = new Atividade();
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sqlUpdate);) {
			ps.setInt(1, grupo.getId());
			ps.setInt(2, atividade.getId());
			ps.setDate(3, (Date) entrega.getDtCadastro());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public Entrega readEntrega(int id) {
		String sqlRead = "SELECT grupo_id, atividade_id, dt_cadastro FROM entrega WHERE id =?";
		
		Entrega entrega = new Entrega();
		Grupo grupo = new Grupo();
		Atividade atividade = new Atividade();
		
		try (Connection conn = ConnectionFactory.conectar(); 
				PreparedStatement ps = conn.prepareStatement(sqlRead);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					grupo.setId(rs.getInt("grupo_id"));
					atividade.setId(rs.getInt("atividade_id"));
					entrega.setDtCadastro(rs.getDate("dt_cadastro"));
				} else {
					entrega.setId(-1);
					grupo.setId(-1);
					atividade.setId(-1);
					entrega.setDtCadastro(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return entrega;
	}

}
