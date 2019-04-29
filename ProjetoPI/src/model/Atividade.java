package model;

import java.util.Date;

public class Atividade {
	
	private int id;
	private int num;
	private String descricao;
	private String formatoEntrega;
	private Date dtInicio;
	private Date dtFim;
	//private Tema tema;
	private int idTema;
	
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getFormatoEntrega() {
		return formatoEntrega;
	}
	
	public void setFormatoEntrega(String formatoEntrega) {
		this.formatoEntrega = formatoEntrega;
	}
	
	public Date getDtInicio() {
		return dtInicio;
	}
	
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}
	
	public Date getDtFim() {
		return dtFim;
	}
	
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	


}
