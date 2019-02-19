
//Intercetta il click sul Tab Pane
//$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
//    var target = $(e.target).attr("href");
//        alert(target);
//});

$(function() {
	$("#navbar").load("navBarAreaAziende.jsp");
	$("#footer").load("footer.jsp");
});

function annullaAddOrtaggio(){
	$('#divAddOrtaggio').remove();
	$('#info_terreno').show('slow');
}

//preleva i dati se checked
function sulcess(){
	$('#tabella').find('input[type="checkbox"]:checked').each(
		function() {
			var riga = $(this).val();
			var $row = $('<tr>' + '<th>' + $('#nome' + riga).text()
					+ '</th>' + '<th>' + $('#prezzo' + riga).val()
					+ '</th>' + '<th>' + $('#resa' + riga).text()
					+ '</th>' + '<th>' + $('#tempo' + riga).val()
					+ '</th>' + '</tr>');
			document.body.innerHTML = $row.text();
		});
	}
//ajax Aggiungi ortaggi a terreno pre-esistente
function funAggiungiOrtaggi(){
	
	var terreno_id = $("#editFormId").val();
	$.ajax({
		url : "PrelevaOrtaggi?edit=false&addOrtaggio=true",
		dataType : 'json',
		error : function() {
			alert("si è verificato un errore");
		},
		success : function(data) {
			$("#info_terreno").hide('slow');
			var table = $('<div class="container-fluid" id="divAddOrtaggio">'+
							'<form class="custom-form" method="post" action="TerrenoOspitaOrtaggi?edit=false" id="formAddOrtaggio">'+
								'<div class="form-row form-group">'+
									'<div class="table-responsive" id="table-scroll">'+
										'<table class="table table-hover" id="tabella">'+
											'<thead>'+
												'<tr>'+
													'<th></th>'+
													'<th><strong>Nome</strong></th>'+
													'<th><strong>Resa</strong></th>'+
													'<th><strong>Prezzo (€/mt²)</strong></th>'+
													'<th><strong>Tempo Coltivazione (giorni)</strong></th>'+
												'</tr>'+
											'</thead>'+
											'<tbody id="ortaggiColtivabili">'+
											'</tbody>'+
										'</table>'+
										'</div>'+
									'</div>'+
									'<div align="center">'+
									'<button class="button buttonoverflow btn" onclick="annullaAddOrtaggio()" type="button">Annulla</button>'+
									'<button class="button buttonoverflow btn" type="button" onclick="sulcess()" >Salva</button>'+
								'</div>'+
						'</form>'+
					'</div>'
			);
			$("#imieiterreni").append(table);
			for(var i = 0; i<data.length;i++)
				{
					var $row = $('<tr class="accordion-toggle" data-toggle="collapse">'+
														'<td><input type="checkbox" value="" name="ortaggiSelezionati"></td>'+
														'<td id="nome">'+data[i].nome+'</td>'+
														'<td id="resa">'+data[i].resa+'</td>'+
														'<td><input class="input-column" type="text" style="max-width: 80px" name="prezzo" id="prezzo" placeholder="prezzo"></td>'+
														'<td><input class="input-column" type="text" style="max-width: 80px" name="tempo" id="tempo" placeholder="giorni"></td>'+
													'</tr>'
					)
					$("#tabella > tbody:last").append($row);
				}
			}
	});
}

/**
 * mostra una lista degli ortaggi in base al terreno selezionato
 * 
 * @param terreno_id
 * @returns
 */
function mostraOrtaggi(terreno_id) {

	$.ajax({
		url : "PrelevaOrtaggi?edit=true&addOrtaggio=false&editFormId="+terreno_id,
		dataType : 'json',
		error : function() {
			alert("si è verificato un errore");
		},
		success : function(data) {
			// alert(JSON.stringify(data));
			// var x = JSON.parse(data);
			$('#formModificaOrtaggi> tbody').empty();
			for(i = 0; i < data.length;i++)
				{
					var $row = $('<tr align="center" >'+
						  '<th id="listaOrtaggioId'+data[i].id+'" style="display:none;">'+data[i].id+'</th>'+
					      '<th id="listaOrtaggioNome'+data[i].id+'">'+data[i].nome+'</th>'+
					      '<th id="listaOrtaggioResa'+data[i].id+'">'+data[i].resa+'</th>'+
					      '<th id="listaOrtaggioCosto'+data[i].id+'">'+data[i].costo+'</th>'+
					      '<th id="listaOrtaggioTempo'+data[i].id+'">'+data[i].tempo+'</th>'+
					      '<th><button type="button" class="button_modifica btn" onclick="modificaOrtaggi('+data[i].id+')" id=modifica_ortaggio></th>'+
					      '<th><button type="button" class="button_elimina btn" id=cancellaOrtaggio></th>'+
					      '</tr>'
					);
					$('#formModificaOrtaggi> tbody:last').append($row);
			}
// var colHeader = Object.keys(data[0]);
//
// for(var i=0; i<3; i++){
// $('#formModificaOrtaggi> tbody').append('<tr></tr>')
// for(var j= 0; j<colHeader.length; j++){
// $('#formModificaOrtaggi> tbody tr').append('<td>' + data[i][colHeader[j]] +
// '</td>');
// }
// }
//			
//			
		}
	});	
}

/**
 * chiamata ajax per la modifica degli ortaggi prelevando i dati dalla form
 * 
 * @returns
 */
// function SalvaTerrenoModificato() {
	$(document).ready(function() {
		$("#confermaModificaOrtaggio").click(function(e) {
			e.preventDefault();
		// var dati = $("#editOrtaggioNome").val();
		var nome = {
				idTerreno: $("#editFormId").val(),
				idOrtaggio: $("#editOrtaggioId").val(),
				nomeOrtaggio: $("#editOrtaggioNome").val(),	
				resaOrtaggio: $("#editOrtaggioResa").val(),
				costoOrtaggio: $("#editOrtaggioCosto").val(),
				tempoOrtaggio: $("#editOrtaggioTempo").val()
		};
		// alert(nome.nomeOrtaggio+" "+nome.idOrtaggio);
		// alert(dati);
	$.ajax({
		type: "POST",
		url : "TerrenoOspitaOrtaggi?edit=false&editOrtaggio=true",
		// data: {nomeOrtaggio: $("#editOrtaggioNome").val()},
		contentType: "application/json; charset=utf-8",
		dataType : "json",
		data: JSON.stringify(nome),
		success: function(data){
			//alert(data.success);
			$("#formModificaOrtaggio").hide("slow");
			$("#containerModificaOrtaggi").show("slow");
			$("#info_terreno").show("slow");
			mostraOrtaggi($("#editFormId").val());
			var allerta = $('<div class="alert alert-success alert-dismissible fade show" role="alert" id="alertConferma">'+
						'<button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
						'<span aria-hidden="true">&times;</span>'+
						'</button>'+
						'<strong>Perfetto! I dati sono stati aggiornati.'+
						'</div>'
				);
			$("#info_terreno").prepend(allerta);
			//$("#alertConferma").hide('slow').delay('9000');
			$("#alertConferma").show('slow').delay(5000).fadeOut();

		}
		
		});	
	});
});	

/**
 * funzione per popolare la form delle info sul terreno
 * 
 * @param id
 * @param locazione
 * @param dim
 * @param dimSerra
 * @param costo
 * @param servizioC
 * @param servizioP
 * @param periodo
 * @returns
 */
function edit(id, locazione, dim, dimSerra, costo, servizioC, servizioP,periodo) {
	$("#editFormId").val(id);
	$("#editFormLocazione").val(locazione);
	$("#editFormDimensione").val(dim);
	$("#editFormDimensioneSerra").val(dimSerra);
	$("#editFormCosto").val(costo);
	if (servizioC === 'true') {
		$("#editCheckCompleto").attr('checked', true);
	} else {
		$("#editCheckCompleto").attr('checked', false);
	}
	if (servizioP === 'true') {
		$("#editCheckParziale").attr('checked', true);
	} else {
		$("#editCheckParziale").attr('checked', false);
	}
	$('#dropdownDisponibilita').val(periodo);
	
	var terreno_id = $("#editFormId").val();
	mostraOrtaggi(terreno_id)
	
	$("#terreni").hide("fast");
	$("#info_terreno").show("slow");

}
/**
 * funzione che setta l'id del terreno da eliminare
 * 
 * @param id
 * @returns
 */
function del(id) {
	// alert(id);
	$('#idDaEliminare').val(id);

}
/**
 * funzione che setta l'id del prodotto da eliminare
 * 
 * @param id
 * @returns
 */
function delProdotto(id) {
	// alert(id);
	$('#prodottoDaEliminare').val(id);

}
/**
 * funzione che fa apparire il div della lista dei terreni e nasconde la form di
 * modifica dei dati del terreno
 * 
 * @returns
 */
$(document).ready(function() {
	$("#annulla_modifica").click(function() {
		$("#terreni").show("slow");
		$("#info_terreno").hide("fast");

	});
});

/**
 * funzione che fa apparire la form di modifica degli ortaggi
 * 
 * @returns
 */
$(document).ready(function() {
	$("#modificaOrtaggi").click(function() {
		$("#formModificaTerreno").hide("fast");
		$("#containerModificaOrtaggi").show("slow");
		

	});
});
/**
 * funzione che nasconde la modifica dell'ortaggio
 * 
 * @returns
 */
$(document).ready(function() {
	$("#annulla_ortaggi").click(function() {
		$("#containerModificaOrtaggi").hide("fast");
		$("#formModificaTerreno").show("slow");

	});
});
/**
 * funzione per popolare e visualizzare la form sulle info dei prodotti inseriti
 * dall'azienda
 * 
 * @param id
 * @param nome
 * @param categoria
 * @param costo
 * @param quantita
 * @param descrizione
 * @returns
 */
function prodotto(id, nome, categoria, costo, quantita, descrizione) {
	$("#editProdottoId").val(id);
	$("#editProdottoNome").val(nome);
	$("#editProdottoCategoria").val(categoria);
	$("#editProdottoCosto").val(costo);
	$("#editProdottoDescrizione").val(descrizione);
	$("#editProdottoQuantita").val(quantita);

	$("#prodotti").hide("fast");
	$("#info_prodotto").show("slow");
}
/**
 * nasconde le info dei prodotti
 * 
 * @returns
 */
$(document).ready(function() {
	$("#annulla_prodotto").click(function() {
		$("#info_prodotto").hide("fast");
		$("#prodotti").show("slow");

	});
});

/**
 * funzione per popolare la form sulle info degli ortaggi
 * 
 * @param id
 * @returns
 */
function modificaOrtaggi(id) {
	$("#containerModificaOrtaggi").hide("slow");
	$("#info_terreno").hide("slow");
	$("#formModificaOrtaggio").show("slow");
	$("#editOrtaggioId").val(id);
	$("#editOrtaggioNome").val($('#listaOrtaggioNome'+id).text());
	$("#editOrtaggioResa").val($('#listaOrtaggioResa'+id).text());
	$("#editOrtaggioCosto").val($('#listaOrtaggioCosto'+id).text());
	$("#editOrtaggioTempo").val($('#listaOrtaggioTempo'+id).text());
	
	
}
/**
 * fa nascondere la form di modifica dell'ortaggio
 * 
 * @returns
 */
$(document).ready(function() {
	$("#annulla_ortaggio").click(function() {
		$("#formModificaOrtaggio").hide("slow");
		$("#containerModificaOrtaggi").show("slow");
		$("#info_terreno").show("slow");

	});
});
