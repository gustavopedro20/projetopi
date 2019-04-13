package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Atividade;
import model.Tema;


public class AtividadeDAO {
	
 	public void createAtividade(Atividade atividade) {
		String sqlCreate = "INSERT INTO atividade (tema_id, numero, descricao, formato_entrega, dt_inicio, dt_fim) "
				+ "VALUES (?, ?, ?, ?, ?, ?) ";
		
		Tema tema = new Tema();

		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlCreate)) {
			ps.setInt(1, tema.getId());
			ps.setInt(2, atividade.getNum());
			ps.setString(3, atividade.getDescricao());
			ps.setString(4, atividade.getFormatoEntrega());
			ps.setDate(5, (Date) atividade.getDtInicio());
			ps.setDate(6, (Date) atividade.getDtFim());			
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getStackTrace());

		}
	}
 	
	public void deleteAtividade(Atividade atividade) {
		String sqlDelete = "DELETE FROM atividade WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlDelete);) {
			ps.setInt(1, atividade.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void updateAtividade(Atividade atividade) {
		String sqlUpdate = "UPDATE atividade SET tema_id=?, numero=?, descricao=?, "
				+ "formato_entrega=?, dt_inicio=?, dt_fim=? WHERE id=?";

		Tema tema = new Tema();

		try (Connection conn = ConnectionFactory.conectar(); 
				PreparedStatement ps = conn.prepareStatement(sqlUpdate);) {
			ps.setInt(1, tema.getId());
			ps.setInt(2, atividade.getNum());
			ps.setString(3, atividade.getDescricao());
			ps.setString(4, atividade.getFormatoEntrega());
			ps.setDate(5, (Date) atividade.getDtInicio());
			ps.setDate(6, (Date) atividade.getDtFim());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public Atividade readAtividade(int id) {
		String sqlRead = "SELECT tema_id, numero, descricao, formato_entrega, dt_inicio, dt_fim "
				+ "FROM atividade WHERE id =?";

		Atividade atividade = new Atividade();
		Tema tema = new Tema();

		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlRead);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					tema.setId(rs.getInt("tema_id"));
					atividade.setId(rs.getInt("numero"));
					atividade.setDescricao(rs.getString("descricao"));
					atividade.setFormatoEntrega(rs.getString("formato_entrega"));;
					atividade.setDtInicio(rs.getDate("dt_inicio"));
					atividade.setDtFim(rs.getDate("dt_fim"));
				} else {
					tema.setId(-1);
					atividade.setNum(-1);
					atividade.setDescricao(null);
					atividade.setFormatoEntrega(null);
					atividade.setDtInicio(null);
					atividade.setDtFim(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return atividade;
	}

}
