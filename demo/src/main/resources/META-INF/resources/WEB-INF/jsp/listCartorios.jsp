<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

  <div class="modal-dialog modal-lg">
    <div class="modal-content modal-large-box">

      <div class="modal-header">
        <h4 class="modal-title" id="myLargeModalLabel">Cartórios</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">×</span>
        </button>
      </div>
      
        <c:forEach var="cartorios" items="${cartorios}">
      		<div class="modal-body display-flex modal-body-smal">
	      		<div class="col-sm">
	      			<p>${cartorios.nome}</p>
	    		</div>      		
	    		<div class="col-sm">
	      			<p><fmt:formatDate pattern="dd/MM/yyyy"  value="${cartorios.dataCriacao}"/></p>
	    		</div>
	    		<div class="col-sm box-icons-modal display-flex">
	      			<span class="icon-pencil" data-toggle="tooltip" title="editar" data-toggle="modal" data-target="#modalEdit"></span>
	      			<span class="icon-cancel-circle" data-toggle="tooltip" title="excluir"></span>
	      			<input type="hidden" class="ipt-id" value="${cartorios.id}"/>
	      		</div>	
      		</div>  	
        </c:forEach>      
    </div>
  </div>