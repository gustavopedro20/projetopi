package br.com.usjt.ProjetoPI.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.usjt.ProjetoPI.model.Grupo;
import br.com.usjt.ProjetoPI.model.Professor;
import br.com.usjt.ProjetoPI.model.Turma;

public class GrupoDAO {

	public int criar(Grupo grupo) {
		String sql = "INSERT INTO grupo (orientador_id, numero, nome, turma_id) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, grupo.getProf().getId());
			ps.setInt(2, grupo.getNum());
			ps.setString(3, grupo.getNome());
			ps.setInt(4, grupo.getTurma().getId());
			ps.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement ps2 = conn.prepareStatement(sqlQuery); ResultSet rs = ps2.executeQuery();) {
				if (rs.next()) {
					grupo.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grupo.getId();
	}

	public void deletarEntregaGrupo(int id) {
		String sql = "DELETE FROM entrega WHERE grupo_id=?";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			System.out.println("Erro em Delete Entrega Grupo: " + e.getMessage());
		}
	}

	public void deletarGrupoTurmaAluno(int id) {
		String sql = "UPDATE turma_aluno SET grupo_id = null WHERE grupo_id=?";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			System.out.println("Erro em Delete Grupo Turma Aluno: " + e.getMessage());
		}
	}

	public void deletar(int id) {
		deletarEntregaGrupo(id);
		deletarGrupoTurmaAluno(id);
		String sql = "DELETE FROM grupo WHERE id=?";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			System.out.println("Erro em Delete Grupo: " + e.getMessage());
		}
	}

	public void atualizar(Grupo grupo) {
		String sql = "UPDATE grupo SET orientador_id=?, numero=?, nome=? WHERE id=?";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, grupo.getProf().getId());
			ps.setInt(2, grupo.getNum());
			ps.setString(3, grupo.getNome());
			ps.setInt(4, grupo.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public Grupo carregar(int id) {
		String sql = "SELECT u.id, u.nome, g.nome, g.numero, g.turma_id FROM usuario AS u INNER JOIN professor AS p ON u.id = p.professor_id "
				+ "INNER JOIN grupo AS g ON p.professor_id = g.orientador_id WHERE g.id=?";
		Turma turma = new Turma();
		Grupo grupo = new Grupo();
		Professor prof = new Professor();
		grupo.setId(id);
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, grupo.getId());
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					prof.setId(rs.getInt("u.id"));
					prof.setNome(rs.getString("u.nome"));
					turma.setId(rs.getInt("g.turma_id"));
					grupo.setTurma(turma);
					grupo.setProf(prof);
					grupo.setNome(rs.getString("g.nome"));
					grupo.setNum(rs.getInt("g.numero"));
				} else {
					grupo.setTurma(null);
					grupo.setProf(null);
					grupo.setNum(-1);
					grupo.setNome(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return grupo;
	}

	public ArrayList<Grupo> listarGrupos() {

		Grupo grupo;
		Professor prof;
		ArrayList<Grupo> lista = new ArrayList<>();
		String sql = "SELECT u.id, u.nome, g.id, g.nome, g.numero FROM usuario AS u INNER JOIN professor AS p ON u.id = p.professor_id "
				+ "INNER JOIN grupo AS g ON p.professor_id = g.orientador_id";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					grupo = new Grupo();
					prof = new Professor();
					prof.setId(rs.getInt("u.id"));
					prof.setNome(rs.getString("u.nome"));
					grupo.setId(rs.getInt("g.id"));
					grupo.setProf(prof);
					grupo.setNome(rs.getString("g.nome"));
					grupo.setNum(rs.getInt("g.numero"));
					lista.add(grupo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Grupo> listarGrupos(String chave) {

		Grupo grupo;
		Professor prof;
		ArrayList<Grupo> lista = new ArrayList<>();
		String sql = "SELECT u.id, u.nome, g.id, g.nome, g.numero FROM usuario AS u INNER JOIN professor AS p ON u.id = p.professor_id "
				+ "INNER JOIN grupo AS g ON p.professor_id = g.orientador_id WHERE UPPER (g.nome) LIKE";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					grupo = new Grupo();
					prof = new Professor();
					prof.setId(rs.getInt("u.id"));
					prof.setNome(rs.getString("u.nome"));
					grupo.setProf(prof);
					grupo.setId(rs.getInt("g.id"));
					grupo.setNome(rs.getString("nome"));
					grupo.setNum(rs.getInt("numero"));
					lista.add(grupo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Grupo> listarGrupos(int turma) {

		Grupo grupo;
		Professor prof;
		ArrayList<Grupo> lista = new ArrayList<>();
		String sql = "SELECT u.id, u.nome, g.id, g.nome, g.numero FROM usuario AS u INNER JOIN professor AS p ON u.id = p.professor_id "
				+ "INNER JOIN grupo AS g ON p.professor_id = g.orientador_id WHERE g.turma_id=?";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, turma);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					grupo = new Grupo();
					prof = new Professor();
					prof.setId(rs.getInt("u.id"));
					prof.setNome(rs.getString("u.nome"));
					grupo.setProf(prof);
					grupo.setId(rs.getInt("g.id"));
					grupo.setNome(rs.getString("g.nome"));
					grupo.setNum(rs.getInt("g.numero"));
					lista.add(grupo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Grupo> listarGruposPorTurma(Turma turma) {

		Grupo grupo;
		Professor prof;
		ArrayList<Grupo> lista = new ArrayList<>();
		String sql = "SELECT u.id, u.nome, g.id, g.nome, g.numero "
				+ "FROM usuario u JOIN professor p ON u.id = p.professor_id "
				+ "JOIN grupo g ON p.professor_id = g.orientador_id " + "JOIN turma t ON g.turma_id = t.id "
				+ "WHERE t.sigla=? AND t.ano_letivo=? AND semestre_letivo=?";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, turma.getSigla());
			ps.setInt(2, turma.getAnoLetivo());
			ps.setInt(3, turma.getSemestreLetivo());
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					grupo = new Grupo();
					prof = new Professor();
					prof.setId(rs.getInt("u.id"));
					prof.setNome(rs.getString("u.nome"));
					grupo.setProf(prof);
					grupo.setId(rs.getInt("g.id"));
					grupo.setNome(rs.getString("g.nome"));
					grupo.setNum(rs.getInt("g.numero"));
					lista.add(grupo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

}
