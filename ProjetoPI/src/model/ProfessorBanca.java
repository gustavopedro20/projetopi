package model;

public class ProfessorBanca {

	private int id;
	private double avaliacao;
	private Banca banca;
	private Professor pf;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public Banca getBanca() {
		return banca;
	}
	
	public void setBanca(Banca banca) {
		this.banca = banca;
	}
	
	public Professor getPf() {
		return pf;
	}
	
	public void setPf(Professor pf) {
		this.pf = pf;
	}

	
}
