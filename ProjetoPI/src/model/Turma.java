package model;

public class Turma {
	
	private int id;
	private int semestreLetivo;
	private int anoLetivo;
	private String sigla;
	private Tema tema;

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
	
	public Tema getTema() {
		return tema;
	}
	
	public void setTurma(Tema tema) {
		this.tema = tema;
	}

}
