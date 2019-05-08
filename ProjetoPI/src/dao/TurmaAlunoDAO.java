package dao;

public class TurmaAlunoDAO {
	
	/*public void criar(Grupo grupo, Aluno aluno, Turma turma) {
		String sqlInsert = "INSERT INTO turma_aluno (aluno_id, turma_id, grupo_id) VALUES (?, ?, ?)";

		try (Connection conn = ConnectionFactory.conectar(); 
				PreparedStatement ps = conn.prepareStatement(sqlInsert)) {
			ps.setInt(1, aluno.getId());
			ps.setInt(2, turma.getId());
			ps.setInt(3, grupo.getId());
			ps.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); 
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					grupo.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(TurmaAluno turmaAluno) {
		String sqlDelete = "DELETE FROM grupo WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, turmaAluno.getId());
			stm.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}*/

}
