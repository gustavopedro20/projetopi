package model;

import java.util.ArrayList;
import java.util.Date;

public class Tema {
	
	private int id;
	private Date dtCadastro;
	private String titulo;
	private String intoducao;
	private String requisitos;
	private ArrayList<Turma> turma = new ArrayList<>();
	private ArrayList<Atividade> atividade = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDtCadastro() {
		return dtCadastro;
	}
	
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getIntoducao() {
		return intoducao;
	}
	
	public void setIntoducao(String intoducao) {
		this.intoducao = intoducao;
	}
	
	public String getRequisitos() {
		return requisitos;
	}
	
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	
	public ArrayList<Turma> getTurma() {
		return turma;
	}
	
	public void setTurma(ArrayList<Turma> turma) {
		this.turma = turma;
	}
	
	public ArrayList<Atividade> getAtividade() {
		return atividade;
	}
	
	public void setAtividade(ArrayList<Atividade> atividade) {
		this.atividade = atividade;
	}

}
