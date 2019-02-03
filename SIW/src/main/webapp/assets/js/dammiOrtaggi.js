function mostraOrtaggi() {
	$.ajax({
		url : "PrelevaOrtaggi?edit=false&test=test",
		dataType : 'json',
		error : function() {
			alert("si è verificato un errore");
		},
		success : function(data) {
			alert(JSON.stringify(data));
			var $row = $('<tr>'+
				      '<th>'+JSON.stringify(data.ciccio)+'</th>'+
				      '</tr>');    
			$('#formModificaOrtaggi> tbody:last').append($row);
		}
	
		
	});
	
	
}