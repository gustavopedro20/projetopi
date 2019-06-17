package br.com.usjt.ProjetoPI.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.usjt.ProjetoPI.model.Entrega;

public class EntregaDAO {
	
	public int criar(Entrega entrega) {
		String sql = "INSERT INTO entrega (grupo_id, atividade_id, link_atividade) VALUES (?, ?, ?)";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, entrega.getGrupo().getId());
			ps.setInt(2, entrega.getAtividade().getId());
			ps.setString(3, entrega.getLinkAtividade());
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
		return entrega.getId();
	}

}


