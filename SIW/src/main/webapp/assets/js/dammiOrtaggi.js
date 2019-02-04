function mostraOrtaggi(terreno_id) {

	$.ajax({
		url : "PrelevaOrtaggi?edit=true&editFormId="+terreno_id,
		dataType : 'json',
		error : function() {
			alert("si è verificato un errore");
		},
		success : function(data) {
			//alert(JSON.stringify(data));
			//var x = JSON.parse(data);
			$('#formModificaOrtaggi> tbody').empty();
			for(i = 0; i < data.length;i++)
				{
					var $row = $('<tr>'+
					      '<th>'+data[i].nome+'</th>'+
					      '<th>'+data[i].resa+'</th>'+	
					      '<th>'+data[i].costo+'</th>'+
					      '<th>'+data[i].tempo+'</th>'+
					      '<button type="button" id=cancellaOrtaggio>'+
					      '</tr>'
					);
					$('#formModificaOrtaggi> tbody:last').append($row);
			}
//			var colHeader = Object.keys(data[0]);
//
//			for(var i=0; i<3; i++){
//				  $('#formModificaOrtaggi> tbody').append('<tr></tr>')
//				  for(var j= 0; j<colHeader.length; j++){
//				    $('#formModificaOrtaggi> tbody tr').append('<td>' + data[i][colHeader[j]] + '</td>');
//				  }
//				}
//			
//			
		}
	});	
}