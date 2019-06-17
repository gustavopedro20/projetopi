package br.com.usjt.ProjetoPI.model;

public class Aluno extends Usuario {
	
	private String ra;
	private String turma;
	private Grupo grupo;

	public Aluno() {	
	}
	
	public Aluno(int id, String nome, String email, String senha) {
		super(id, nome, email, senha);
	}

	public String getRa() {
		return ra;
	}
	
	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Aluno [ra=" + ra + ", turma=" + turma + ", grupo=" + grupo + "]";
	}

}
