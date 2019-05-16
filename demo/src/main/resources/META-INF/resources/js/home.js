$( document ).ready(function() {
	$('.saveCartorio').prop('disabled', true);
	$(".icon-pencil").tooltip();
	$(".icon-cancel-circle").tooltip();
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
				$('.modal-content').append(
						'<div class="modal-body display-flex modal-body-smal">'+
							'<div class="col-sm">' +
			      				'<p>'+ data.nome +'</p>' +
		      				 '</div>'+      		
				    		'<div class="col-sm">'+
				      			'<p>'+ dataCriacao +'</p>'+
				    		'</div>'+
				    		'<div class="col-sm box-icons-modal display-flex">'+
				      			'<span class="icon-pencil" data-toggle="tooltip" title="editar"></span>'+
				      			'<span class="icon-cancel-circle" data-toggle="tooltip" title="excluir"></span>'+
				      			'<input type="hidden" class="ipt-id" value="${cartorios.id}"/>'+
				      		'</div>'+
			      		'</div>')
				$('#exampleModalCenter').modal('hide')
			}
	
		})
	})
	
	
	$('.icon-cancel-circle').click(function(){
		console.log('esta chegando aqui?');
		var id = $('.ipt-id').val();
		$.ajax({
			
			type: "POST",
			url: "/deletCartorio",
			contentType : "application/x-www-form-urlencoded",
			data: {
				id: id
			},		
			
			success : function(data) {
				console.log(data)
				$(this).parent().parent().fadeOut();
			}
	
		})
	})
});