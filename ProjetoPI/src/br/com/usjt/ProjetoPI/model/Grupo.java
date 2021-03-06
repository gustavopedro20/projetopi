package br.com.usjt.ProjetoPI.model;

import java.util.ArrayList;

public class Grupo {
	
	private int id;
	private int num;
	private String nome;
	private Professor prof;
	private Turma turma;
	private ArrayList<Aluno> aluno;	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Professor getProf() {
		return prof;
	}
	
	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public ArrayList<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(ArrayList<Aluno> aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", num=" + num + ", nome=" + nome + ", prof=" + prof + ", turma=" + turma
				+ ", aluno=" + aluno + "]";
	}	

}
