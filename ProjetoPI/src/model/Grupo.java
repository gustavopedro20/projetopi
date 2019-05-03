package model;

import java.util.ArrayList;

public class Grupo {
	
	private int id;
	private int num;
	private String nome;
	private Professor prof;
	private ArrayList<Aluno> aluno;	
	
	public Grupo(Professor prof, int num, String nome) {
		this.num = num;
		this.nome = nome;
		this.prof = prof;
	}
	
	public Grupo () {
		
	}
	
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

	public ArrayList<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(ArrayList<Aluno> aluno) {
		this.aluno = aluno;
	}
	

}
