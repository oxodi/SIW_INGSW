/**
 * 
 */


function mostraOrtaggi() {
	
	var code ={
			
			nome: "ciccio",
			cognome: "pippo"
	};
	
	$.ajax({
		type: "POST",
		url: "PrelevaOrtaggi?edit=false&test=test",
		datatype: "json",
		data: JSON.stringify(code),
		success: function (data){
			var p = JSON.parse(data);
			alert(data);
			
		},
		error: function(e){
			   alert('Error: ' + e);
			 }
	});	
}
		