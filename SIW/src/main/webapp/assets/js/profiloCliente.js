//function Cliente(id, citta, provincia, cap, indirizzo, telefono){
//	this.id = id;
//	this.citta = citta;
//	this.provincia = provincia;
//	this.cap = cap;
//	this.indirizzo = indirizzo;
//	this.telefono = telefono;
//}
	

function aggiornaDati(idCliente){
	
	var cliente = {
			id : idCliente,
			citta : $('#citta').val(),
			provincia : $('#provincia').val(),
			cap : $('#cap').val(),
			indirizzo : $('#indirizzo').val(),
			telefono : $('#telefono').val()
	};
	 
		
	$.ajax({
		type: "POST",
		url: "aggiornaDatiCliente",
		datatype: "json",
		data: JSON.stringify(cliente),
		success: function(data){
			var clienteRicevuto = JSON.parse(data);
			
			$("#provincia").text(clienteRicevuto.provincia);
			$("#cap").text(clienteRicevuto.cap);
			$("#citta").text(clienteRicevuto.citta);
			$("#indirizzo").text(clienteRicevuto.indirizzo);
			$("#telefono").text(clienteRicevuto.telefono);
			
			$("#tel").html("<strong>Telefono</strong> "+ clienteRicevuto.telefono);
			$("#cit").html("<strong>Città</strong> "+ clienteRicevuto.citta +"("+clienteRicevuto.provincia+")");
			$("#indi").html("<strong>Indirizzo</strong> "+ clienteRicevuto.indirizzo +" ("+ clienteRicevuto.cap+")");
			
			$('#modalSuccess').modal('show');	
			}
		
	});
	
}



function mostraOrtaggi(idTerreno){

	$.ajax({
		type: "GET",
		url: "DammiPrenotazioniCliente?edit=false&id_terreno="+idTerreno,
		datatype: "json",
		//data: JSON.stringify(terreno),
		success: function(data){
			alert("SONO IN MOSTRA ORTAGGI"+ data);
			for(i = 0; i < data.length;i++){
				alert('data[i].nome');
				
				$('#group-of-rows-1').html("<tr>"+ 
											"<td>"+data[i].date+"</td> " +
											"<td>"+data[i].nome+"</td> " +
											"<td>"+data[i].tempoColtivazione+"</td> " +
											"<td>"+data[i].quantita+"</td> " +
											"<td>"+data[i].serra+"</td> " +
										"</tr");
				
				
			}

		}
		
	});
	
	
}