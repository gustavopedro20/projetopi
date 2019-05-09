package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Aluno;

public class AlunoDAO {

	public Aluno carregar(int id) {
		String sqlRead = "SELECT  u.id, u.nome, u.email, u.senha, a.ra FROM usuario AS u "
				+ "INNER JOIN aluno AS a ON u.id = a.aluno_id WHERE u.id=?";
		Aluno aluno = new Aluno();
		try (Connection conn = ConnectionFactory.conectar(); 
				PreparedStatement stm = conn.prepareStatement(sqlRead);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					aluno.setId(rs.getInt("u.id"));
					aluno.setNome(rs.getString("u.nome"));
					aluno.setEmail(rs.getString("u.email"));
					aluno.setSenha(rs.getString("u.senha"));
					aluno.setRa(rs.getString("a.ra"));
				} else {
					aluno.setId(-1);
					aluno.setNome(null);
					aluno.setEmail(null);
					aluno.setSenha(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return aluno;
	}
	
	//BUSCAR ALUNO POR SIGLA DA TURMA
	public ArrayList<Aluno> listarAlunosPorTurma(String sigla) {
		String sql="SELECT u.id, u.nome, u.email, a.ra FROM usuario AS u INNER JOIN aluno AS a ON u.id = a.aluno_id "
				+ "INNER JOIN turma_aluno as ta ON a.aluno_id = ta.Aluno_id INNER JOIN turma AS t ON ta.turma_id = t.id "
				+ "WHERE t.sigla=?";
		
		Aluno aluno;
		ArrayList<Aluno> lista = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, sigla);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					aluno = new Aluno();
					aluno.setId(rs.getInt("u.id"));
					aluno.setNome(rs.getString("u.nome"));
					aluno.setEmail(rs.getString("u.email"));
					aluno.setRa(rs.getString("a.ra"));
					lista.add(aluno);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	//BUSCAR ALUNO POR ID DO GRUPO
	public ArrayList<Aluno> listarAlunosPorGrupo(int id) {
		String sql="SELECT u.id, u.nome, u.email, a.ra FROM usuario AS u INNER JOIN aluno AS a ON u.id = a.aluno_id "
				+ "INNER JOIN turma_aluno as ta ON a.aluno_id = ta.Aluno_id INNER JOIN turma AS t ON ta.turma_id = t.id "
				+ "WHERE ta.grupo_id=?";
		
		Aluno aluno;
		ArrayList<Aluno> lista = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					aluno = new Aluno();
					aluno.setId(rs.getInt("u.id"));
					aluno.setNome(rs.getString("u.nome"));
					aluno.setEmail(rs.getString("u.email"));
					aluno.setRa(rs.getString("a.ra"));
					lista.add(aluno);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	//SETAR NULL ID GRUPO NO TURMA ALUNO 
	public void deletarAlunoGrupo(int idGrupo, int idAluno ) {
		String sql = "UPDATE turma_aluno SET grupo_id = null WHERE grupo_id=? AND Aluno_id=?;";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, idGrupo);
			ps.setInt(2, idAluno);
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public Aluno autenticarAluno(Aluno aluno) {
		String sql = "SELECT  u.id, u.nome, u.email, u.senha, a.ra FROM usuario AS u "
				+ "INNER JOIN aluno AS a ON u.id = a.aluno_id WHERE u.email=?";

		try (Connection conn = ConnectionFactory.conectar(); 
				PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setString(1, aluno.getEmail());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					aluno.setId(rs.getInt("u.id"));
					aluno.setNome(rs.getString("u.nome"));
					aluno.setEmail(rs.getString("u.email"));
					aluno.setSenha(rs.getString("u.senha"));
					aluno.setRa(rs.getString("a.ra"));
				} else {
					aluno.setId(-1);
					aluno.setNome(null);
					aluno.setEmail(null);
					aluno.setSenha(null);
					aluno.setRa(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return aluno;
	}
	
	public ArrayList<Aluno> listarAlunosPorTurma2() {
		String sql="SELECT u.id, u.nome, u.email, a.ra FROM usuario AS u INNER JOIN aluno AS a ON u.id = a.aluno_id "
				+ "INNER JOIN turma_aluno as ta ON a.aluno_id = ta.Aluno_id INNER JOIN turma AS t ON ta.turma_id = t.id";
		
		Aluno aluno;
		ArrayList<Aluno> lista = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			//ps.setString(1, sigla);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					aluno = new Aluno();
					aluno.setId(rs.getInt("u.id"));
					aluno.setNome(rs.getString("u.nome"));
					aluno.setEmail(rs.getString("u.email"));
					aluno.setRa(rs.getString("a.ra"));
					lista.add(aluno);
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
