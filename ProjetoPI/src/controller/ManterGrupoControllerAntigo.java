package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grupo;
//import model.Professor;
//import model.Professor;
import service.GrupoService;

@WebServlet("/ManterGrupo2.do")
public class ManterGrupoControllerAntigo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pNome = request.getParameter("nome");
        String pNumero = request.getParameter("numero");
        //String pOrientador = request.getParameter("orientador");
        
        Grupo grupo = new Grupo();
        //Professor professor = new Professor();     

        grupo.setNome(pNome);
        grupo.setNum(Integer.parseInt(pNumero));

        
        //instanciar o service
        GrupoService gs = new GrupoService();
        gs.incluir(grupo);
        grupo = gs.carregar(grupo.getId());
        
        //enviar para o jsp
        request.setAttribute("grupo", grupo);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Grupo.jsp");
        view.forward(request, response);
        
    }
    
}
