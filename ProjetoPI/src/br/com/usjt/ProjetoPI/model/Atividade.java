package br.com.usjt.ProjetoPI.model;

public class Atividade {
	
	private int id;
	private int num;
	private String descricao;
	private String formatoEntrega;
	private String dtInicio;
	private String dtFim;
	//ATRIBUTOS CRIADOS PARA SIMULAR A ENTIDADE TEMA, QUE NÃO É DO NOSSO INTERESSE
	private int idTema;
	private String nomeTema;
	
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

	public String getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getDtFim() {
		return dtFim;
	}

	public void setDtFim(String dtFim) {
		this.dtFim = dtFim;
	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}

	public String getNomeTema() {
		return nomeTema;
	}

	public void setNomeTema(String nomeTema) {
		this.nomeTema = nomeTema;
	}

	@Override
	public String toString() {
		return "Atividade [id=" + id + ", num=" + num + ", descricao=" + descricao + ", formatoEntrega="
				+ formatoEntrega + ", dtInicio=" + dtInicio + ", dtFim=" + dtFim + ", idTema=" + idTema + ", nomeTema="
				+ nomeTema + "]";
	}

}
