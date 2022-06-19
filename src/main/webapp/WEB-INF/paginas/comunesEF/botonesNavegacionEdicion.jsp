<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="ServletControladorEF" class="btn btn-ligth btn-block">
                    <i class="fas fa-arrow-left"></i> Regresar
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Guardar Entidad Federativa
                </button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletControladorEF?accion=eliminar&idEnt=${ef.idEnt}"
                   class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i> Eliminar Entidad Federativa
                </a>
            </div>
        </div>
    </div>
</section>