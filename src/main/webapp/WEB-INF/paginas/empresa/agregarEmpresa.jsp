<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="agregarEmpresaModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Empresa</h5> 
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/ServletControladorEmpresa?accion=insertar"
                  method="POST" class="was-validated">
                
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombreEmp">Nombre</label>
                        <input type="text" class="form-control" name="nombreEmp" required>
                    </div>
                    <div class="form-group">
                        <label for="logoEmp">Logo</label>
                        <input type="text" class="form-control" name="logoEmp" required>
                    </div>
                    <div class="form-group">
                        <label for="esloganEmp">Eslogan</label>
                        <input type="text" class="form-control" name="esloganEmp" required>
                    </div>
                    <div class="form-group">
                        <label for="descripcionEmp">Descripcion</label>
                        <input type="text" class="form-control" name="descripcionEmp" required>
                    </div>
                    <div class="form-group">
                        <label for="idusuarioEmp">Dueño</label>
                        <select name="idusuarioEmp" class="form-control" required>
                            <c:forEach var="usuario" items="${usuarios}" varStatus="status" >
                                <option value="${usuario.idUsu}">${usuario.nombreUsu}</option>
                            </c:forEach>
                            
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>    
            </form>
        </div>
    </div>
</div>
