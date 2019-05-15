$( document ).ready(function() {
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
			}
	
		})
	})
});