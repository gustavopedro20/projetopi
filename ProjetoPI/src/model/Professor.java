package model;

import java.util.ArrayList;

public class Professor extends Usuario {
	
	private int adm;
	private String matricula;
	private ArrayList<Grupo> grupo = new ArrayList<>();
	private ArrayList<ProfessorBanca> pb = new ArrayList<>();
	
	public Professor(int id, String nome, String email, String senha) {
		super(id, nome, email, senha);
	}
	public Professor() {
		
	}
	
	public int getAdm() {
		return adm;
	}
	public void setAdm(int adm) {
		this.adm = adm;
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public ArrayList<Grupo> getGrupo() {
		return grupo;
	}
	public void setGrupo(ArrayList<Grupo> grupo) {
		this.grupo = grupo;
	}
	public ArrayList<ProfessorBanca> getPb() {
		return pb;
	}
	public void setPb(ArrayList<ProfessorBanca> pb) {
		this.pb = pb;
	}

}
