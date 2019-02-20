//function Cliente(id, citta, provincia, cap, indirizzo, telefono){
//this.id = id;
//this.citta = citta;
//this.provincia = provincia;
//this.cap = cap;
//this.indirizzo = indirizzo;
//this.telefono = telefono;
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



function mostraOrtaggi(idTerreno, periodoColtivazione){

	$.ajax({
		type: "GET",
		url: "DammiPrenotazioniCliente?edit=false&id_terreno="+idTerreno,
		datatype: "json",
		success: function(data){

			var ortaggiPrenotati = JSON.parse(data);
			var periodo = periodoColtivazione;
			var groupRows = document.getElementById("group-of-rows-1"+idTerreno);
			
			
			$(groupRows).empty();
			
			
			var rowIndex = "<tr>"
								+"		<td><strong>Data</strong></td> "
								+"		<td><strong>Ortaggio</strong></td>"
								+"		<td><strong>Quantità</strong></td>"
								+"		<td><strong>Progresso Coltivazione</strong></td>"
								+	"</tr>";
			
			$(groupRows).append(rowIndex);
			
			for(i = 0; i < ortaggiPrenotati.length;i++)
			{		
				
				if(ortaggiPrenotati[i].serra === "si")
					var serra = " (serra)";
				else
					var serra = "";
				
				if(ortaggiPrenotati[i].nome == "Terreno"){
				
					var $row = $("<tr>"+ 
							"<td>"+ortaggiPrenotati[i].date+"</td> " +
							"<td>"+ortaggiPrenotati[i].nome+"</td> " +
							"<td>"+ortaggiPrenotati[i].quantita + serra + "</td> " +
							"<td>"+periodo+"</td>" +
							"</tr>"
						
					);

				}
				else{
					var $row = $("<tr>"+ 
							"<td>"+ortaggiPrenotati[i].date+"</td> " +
							"<td>"+ortaggiPrenotati[i].nome+"</td> " +
							"<td>"+ortaggiPrenotati[i].quantita + serra + "</td> " +
							"<td> <div class='progress'>" +
							"<div class='progress-bar bg-success'style='width:"+ortaggiPrenotati[i].progresso+"%'>"+ortaggiPrenotati[i].progresso+"%</div"+
							+"</div>"+
							"</td> " +
							"</tr>"
						
					);
					
					
					
				}
				
				$(groupRows).append($row);

			}	
	
			$(groupRows).collapse("toggle");
		}

	});

  //"<div class='progress-bar bg-success' role='progressbar' aria-valuenow="+ortaggiPrenotati[i].progresso+"aria-valuemin='0' aria-valuemax='100' style='width:"+ortaggiPrenotati[i].progresso+"%'>"+ortaggiPrenotati[i].progresso+"%</div"+
	
}