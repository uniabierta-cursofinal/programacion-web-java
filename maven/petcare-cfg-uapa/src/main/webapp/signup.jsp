<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Pais"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPais"%>

<jsp:include page="template/header.jsp"/>

<%
    List<Pais> paises = ServicioPais.getInstancia().getListadoPais();
%>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form method="post" action="${pageContext.request.contextPath}/ClienteController" role="form" data-toggle="validator">
                <h2>Por favor regístrese <small>Es gratis y siempre lo será.</small></h2>
                <hr class="colorgraph">
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="text" name="inputNombre" id="inputNombre" class="form-control input-lg" placeholder="Nombre" tabindex="1" required>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="text" name="inputApellido" id="inputApellido" class="form-control input-lg" placeholder="Apellido" tabindex="2" required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <input type="text" name="inputUsuario" data-minlength="6" id="inputUsuario" class="form-control" placeholder="Usuario" tabindex="3" data-error="uff, usuario debe contener 6 caracteres mínimo" required>
                    <span class="help-block with-errors">Mínimo de 6 caracteres</span>
                </div>
                <div class="form-group">
                    <input type="tel" name="inputTelefono" id="inputTelefono" class="form-control input-lg" placeholder="Teléfono" tabindex="4">
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="text" name="inputCalle" id="inputCalle" class="form-control input-lg" placeholder="Calle" tabindex="5" required>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="text" name="inputApt" id="inputApt" class="form-control input-lg" placeholder="Apartamento" tabindex="6">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <input type="text" name="inputCiudad" id="inputCiudad" class="form-control input-lg" placeholder="Ciudad" tabindex="7" required>
                </div>
                <div class="form-group">
                    <label for="pais">País:</label>
                    <select class="form-control" id="inputPais" name="inputPais" tabindex="8" required>
                        <c:forEach items="<%=paises%>" var="pais">
                            <option value="${pais.getId()}">${pais.getDescripcion()}</option>        
                        </c:forEach>
                    </select>
                </div>

                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="password" data-minlength="6" name="inputPassword" id="inputPassword" class="form-control" placeholder="Contraseña" tabindex="9" required>
                            <span class="help-block">Mínimo de 6 caracteres</span>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="password" name="password_confirmation" id="password_confirmation" class="form-control" data-match="#inputPassword" data-match-error="uff, contraseña no coinciden" placeholder="Confirmar Contraseña" tabindex="10" required>
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-4 col-sm-3 col-md-3">
                        <span class="button-checkbox">
                            <button type="button" class="btn" data-color="info" tabindex="11">Estoy de acuerdo</button>
                            <input type="checkbox" name="t_and_c" id="t_and_c" class="hidden" value="1">
                        </span>
                    </div>
                    <div class="col-xs-8 col-sm-9 col-md-9">
                        Al hacer clic en <strong class="label label-primary">Registrarse</strong>, admite estar de acuerdo con los <a href="#" data-toggle="modal" data-target="#t_and_c_m"> Términos y Condiciones </a> establecido por este sitio, incluyendo el uso de nuestra Cookies.
                    </div>
                </div>

                <hr class="colorgraph">
                <div class="row">
                    <div class="col-xs-12 col-md-6"><input type="submit" value="Registrarse" class="btn btn-primary btn-block btn-lg" tabindex="12"></div>
                   <div class="col-xs-12 col-md-6"><a href="index.jsp" class="btn btn-success btn-block btn-lg">Cancelar</a></div>
                </div>
            </form>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">Términos y Condiciones</h4>
                </div>
                <div class="modal-body">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Estoy de acuerdo</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <!--</div>-->

    <jsp:include page="template/footer.jsp"/>