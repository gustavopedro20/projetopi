<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="modal fade" id="entrega-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4>Entrega de Atividade</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span
                        aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input class="form-control" type="text" placeholder="Insira o link da atividade" id="input_entrega" />
            </div>
            <div class="modal-footer">
                <form action="controller.do" method="post">
                    <input type="hidden" name="id" id="id_entrega" />
                    <input type="hidden" name="entrega" id="texto_entrega" />
                    <button  onclick="pegaTextoDaEntrega()" type="submit" id="enviando" class="btn btn-primary" name="command"
                        value="EnviarAtividade">Enviar</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    function pegaTextoDaEntrega(){
        var html = document.getElementById('input_entrega');
        $("#texto_entrega").val(html.value);
    }
</script>