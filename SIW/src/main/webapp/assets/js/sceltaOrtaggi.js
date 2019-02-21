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



	var centerLocation; 

	var settings = {
			"async": true,
			"crossDomain": true,
			"url": "https://api.mapbox.com/geocoding/v5/mapbox.places/"+locazione+".json?access_token=pk.eyJ1IjoidmluY2V6b2JvMSIsImEiOiJjanNieXMxZ3MwMjI0NDlubWtxdjFibGswIn0._jWzMdZSVOpRdyFAHG8shA",
			"method": "GET",
			"headers": {}
	}

	$.ajax(settings).done(function (response) {
		console.log(response);
		centerLocation = response.features[0].center;

		mapboxgl.accessToken = 'pk.eyJ1IjoidmluY2V6b2JvMSIsImEiOiJjanNieXMxZ3MwMjI0NDlubWtxdjFibGswIn0._jWzMdZSVOpRdyFAHG8shA';
		var mapBox = new mapboxgl.Map({
			container : 'map', // container id
			style : 'mapbox://styles/mapbox/satellite-streets-v9', // stylesheet location
			center : centerLocation, // starting position [lng, lat]
			zoom : 13
			// starting zoom
		});
		mapBox.addControl(new mapboxgl.NavigationControl());

		new mapboxgl.Marker()
		.setLngLat(centerLocation)
		.addTo(mapBox);


//		map.addControl(new mapboxgl.GeolocateControl({
//			positionOptions: {
//				enableHighAccuracy: true
//			},
//			trackUserLocation: true
//		}));
//		
		new mapboxgl.Marker()
		.setLngLat(centerLocation)
		.addTo(mapBox);

	});


}


	


function aggiornaResocontoTerreno(nome, quantita, resa, prezzo, id, dimTerreno, terrenoPrenotato, idInput){
	var checkbox = document.getElementById(id);
	var	body = document.getElementById('body');
	var riga; 

	var ortaggio = document.getElementById(nome);
	var dimInserita = calcolaDimTerreno(quantita, "no");  //"&#x2718"

	if (checkbox.checked){
	
		if( (dimInserita + terrenoPrenotato) > dimTerreno){
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
				
				//alert("Ortaggio inserito!");  
				$("#alertConferma").show('slow').delay(3500).fadeOut();
				
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
					
					$("#alertModifica").show('slow').delay(3500).fadeOut();
					
				}
			}
		}
	}

	calcolaImporti();

}






function aggiornaResocontoSerra(nome, quantita, resa, prezzo, id, dimSerra, serraPrenotata, idInput){
	var checkbox = document.getElementById(id);
	var	body = document.getElementById('body');
	var riga; 

	var ortaggio = document.getElementById(nome);
	var dimInserita = calcolaDimSerra(quantita, "si"); //&#x2714

	if (checkbox.checked){
		if( (dimInserita + serraPrenotata) > dimSerra){
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
				
				$("#alertConferma").show('slow').delay(3500).fadeOut();
				
				
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
					
					$("#alertModifica").show('slow').delay(3500).fadeOut();
					
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

//function dimensioneTerreno(totale, serra){
//
//	var dimTotale = totale;
//	var dimSerra = serra;
//	var dimTerreno = dimTotale - dimSerra;
//
//	return dimTerreno;
//}


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





