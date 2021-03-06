var prodotti = {
		carrello: []
};
var cliente; 

$(document).ready(function(){

	cliente = document.getElementById("idCliente").value;
	
	if(Cookies.getJSON('prodotti'+cliente).length == 0){
		prodotti = {
				carrello: []
		};
	}
	else{
		 prodotti = {
				carrello: Cookies.getJSON('prodotti'+cliente)
		};
		
		 if(prodotti.carrello.length > 0)
			 $('#dimensioneCarrello').html("("+prodotti.carrello.length+")");	
		 else
			 $('#dimensioneCarrello').html("");
	
	}
	
});

function aggiungiAlCarrello(id, nome, categoria, quantita, prezzo, azienda){
	var presente = false;

	for(var i = 0; i<prodotti.carrello.length; i++){
		if(prodotti.carrello[i].id == id){
			presente = true;
		}
	}

	if(presente == true){
		$('#alertGiaInserito'+id).show('slow').delay(3500).fadeOut();
	}
	else{
		prodotti.carrello.push({ 
			"id" : id,
			"nome" : nome,
			"categoria" : categoria,
			"quantita" : quantita,
			"prezzo" : prezzo,
			"azienda" : azienda
		});
		$('#alertConferma'+id).show('slow').delay(3500).fadeOut();
		$('#dimensioneCarrello').html("("+prodotti.carrello.length+")");
		
		Cookies.set('prodotti'+cliente, prodotti.carrello, { expires: 7 });
	}
	
	
}

function visualizzaProdotti(){

	$('#divCarrello').hide('slow');
	$('#body').empty();
	$('#divScegliProdotti').show('slow');
}

function visualizzaCarrello(){
	$('#divScegliProdotti').hide('slow');
	$('#divCarrello').show('slow');


	var body = document.getElementById('body');
	var somma = 0;
	
	for(var i = 0; i<prodotti.carrello.length; i++){
		
		var $row = $(  "<tr id="+prodotti.carrello[i].id+"> <td>" +
				"<figure class='media'>" +
				"<figcaption class='media-body'>" +
				"<h6 class='title text-truncate'>"+prodotti.carrello[i].nome+"</h6>" +
				"<dl class='param param-inline small'>" +
				"<dt>Categoria:</dt>"+
				"<dd>"+prodotti.carrello[i].categoria+"</dd>"+
				"</dl>"+
				"<dl class='param param-inline small'>" +
				"<dt>Azienda:</dt>"+
				"<dd>"+prodotti.carrello[i].azienda+"</dd>" +
				"</dl>"+
				"</figcaption>"+
				"</figure>"+
				"</td>"+
				"<td> <input class='form-control' id='selezionaQuantita"+prodotti.carrello[i].id+"' type='number' max ='"+prodotti.carrello[i].quantita+"' value='1' onchange='aggiorna(this.id,"+prodotti.carrello[i].id+")'>"+
				"</td>"+
				"<td>"+
				"<div class='price-wrap'>"+
				"<var class='price'>€ "+prodotti.carrello[i].prezzo+"</var>"+
				"</div>" +
				"</td>" +
				"<td class='text-right'><button class='btn btn-outline-danger' onclick='rimuoviProdotto(this, "+prodotti.carrello[i].id+")'> × Rimuovi</button></td>"+
				"</tr>"

		);

		$(body).append($row);

	}

	calcolaImporti();
}



function rimuoviProdotto(row, id){

	var riga = row.parentNode.parentNode.rowIndex;
	document.getElementById("tableCarrello").deleteRow(riga);

	for(var i = 0; i<prodotti.carrello.length; i++){
		if(prodotti.carrello[i].id == id){
			prodotti.carrello.splice(i,1);
		}
	}
	
	Cookies.set('prodotti'+cliente, prodotti.carrello, { expires: 7 });
	
	if(prodotti.carrello.length > 0)
		 $('#dimensioneCarrello').html("("+prodotti.carrello.length+")");	
	 else
		 $('#dimensioneCarrello').html("");
	
	calcolaImporti();		
}


function calcolaImporti(){
	var somma = 0;


	for(var i = 0; i<prodotti.carrello.length; i++){
	
		var quantita = document.getElementById('selezionaQuantita'+prodotti.carrello[i].id).value;
		somma += (parseFloat(prodotti.carrello[i].prezzo) * parseInt(quantita));		
	}

	var spedizione = (somma / 100) * 5;
	var totale = somma + spedizione;

	$('#parziale').html(somma.toFixed(2));
	$('#spedizione').html(spedizione.toFixed(2));
	$('#totale').html(totale.toFixed(2));
}


function aggiorna(idInput, idProdotto){
	var quantita = parseInt(document.getElementById(idInput).value);
	
	for(var i = 0; i<prodotti.carrello.length; i++){
		if(prodotti.carrello[i].id == idProdotto){
			if(quantita > prodotti.carrello[i].quantita){
				$("#alertWarning").show('slow').delay(3500).fadeOut();
				document.getElementById(idInput).value = prodotti.carrello[i].quantita; 
				
			}
		}
	}
	
	calcolaImporti();
}


function salvaAcquisto(paypal,mastercard){

	var checkboxPaypal = document.getElementById(paypal);
	var checkboxMastercard = document.getElementById(mastercard);

	if( (!checkboxPaypal.checked) && (!checkboxMastercard.checked)){
		alert("Devi selezionare una modalità di pagamento")
	}
	else{
		
		for(var i = 0; i<prodotti.carrello.length; i++){
			var quantita = document.getElementById('selezionaQuantita'+prodotti.carrello[i].id).value;
			prodotti.carrello[i].quantita = quantita;
		}
		
		$.ajax({
			type: "POST",
			url: "SalvaAcquisto",
			datatype: "json",
			data: JSON.stringify(prodotti.carrello),
			success: function(data){
				
				caricaPag();
			}
		 });


	}
}

function caricaPag (){
	window.location.href = "ricevutaPagamento.jsp";
}