function visualizzaOrtaggi(){
	$("#chiudimappa").hide();
	$("#divaprimappa").show();
	
	$("#mapesterno").hide("slow");
	$("#myscegli").show("slow");

}


function apriMappa(locazione){

	$("#divaprimappa").hide();
	$("#chiudimappa").show();

	
	$("#myscegli").hide("slow");
	$("#mapesterno").show("slow");

	//var pointCenter = https://api.mapbox.com/geocoding/v5/mapbox.places/.json?access_token=pk.eyJ1IjoidmluY2V6b2JvMSIsImEiOiJjanNieXMxZ3MwMjI0NDlubWtxdjFibGswIn0._jWzMdZSVOpRdyFAHG8shA

	mapboxgl.accessToken = 'pk.eyJ1IjoidmluY2V6b2JvMSIsImEiOiJjanNieXMxZ3MwMjI0NDlubWtxdjFibGswIn0._jWzMdZSVOpRdyFAHG8shA';
	var map = new mapboxgl.Map({
		container : 'map', // container id
		style : 'mapbox://styles/mapbox/satellite-v9', // stylesheet location
		center : [ 16.25,39.3], // starting position [lng, lat]
		zoom : 16
	// starting zoom
	});
	map.addControl(new mapboxgl.NavigationControl());
}


	


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
				cellaQuantita.innerHTML = quantita;
				cellaPrezzo.innerHTML = (prezzo * quantita).toFixed(2);
				
				
				if(id == "soloTerreno"){
					cellaSerra.innerHTML = "-";
					cellaResa.innerHTML = resa;
					
				}
				else{
					cellaSerra.innerHTML = "no"; 
					cellaResa.innerHTML = (resa * quantita).toFixed(2);
					
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
					cellaQuantita.innerHTML = quantita;	
					cellaPrezzo.innerHTML = (prezzo * quantita).toFixed(2);
					
					if(id == "soloTerreno"){
						cellaSerra.innerHTML = "-";
						cellaResa.innerHTML = resa;
						
					}
					else{
						cellaSerra.innerHTML = "no"; 
						cellaResa.innerHTML = (resa * quantita).toFixed(2);
						
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
				cellaQuantita.innerHTML = quantita;
				cellaResa.innerHTML = (resa * quantita).toFixed(2);
				cellaPrezzo.innerHTML = (prezzo * quantita).toFixed(2);
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
					cellaQuantita.innerHTML = quantita;
					cellaResa.innerHTML = (resa * quantita).toFixed(2);
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


function prova(paypal,mastercard){
	
	var checkboxPaypal = document.getElementById(paypal);
	var checkboxMastercard = document.getElementById(mastercard);
	
	if( (!checkboxPaypal.checked) && (!checkboxMastercard.checked)){
		$('#modalPagamento').modal('show');
	}
	else{

		var str = [];
		for(var i = 0; i<((body.rows.length)-3); i++){

			for(var j = 0; j<4; j++){
				str.push(body.rows[i].cells.item(j).innerHTML);
			}	
			str.push(body.rows[i].cells.item(4).innerHTML+"@");

		}
		$.get("SalvaPrenotazione", {'str[]':[ str.slice(length)]});
		caricaPag();
	}
	
}


function caricaPag (){
	window.location.href = "ricevutaPagamento.jsp";
}





