<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Pais"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<t:page>
 <jsp:attribute name="title">Listado de Paises</jsp:attribute>
 <jsp:body>

<display:table name="${paises}" export="true" pagesize="20" sort="list" class="table table-striped table-condensed">
  <display:column property="id" title="#" />
  <display:column property="descripcion" title="Descripcion"/>
  <display:setProperty name="export.excel.filename" value="paises.xls" />
		<display:setProperty name="export.pdf.filename"	value="paises.pdf" />
		<display:setProperty name="export.csv.filename"	value="paises.csv" />
		<display:setProperty name="export.pdf" value="true" />
</display:table>

</jsp:body>
</t:page>

