package model;

import java.util.Date;

public class Avaliacao {
	
	private int id;
	private double nota;
	private Date dtAvaliacao;
	private String comentarios;
	private Entrega entrega;
	private Aluno aluno;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getNota() {
		return nota;
	}
	
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public Date getDtAvaliacao() {
		return dtAvaliacao;
	}
	
	public void setDtAvaliacao(Date dtAvaliacao) {
		this.dtAvaliacao = dtAvaliacao;
	}
	
	public String getComentarios() {
		return comentarios;
	}
	
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	public Entrega getEntrega() {
		return entrega;
	}
	
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
