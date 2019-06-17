package br.com.usjt.ProjetoPI.model;

public class TurmaAluno {
	
	private int id;
	private Turma turma;
	private Grupo grupo;
	private Aluno aluno;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@Override
	public String toString() {
		return "TurmaAluno [id=" + id + ", turma=" + turma + ", grupo=" + grupo + ", aluno=" + aluno + "]";
	}

}
