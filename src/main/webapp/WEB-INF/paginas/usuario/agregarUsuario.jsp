<div class="modal fade" id="agregarUsuarioModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Usuario</h5> 
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/ServletControladorUsuario?accion=insertar"
                  method="POST" class="was-validated">
                
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombreUsu" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="correoUsu" required>
                    </div>
                    <div class="form-group">
                        <label for="passwordUsu">Contraseña</label>
                        <input type="number" class="form-control" name="passwordUsu" required>
                    </div>
                    <div class="form-group">
                        <label for="role">Rol</label>
                        <select name="role" class="form-control" required>
                            <option value="User">User</option>
                            <option value="Admin">Admin</option>
                            <option value="Editor">Editor</option>
                        </select>
                     <!--   <input type="number" class="form-control" name="role" required> -->
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>    
            </form>
        </div>
    </div>
</div>
    