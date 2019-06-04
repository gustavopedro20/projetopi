<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalLabel">Deseja realmente excluir este grupo?</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span
                        aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
               <p>Ao excluir esse grupo, também excluirá suas atividades entregues!</p> 
            </div>
            <div class="modal-footer">
                <form action="controller.do" method="post">
                    <input type="hidden" name="idGrupo" id="id_excluir" />
                    <button type="submit" class="btn btn-primary" name="command" value="ExcluirGrupo">Sim</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                </form>
            </div>
        </div>
    </div>
</div>