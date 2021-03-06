package br.com.usjt.ProjetoPI.model;

import java.util.ArrayList;

public class Turma {
	
	private int id;
	private int semestreLetivo;
	private int anoLetivo;
	private String sigla;
	private int temaId;
	private String temaTitulo;
	private ArrayList<Grupo> grupos = new ArrayList<Grupo>();

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getSemestreLetivo() {
		return semestreLetivo;
	}
	
	public void setSemestreLetivo(int semestreLetivo) {
		this.semestreLetivo = semestreLetivo;
	}
	
	public int getAnoLetivo() {
		return anoLetivo;
	}
	
	public void setAnoLetivo(int anoLetivo) {
		this.anoLetivo = anoLetivo;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getTemaId() {
		return temaId;
	}

	public void setTemaId(int temaId) {
		this.temaId = temaId;
	}

	public String getTemaTitulo() {
		return temaTitulo;
	}

	public void setTemaTitulo(String temaTitulo) {
		this.temaTitulo = temaTitulo;
	}

	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", semestreLetivo=" + semestreLetivo + ", anoLetivo=" + anoLetivo + ", sigla="
				+ sigla + ", temaId=" + temaId + ", temaTitulo=" + temaTitulo + ", grupos=" + grupos + "]";
	}
	
}
