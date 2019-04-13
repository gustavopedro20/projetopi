package model;

import java.util.ArrayList;
import java.util.Date;

public class Banca {
	
	private int id;
	private Grupo grupo;
	private Date data;
	private String sala;
	private ArrayList<ProfessorBanca> pb = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getSala() {
		return sala;
	}
	
	public void setSala(String sala) {
		this.sala = sala;
	}
	
	public ArrayList<ProfessorBanca> getPb() {
		return pb;
	}
	
	public void setPb(ArrayList<ProfessorBanca> pb) {
		this.pb = pb;
	}
	
}
