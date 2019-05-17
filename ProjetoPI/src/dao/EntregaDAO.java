package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Entrega;

public class EntregaDAO {
	
	public Entrega criar(Entrega entrega) {
		String sql = "INSERT INTO entrega (grupo_id, atividade_id, link_atividade) VALUES (?, ?, ?)";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, entrega.getGrupo().getId());
			ps.setInt(2, entrega.getAtividade().getId());
			ps.setString(4, entrega.getLinkAtividade());
			ps.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement ps2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = ps2.executeQuery();) {
				if (rs.next()) {
					entrega.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entrega;
	}
//	
//	public void deletar(int id) {
//		String sqlDelete = "DELETE FROM entrega WHERE id = ?";
//		try (Connection conn = ConnectionFactory.conectar();
//				PreparedStatement ps = conn.prepareStatement(sqlDelete);) {
//			ps.setInt(1, id);
//			ps.execute();
//		} catch (Exception e) {
//			System.out.println(e.getStackTrace());
//		}
//	}
//	
//	public void atualizar(Entrega entrega) {
//		String sqlUpdate = "UPDATE entrega SET grupo_id=?, atividade_id=?, dt_cadastro=? WHERE id=?";		
//		try (Connection conn = ConnectionFactory.conectar();
//				PreparedStatement ps = conn.prepareStatement(sqlUpdate);) {
//			ps.setInt(1, entrega.getGrupo().getId());
//			ps.setInt(2, entrega.getAtividade().getId());
//			ps.setDate(3, (Date) entrega.getDtCadastro());
//			ps.setInt(4, entrega.getId());
//			ps.execute();
//		} catch (Exception e) {
//			System.out.println(e.getStackTrace());
//		}
//	}
//	
//	public Entrega carregar(int id) {
//		String sqlRead = "SELECT grupo_id, atividade_id, dt_cadastro FROM entrega WHERE id =?";
//		Entrega entrega = new Entrega();
//		
//		try (Connection conn = ConnectionFactory.conectar(); 
//				PreparedStatement ps = conn.prepareStatement(sqlRead);) {
//			ps.setInt(1, id);
//			try (ResultSet rs = ps.executeQuery();) {
//				if (rs.next()) {
//					entrega.getGrupo().setId(rs.getInt("grupo_id"));
//					entrega.getAtividade().setId(rs.getInt("atividade_id"));
//					entrega.setDtCadastro(rs.getDate("dt_cadastro"));
//				} else {
//					entrega.getGrupo().setId(-1);
//					entrega.getAtividade().setId(-1);
//					entrega.setDtCadastro(null);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e1) {
//			System.out.print(e1.getStackTrace());
//		}
//		return entrega;
//	}

}
