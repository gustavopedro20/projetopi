package br.com.usjt.ProjetoPI.model;

import java.util.Date;

public class Entrega {
	
	private int id;
	private Date dtCadastro;
	private String linkAtividade;
	private Grupo grupo;
	private Atividade atividade;
	
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
	
	public String getLinkAtividade() {
		return linkAtividade;
	}
	
	public void setLinkAtividade(String linkAtividade) {
		this.linkAtividade = linkAtividade;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public Atividade getAtividade() {
		return atividade;
	}
	
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	@Override
	public String toString() {
		return "Entrega [id=" + id + ", dtCadastro=" + dtCadastro + ", linkAtividade=" + linkAtividade + ", grupo="
				+ grupo + ", atividade=" + atividade + "]";
	}
	
}
