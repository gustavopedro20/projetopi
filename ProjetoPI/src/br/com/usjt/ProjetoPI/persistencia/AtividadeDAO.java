package br.com.usjt.ProjetoPI.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.com.usjt.ProjetoPI.model.Atividade;

public class AtividadeDAO {

	public void criar(Atividade atividade) {

		String sqlCreate = "INSERT INTO atividade (tema_id, numero, descricao, formato_entrega, dt_inicio, dt_fim) "
				+ "VALUES (?, ?, ?, ?, ?, ?) ";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlCreate)) {
			ps.setInt(1, atividade.getIdTema());
			ps.setInt(2, atividade.getNum());
			ps.setString(3, atividade.getDescricao());
			ps.setString(4, atividade.getFormatoEntrega());
			ps.setString(5, atividade.getDtInicio());
			ps.setString(6, atividade.getDtFim());
			ps.executeUpdate();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement ps2 = conn.prepareStatement(sqlQuery); ResultSet rs = ps2.executeQuery();) {
				if (rs.next()) {
					atividade.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void deletar(int id) {
		String sqlDelete = "DELETE FROM atividade WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlDelete);) {
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	// UPDATE atividade SET formato_entrega=? WHERE id=?;
	public Atividade carregar(int id) {
		String sqlRead = "SELECT tema_id, numero, descricao, formato_entrega, dt_inicio, dt_fim "
				+ "FROM atividade WHERE id =?";

		Atividade atividade = new Atividade();

		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlRead);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					atividade.setIdTema(rs.getInt("tema_id"));
					atividade.setId(rs.getInt("numero"));
					atividade.setDescricao(rs.getString("descricao"));
					atividade.setFormatoEntrega(rs.getString("formato_entrega"));	
					
					SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
					Date dataInicio = rs.getDate("dt_inicio");
					Date dataFim = rs.getDate("dt_fim");
					atividade.setDtInicio(formatDate.format(dataInicio));
					atividade.setDtFim(formatDate.format(dataFim));
				} else {
					atividade.setIdTema(-1);
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

	public ArrayList<Atividade> listarAtividadesPorAluno(int id) {

		Atividade atividade;
		ArrayList<Atividade> lista = new ArrayList<>();
		String sql = "SELECT te.titulo, a.id, te.id, a.descricao, a.formato_entrega, a.numero, a.dt_inicio, a.dt_fim FROM turma_aluno AS ta "
				+ "INNER JOIN turma AS t ON ta.turma_id = t.id INNER JOIN tema AS te ON t.tema_id = te.id "
				+ "INNER JOIN atividade AS a ON te.id = a.tema_id "
				+ "LEFT JOIN entrega AS e ON a.id = e.atividade_id "
				+ "WHERE ta.Aluno_id=? AND e.id IS NULL";

		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					atividade = new Atividade();
					atividade.setId(rs.getInt("a.id"));
					atividade.setIdTema(rs.getInt("te.id"));
					atividade.setNomeTema(rs.getString("te.titulo"));
					atividade.setNum(rs.getInt("a.numero"));
					atividade.setDescricao(rs.getString("a.descricao"));
					atividade.setFormatoEntrega(rs.getString("a.formato_entrega"));
					SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
					Date dataInicio = rs.getDate("dt_inicio");
					Date dataFim = rs.getDate("dt_fim");
					atividade.setDtInicio(formatDate.format(dataInicio));
					atividade.setDtFim(formatDate.format(dataFim));
					lista.add(atividade);
				}
			} catch (SQLException e) {
				System.out.println("Lista atividade erro: " + e.getMessage());
			}
		} catch (SQLException e1) {
			System.out.println("Conexao atividade erro: " + e1.getMessage());
		}
		return lista;
	}

	public ArrayList<Atividade> listarAtividades() {

		Atividade atividade;
		ArrayList<Atividade> lista = new ArrayList<>();
		String sql = "SELECT t.titulo, a.id, a.tema_id, a.numero, a.descricao, a.formato_entrega, a.dt_inicio, a.dt_fim "
				+ "FROM atividade AS a INNER JOIN tema AS t ON a.tema_id = t.id";

		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					atividade = new Atividade();
					atividade.setId(rs.getInt("a.id"));
					atividade.setIdTema(rs.getInt("a.tema_id"));
					atividade.setNomeTema(rs.getString("t.titulo"));
					atividade.setNum(rs.getInt("a.numero"));
					atividade.setDescricao(rs.getString("a.descricao"));
					atividade.setFormatoEntrega(rs.getString("a.formato_entrega"));
					SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
					Date dataInicio = rs.getDate("dt_inicio");
					Date dataFim = rs.getDate("dt_fim");
					atividade.setDtInicio(formatDate.format(dataInicio));
					atividade.setDtFim(formatDate.format(dataFim));
					lista.add(atividade);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println("Lista atividade erro: " + e1.getMessage());
		}
		return lista;
	}

}
