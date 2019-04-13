package model;

public class Aluno extends Usuario {
	
	private String ra;
	private Turma turma;
	private Grupo grupo;
	
	public Aluno(int id, String nome, String email, String senha) {
		super(id, nome, email, senha);
	}

	public Aluno() {
		
	}

	public String getRa() {
		return ra;
	}
	
	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public Turma getTurma() {
		return turma;
	}
	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
