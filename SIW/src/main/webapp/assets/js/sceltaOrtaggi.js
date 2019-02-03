function aggiornaResoconto(nome, quantita, resa, prezzo, id){

	var checkbox = document.getElementById(id);
	var	body = document.getElementById('body');
	var riga; 
	
	var ortaggio = document.getElementById(nome);

	if (checkbox.checked){
		if( ortaggio === null){

			riga = body.insertRow(0);

			var cellaNome = riga.insertCell(0);
			var cellaQuantita = riga.insertCell(1);
			var cellaResa = riga.insertCell(2);
			var cellaPrezzo = riga.insertCell(3);
			var cellaElimina = riga.insertCell(4);

			cellaNome.innerHTML = nome;
			cellaQuantita.innerHTML = quantita + "  m<sup>2</sup>";
			cellaResa.innerHTML = (resa * quantita).toFixed(2) +"  kg";
			cellaPrezzo.innerHTML = (prezzo * quantita).toFixed(2) + " €";
			cellaElimina.innerHTML = "<button class='btn btn-sm btn-danger' onclick='btnCancella(this, id)'><i class='fa fa-trash'></i> </button>";
			
			
			riga.setAttribute("id", nome);

		}	
		else{	
			//rimuoviamo la riga già presente per poi riinserirla con le dovute modifiche
			$('#' + nome).remove();

			riga = body.insertRow(0);

			var cellaNome = riga.insertCell(0);
			var cellaQuantita = riga.insertCell(1);
			var cellaResa = riga.insertCell(2);
			var cellaPrezzo = riga.insertCell(3);
			var cellaElimina = riga.insertCell(4);

			cellaNome.innerHTML = nome;
			cellaQuantita.innerHTML = quantita + "  m<sup>2</sup>";
			cellaResa.innerHTML = (resa * quantita).toFixed(2) +"  kg";
			cellaPrezzo.innerHTML = (prezzo * quantita).toFixed(2) + " €";
			cellaElimina.innerHTML = "<button class='btn btn-sm btn-danger' onclick='btnCancella(this, id)'><i class='fa fa-trash'></i> </button>";

			riga.setAttribute("id", nome);	

		}
	}
}



function cancellaRiga(ortaggio, id){

	var checkbox = document.getElementById(id);
	if(!checkbox.checked){
		$('#' + ortaggio).remove();
	}

}


//DELETE BUTTON
function btnCancella(row, id){

	var riga = row.parentNode.parentNode;
		riga.parentNode.removeChild(riga);
	
		
	//da controllare	
	var parziale = document.getElementById("#parziale");
	alert(parziale.text);	
		
	//non funzionante	
	var checkbox = document.getElementById(id);
	checkbox.checked = false;
			
}
