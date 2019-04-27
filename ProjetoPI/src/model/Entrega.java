package model;

import java.util.Date;

public class Entrega {
	
	private int id;
	private Date dtCadastro;
	//private ArrayList<Avaliacao> avaliacao = new ArrayList<>();
	private Grupo grupo;
	//private Atividade atividade;
	private int idAtividade;
	
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
	
	/*public ArrayList<Avaliacao> getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(ArrayList<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}*/
	
	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public int getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}




}
