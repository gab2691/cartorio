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
				console.log(data)
				$('#exampleModalCenter').modal('hide')
			}
	
		})
	})
	
	
	$('.icon-cancel-circle').click(function(){
		var id = $('.ipt-id').val();
		$.ajax({
			
			type: "POST",
			url: "/deletCartorio",
			
			data: JSON.parse(id),
			
			success : function(data) {
				console.log(data)
				$(this).parent().parent().fadeOut();
			}
	
		})
	})
});