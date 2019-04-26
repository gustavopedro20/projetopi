package controller;

import java.sql.Connection;

import dao.ConnectionFactory;
import dao.GrupoDAO;
import model.Grupo;
import model.Professor;

public class TesteMain {

	public static void main(String[] args) {
		try {
			Connection conn = ConnectionFactory.conectar();
			
			GrupoDAO dao = new GrupoDAO(conn);
			Professor prof = new Professor();
			prof.setId(12);
			Grupo grupo = new Grupo(prof, 50, "Grupo Teste");
			dao.criar(grupo);
			System.out.println("Cadastrou!");
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

}
