$( document ).ready(function() {
	idCartorio = '';
	
	$('.saveCartorio').prop('disabled', true);
	$(".icon-pencil").tooltip();
	$(".icon-cancel-circle").tooltip();
	
	$('.icon-pencil').click(function() {
		$('#modalEdit').modal('show')
	})
	
	$(function () {
		 $('.nameCartorio').keyup(function () {
	            if ($(this).val() == '') {
	            	$('.saveCartorio').prop('disabled', true);
	            } else {
	            	$('.saveCartorio').prop('disabled', false);
	            }
	        });
	    });
	$('.saveCartorio').click(function() {
		var nome = $('.nameCartorio').val();
		
		$.ajax({
			
			type: "POST",
			url: "/saveCartorio",
			contentType : "application/json; charset=utf-8",
			data: JSON.stringify({
				nome : nome
			}),
			
			success : function(data) {
				var dataCriacao = new Date(data.dataCriacao);
				dataCriacao = (dataCriacao.getDate() + '/' + '0' +(dataCriacao.getMonth() + 1) + '/' +  dataCriacao.getFullYear());
				$('.modal-large-box').append(
						'<div class="modal-body display-flex modal-body-smal">'+
							'<div class="col-sm">' +
			      				'<p>'+ data.nome +'</p>' +
		      				 '</div>'+      		
				    		'<div class="col-sm">'+
				      			'<p>'+ dataCriacao +'</p>'+
				    		'</div>'+
				    		'<div class="col-sm box-icons-modal display-flex">'+
				      			'<span class="icon-pencil" data-toggle="tooltip" title="editar  data-toggle="modal" data-target="#ModalCenter"></span>'+
				      			'<span class="icon-cancel-circle" data-toggle="tooltip" title="excluir"></span>'+
				      			'<input type="hidden" class="ipt-id" value="'+ data.id+'"/>'+
				      		'</div>'+
			      		'</div>')
				$('#modalCadastro').modal('hide')
				$('.nameCartorio').val('');
			}
	
		})
	})
	
	$(document).on('click','.icon-cancel-circle', function(){
		var id = $(this).closest('.box-icons-modal').find('.ipt-id').val();
		$(this).parent().parent().fadeOut();
		$.ajax({
			
			type: "POST",
			url: "/deletCartorio",
			contentType : "application/x-www-form-urlencoded",
			data: {
				id: id
			},		
			
			success : function(data,xhr,jqxhr) {				
								
			}
	
		})
	})	
	
	
	
	$(document).on('click','.icon-pencil', function(){
		$('#modalEdit').modal('show');
		var id = $(this).closest('.box-icons-modal').find('.ipt-id').val();
		idCartorio = id;
		
	})	
	
	
	$('.icon-pencil').click(function(){
		var id = $(this).closest('.box-icons-modal').find('.ipt-id').val();
		idCartorio = id;
		
	})
	
	
	$(document).on('click','.save-edit', function(){
		var nome = $(this).parent().parent().find('.nameCartorio').val();
		var id = $(this).closest('.box-icons-modal').find('.ipt-id').val();
		
		
		$.ajax({			
			type: "POST",
			url: "/editCartorio",
			contentType : "application/json; charset=utf-8",
			data: JSON.stringify({
				id: idCartorio,
				nome : nome
			}),
			
			success : function(data,xhr,jqxhr) {	
				$.ajax({			
					type: "GET",
					url: "/listCartorio",
					contentType : "application/json; charset=utf-8",
					success : function(data,xhr,jqxhr) {
						$('#modalEdit').modal('hide');
						$('.bd-example-modal-lg').html(data);
					}					
				})
	
			}
		})	

	})	
});	