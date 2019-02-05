function aggiornaResocontoTerreno(nome, quantita, resa, prezzo, id, dimTotale, dimSerra, idInput){
	var checkbox = document.getElementById(id);
	var	body = document.getElementById('body');
	var riga; 

	var ortaggio = document.getElementById(nome);
	var dimInserita = calcolaDimTerreno(quantita, "no");  //"&#x2718"

	var dimTerreno = dimTotale - dimSerra;


	if (checkbox.checked){
	
		if(dimInserita > dimTerreno){
			$('#modalError').modal('show');	
			document.getElementById(idInput).value = '';
		}
		else{

			if( ortaggio === null){

				riga = body.insertRow(0);

				var cellaNome = riga.insertCell(0);
				var cellaQuantita = riga.insertCell(1);
				var cellaResa = riga.insertCell(2);
				var cellaPrezzo = riga.insertCell(3);
				var cellaSerra = riga.insertCell(4);
				var cellaElimina = riga.insertCell(5);

				cellaNome.innerHTML = nome;
				cellaQuantita.innerHTML = quantita + "  m<sup>2</sup>";
				cellaPrezzo.innerHTML = (prezzo * quantita).toFixed(2) + "  €";
				
				
				if(id == "soloTerreno"){
					cellaSerra.innerHTML = "-";
					cellaResa.innerHTML = resa;
					
				}
				else{
					cellaSerra.innerHTML = "no"; 
					cellaResa.innerHTML = (resa * quantita).toFixed(2) +"  kg";
					
				}
				cellaElimina.innerHTML = "<button class='btn btn-sm btn-danger' onclick='btnCancella(this, id)'><i class='fa fa-trash'></i> </button>";

				riga.setAttribute("id", nome);
				
				alert("Ortaggio inserito!")
			}else{	

				for(var i = 0; i<((body.rows.length)-3); i++){

					var str = body.rows[i].cells.item(4).innerHTML;
				}

				if(str != "no"){
					$('#modalErrorOrt').modal('show');
					document.getElementById(idInput).value = '';
				}
				//rimuoviamo la riga già presente per poi riinserirla con le dovute modifiche
				else{
					$('#' + nome).remove();


					riga = body.insertRow(0);

					var cellaNome = riga.insertCell(0);
					var cellaQuantita = riga.insertCell(1);
					var cellaResa = riga.insertCell(2);
					var cellaPrezzo = riga.insertCell(3);
					var cellaSerra = riga.insertCell(4);
					var cellaElimina = riga.insertCell(5);

					cellaNome.innerHTML = nome;
					cellaQuantita.innerHTML = quantita + "  m<sup>2</sup>";	
					cellaPrezzo.innerHTML = (prezzo * quantita).toFixed(2);
					
					if(id == "soloTerreno"){
						cellaSerra.innerHTML = "-";
						cellaResa.innerHTML = resa;
						
					}
					else{
						cellaSerra.innerHTML = "no"; 
						cellaResa.innerHTML = (resa * quantita).toFixed(2) +"  kg";
						
					}
					
					cellaElimina.innerHTML = "<button class='btn btn-sm btn-danger' onclick='btnCancella(this, id)'><i class='fa fa-trash'></i> </button>";

					riga.setAttribute("id", nome);
					
					alert("Quantità modificata!")
				}
			}
		}
	}

	calcolaImporti();

}






function aggiornaResocontoSerra(nome, quantita, resa, prezzo, id, dimSerra, idInput){
	var checkbox = document.getElementById(id);
	var	body = document.getElementById('body');
	var riga; 

	var ortaggio = document.getElementById(nome);
	var dimInserita = calcolaDimSerra(quantita, "si"); //&#x2714

	if (checkbox.checked){
		if(dimInserita > dimSerra){
			$('#modalError').modal('show');
			document.getElementById(idInput).value = '';
		}
		else{	

			if( ortaggio === null){

				riga = body.insertRow(0);

				var cellaNome = riga.insertCell(0);
				var cellaQuantita = riga.insertCell(1);
				var cellaResa = riga.insertCell(2);
				var cellaPrezzo = riga.insertCell(3);
				var cellaSerra = riga.insertCell(4);
				var cellaElimina = riga.insertCell(5);

				cellaNome.innerHTML = nome;
				cellaQuantita.innerHTML = quantita + "  m<sup>2</sup>";
				cellaResa.innerHTML = (resa * quantita).toFixed(2) +"  kg";
				cellaPrezzo.innerHTML = (prezzo * quantita).toFixed(2) + "  €";
				cellaSerra.innerHTML = "si";
				cellaElimina.innerHTML = "<button class='btn btn-sm btn-danger' onclick='btnCancella(this, id)'><i class='fa fa-trash'></i> </button>";

				riga.setAttribute("id", nome);
				
				alert("Ortaggio inserito!");
			}else{	

				for(var i = 0; i<((body.rows.length)-3); i++){

					var str = body.rows[i].cells.item(4).innerHTML;
				}

				if(str != "si"){
					$('#modalErrorOrt').modal('show');
					document.getElementById(idInput).value = '';
				}
				else{
					//rimuoviamo la riga già presente per poi riinserirla con le dovute modifiche				
					$('#' + nome).remove();

					riga = body.insertRow(0);

					var cellaNome = riga.insertCell(0);
					var cellaQuantita = riga.insertCell(1);
					var cellaResa = riga.insertCell(2);
					var cellaPrezzo = riga.insertCell(3);
					var cellaSerra = riga.insertCell(4);
					var cellaElimina = riga.insertCell(5);

					cellaNome.innerHTML = nome;
					cellaQuantita.innerHTML = quantita + "  m<sup>2</sup>";
					cellaResa.innerHTML = (resa * quantita).toFixed(2) +"  kg";
					cellaPrezzo.innerHTML = (prezzo * quantita).toFixed(2);
					cellaSerra.innerHTML = "si";
					cellaElimina.innerHTML = "<button class='btn btn-sm btn-danger' onclick='btnCancella(this, id)'><i class='fa fa-trash'></i> </button>";

					riga.setAttribute("id", nome);	
					
					alert("Quantità modificata!");
				}
			}
		}
	}

	calcolaImporti();

}



function cancellaRiga(ortaggio, id){

	var checkbox = document.getElementById(id);
	if(!checkbox.checked){
		$('#' + ortaggio).remove();
	}
	calcolaImporti();
}


//DELETE BUTTON
function btnCancella(row, id){

	var riga = row.parentNode.parentNode;
	riga.parentNode.removeChild(riga);

	calcolaImporti();
}





function calcolaDimTerreno(quantita, serra){
	var somma = 0;

	for(var i = 0; i<((body.rows.length)-3); i++){

		var str = body.rows[i].cells.item(1).innerHTML;
		var subString = str.substring(0, str.length - 4);

		if(body.rows[i].cells.item(4).innerHTML === serra)
			somma += parseInt(subString);
	}
	somma += parseInt(quantita);

	return somma;
}





function calcolaDimSerra(quantita, serra){
	var somma = 0;

	for(var i = 0; i<((body.rows.length)-3); i++){

		var str = body.rows[i].cells.item(1).innerHTML;
		var subString = str.substring(0, str.length - 4);

		if(body.rows[i].cells.item(4).innerHTML === serra)
			somma += parseInt(subString);
	}
	somma += parseInt(quantita);

	return somma;
}


function calcolaImporti(){
	var somma = 0;

	for(var i = 0; i<((body.rows.length)-3); i++){

		var str = body.rows[i].cells.item(3).innerHTML;
		var subString = str.substring(0, str.length - 2);

		somma += parseFloat(subString);
	}

	$("#parziale").html(somma.toFixed(2));
	$("#imposte").html( ((somma/100) * 20).toFixed(2) );
	$("#totale").html("<strong>" + (somma + ((somma/100) * 10)).toFixed(2) + "</strong>" );
}

function dimensioneTerreno(totale, serra){

	var dimTotale = totale;
	var dimSerra = serra;
	var dimTerreno = dimTotale - dimSerra;

	return dimTerreno;
}


function prova(){
	var str = body.rows[0].cells.item(3).innerHTML;
	$.get('SalvaPrenotazione', function(data){
		
		alert("prova: "+ data);
	});
}






