<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/main.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="js/home.js"></script>
<link href="webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
<script src="webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="main-box display-flex">
		<div class="box-options display-flex-column">
			<span class="icon-add"  data-toggle="modal" data-target="#exampleModalCenter"></span>
			<p class="text-box">Cadastrar Cart�rio</p>
		</div>
<!-- 		<div class="box-options display-flex-column"> -->
<%-- 			<span class="icon-pencil"></span> --%>
<!-- 			<p class="text-box">Editar Cartorio</p> -->
<!-- 		</div> -->
		<div class="box-options display-flex-column">
			<span class="icon-file-text2"></span>
			<p class="text-box">Listar Cart�rio</p>
		</div>
		
<!-- 		<div class="box-options display-flex-column"> -->
<%-- 			<span class="icon-cancel-circle"></span> --%>
<!-- 			<p class="text-box">Excluir Cartorio</p> -->
<!-- 		</div> -->
	</div>


<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Cadastre seu Cart�rio</h5>
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="input-group mb-3">
		  <div class="input-group-prepend">
		    <button class="btn btn-outline-secondary" type="button">Nome</button>
		  </div>
		  <input type="text" class="form-control nameCartorio" placeholder="Nome do Cart�rio" aria-label="" aria-describedby="basic-addon1">
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary saveCartorio">Save changes</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>