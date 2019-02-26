//Intercetta il click sul Tab Pane
//$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
//var target = $(e.target).attr("href");
//alert(target);
//});

$(function() {
	$("#navbar").load("navBarAreaAziende.jsp");
	$("#footer").load("footer.jsp");
});

function generaModalOrdine(idCliente){
	var $baseModal = ('<div class="modal fade" id="ModalDettagliOrdine" style="z-index: 2500;">'+
			'</div><!-- /.modal -->')
			$('body').append($baseModal);
			
	$.ajax({
		url: "DammiOrdini?getDatiCliente="+idCliente,
		method: "GET",
		dataType: "json",
		success:function(data){
			$('#ModalDettagliOrdine').empty();
	var $modal = ('<div class="modal-dialog" style="border: 2px #ad835a solid; border-radius: 15px">'+
  '<div class="modal-content" style="background: #d3c3b3; border-radius: 15px" align="center">'+
    '<div class="modal-header">'+
    '<h4 class="modal-title">Dettagli sul Cliente</h4>'+
      '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>'+
    '</div>'+
    '<div class="modal-body">'+
      '<table>'+
          '<thead>'+
          '</thead>'+
          '<tbody class="table table-bordered">'+
              '<tr>'+
                  '<td><strong>Nome: </strong></td>'+
                  '<td>'+data.nome+'</td>'+
                  '<td><strong>Indirizzo: </strong></td>'+
                  '<td>'+data.indirizzo+'</td>'+
              '</tr>'+
              '<tr>'+
              	'<td><strong>Cognome: </strong></td>'+
              	'<td>'+data.cognome+'</td>'+
              	'<td><strong>Città: </strong></td>'+
                '<td>'+data.citta+'</td>'+
              '</tr>'+
              '<tr>'+
              '<td><strong>Telefono: </strong></td>'+
              '<td>'+data.telefono+'</td>'+
              '<td><strong>CAP: </strong></td>'+
              '<td>'+data.cap+'</td>'+
            '</tr>'+
            '<tr>'+
            '<td><strong>Email: </strong></td>'+
            '<td>'+data.email+'</td>'+
            '<td><strong>Provincia: </strong></td>'+
            '<td>'+data.provincia+'</td>'+
          '</tr>'+
          '</tbody>'+
      '</table>'+
    '</div>'+
    '<div class="modal-footer">'+
      '<button type="button" class="btn btn-default" data-dismiss="modal">Chiudi</button>'+
    '</div>'+
  '</div><!-- /.modal-content -->'+
'</div><!-- /.modal-dialog -->'
)

$('#ModalDettagliOrdine').append($modal);
$('#ModalDettagliOrdine').modal('show');

	}
});
}
//Genera la tabella degli ordini
function ordiniEffettuati(){
	$("#divOrdini").empty();
	
	var $table = ('<div class="container-fluid" id="containerOrdini">'
			+ '<div class="form-row form-group">'
			+ '<div class="table-responsive" id="table-scroll">'
			+ '<table class="table table-hover" id="tabListaOrdini" style="background-color:rgb(0, 102, 0,.4); border-radius:15px">'
			+ '<thead>' + '<tr align="center">' + '<th>Prodotto</th>'
			+ '<th>Cliente</th>' + '<th>Data</th>'
			+ '<th>Dettagli</th>' + '</tr>' + '</thead>'
			+ '</table>' + '</div>' + '</div>' + '</div>')
	
	var $loading = ('<div class="container-fluid" align="center" id="loading">'
			+ '<div class="loader" role="status" >' + '</div>' + '</div>')
			
	$("#divOrdini").append($table);
	$("#divOrdini").append($loading);
	$.ajax({
		url: "DammiOrdini",
		method: "GET",
		dataType: "json",
		contentType : "application/json; charset=utf-8",
		success: function(data){
			$("#tabListaOrdini > tbody").empty();
			for(var i = 0;i<data.length;i++){
				var $row = ('<tbody>'
					+ '<tr id="rigaOrdini" style="color:white" align="center" data-toggle="collapse" data-target="#listaOrdini" aria-expanded="false" aria-controls="listaOrdini">'
					+ '<td>'+data[i].NomeProdotto+'</td>'
					+ '<td>'+data[i].NomeCliente+'</td>'
					+ '<td>'+data[i].DataAcquisto+'</td>'
					+ '<td><button class="button_info btn" id="list_info" type="button" onclick="generaModalOrdine('+data[i].idCliente+')"></button></td>'
					+ '</tr>'
					+ '</tbody>')
										
					$("#tabListaOrdini").append($row);
			}
			$("#loading").remove();
		}
	});

	
}

$(function chartStatistiche(){
	var idAzienda = $('#id_azienda').val();
		$.ajax({
			url: "CalcolaStatistiche?azienda="+idAzienda,
			method: "GET",
			dataType: "json",
			success: function(data){
				var ctx = document.getElementById('myChart').getContext('2d');
				var chart = new Chart(ctx, {
				    // The type of chart we want to create
				    type: 'bar',
				    
				    // The data for our dataset
				    data: {
				    	
				        datasets: [{
				        	
				            label: "Primavera",
				            backgroundColor: 'rgb(0, 153, 0,.3)',
				            borderColor: 'rgb(0, 153, 0)',
				            data: [data.primavera],
				            
				        },
				        {
				        	
				        	 label: "Estate",
					            backgroundColor: 'rgb(204, 0, 0,.3)',
					            borderColor: 'rgb(204, 0, 0)',
					            data: [data.estate],
				        },
				        {
				        	
				        	label: "Autunno",
				            backgroundColor: 'rgb(255, 153, 0,.3)',
				            borderColor: 'rgb(255, 153, 0)',
				            data: [data.autunno],
				        },
				        {
				        	
				        	label: "Inverno",
				            backgroundColor: 'rgb(92, 92, 138,.3)',
				            borderColor: 'rgb(92, 92, 138)',
				            data: [data.inverno],
				        }
				        ],
				       
				    },

				    // Configuration options go here
				    options: {
				    	scales:{
				    		yAxes:[{
				    			ticks:{
				    				min: 0,
				    				stepSize: 1
				    			}
				    		}]
				    	}
				    }
				});
			},
			error: function(data){
				
			}
		});
		
});

function distruggiOrtaggiPrenotati(terreno,cliente){
	$("#chiudi"+terreno+cliente).remove();
	$('#listaOrtaggi'+terreno+cliente).empty();
	$('#listaOrtaggi'+terreno+cliente).removeClass('show');
	var $button_info = ('<button class="button_info btn" id="list_info'+terreno+cliente+'" type="button"'  
					+'onclick="ortaggiPrenotati('+terreno+','+cliente+')"></button>')
	$("#info_row"+terreno+cliente).append($button_info);
}

function ortaggiPrenotati(terreno,cliente) {	
	
	
			$.ajax({
				url : "DammiPrenotazioneAzienda?edit=false&id_terreno=" +terreno+"&id_cliente="+cliente,
				method : "GET",
				dataType : "json",
		
				error : function() {
					alert("si è verificato un errore in listaOrtaggi");
				},
		
				success : function(data) {
					$("#list_info"+terreno+cliente).remove();
					var $chiudi =('<button class=" button_chiudi btn" id="chiudi'+terreno+cliente+'" onclick="distruggiOrtaggiPrenotati('+terreno+','+cliente+')" type="button"></button>')
					$("#info_row"+terreno+cliente).append($chiudi);
					
					var $table = ('<tr align="center">' + '<th>Nome</th>' + '<th>Quantità</th>'
							+ '<th>Serra</th>'+'<td></td>'+ '</tr>')
					$('#listaOrtaggi'+terreno+cliente).append($table);
					for (var i = 0; i < data.length; i++) {
						
						var $row = ('<tr align="center" style="color:white">' + '<td>' + data[i].ortaggio
								+ '</td>' + '<td>' + data[i].quantita + '</td>'
								+ '<td>' + data[i].serra + '</td>'
								+ '<td></td>'
								+ '</tr>')
							$("#listaOrtaggi"+terreno+cliente).append($row);
					}
					
				}
		
			});

}
function prenotazioniAzienda() {
	
	$('#prenotazioni').empty();
	var $table = ('<div class="container-fluid" id="prenotazioniAzienda">'
			+ '<div class="form-row form-group">'
			+ '<div class="table-responsive" id="table-scroll">'
			+ '<table class="table table-hover table-curved" id="tabListaPrenotazioni" style="background-color:rgb(0, 102, 0,.4); border-radius:15px">'
			+ '<thead style="color:black">' + '<tr align="center">' + '<th>Terreno</th>'
			+ '<th>Cliente</th>' + '<th>Data</th>'
			+ '<th>Dettagli</th>' + '</tr>' + '</thead>'
			+ '</table>' + '</div>' + '</div>' + '</div>')

			$("#prenotazioni").append($table);

	var $loading = ('<div class="container-fluid" align="center" id="loading">'
			+ '<div class="loader" role="status" >' + '</div>' + '</div>')
			$("#prenotazioni").append($loading);

	$
	.ajax({
		url : 'DammiPrenotazioneAzienda?edit=true',
		method : 'GET',
		dataType : "json",
		error : function() {
			alert("si è verificato un errore");
		},

		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				var $row = ('<tbody style="color:white">'
						+ '<tr id="rigaPren" align="center" data-toggle="collapse" data-target="#listaOrtaggi'+ data[i].id_terreno+data[i].id_cliente+'"aria-controls="listaOrtaggi">'
						+ '<td>'+ data[i].terreno+ '</td>'
						+ '<td>'+ data[i].cliente_nome+' '+ data[i].cliente_cognome+ '</td>'
						+ '<td>'+ data[i].data+ '</td>'
						+ '<td id="info_row'+data[i].id_terreno+data[i].id_cliente+'"><button class="button_info btn" id="list_info'+data[i].id_terreno+data[i].id_cliente+'" type="button"'  
						+ 'onclick="ortaggiPrenotati('+data[i].id_terreno+','+data[i].id_cliente+')"></button></td>'
						+ '</tr>'
						+ '</tbody>'
						+ '<tbody class="collapse" style="background-color:rgb(255, 204, 0,0.4)" id="listaOrtaggi'+data[i].id_terreno+data[i].id_cliente+'"' + '</tbody')
						$("#tabListaPrenotazioni").append($row);
			}

			$("#loading").remove();

		}

	});

}

function annullaAddOrtaggio() {
	$('#divAddOrtaggio').remove();
	$('#info_terreno').show('slow');
}
//Cancella l'ortaggio selezionato nella tab di modifica terreno
function cancellaOrtaggio(idTerreno, idOrtaggio) {
	var $modal = ('<div id="modalCancellaOrtaggio" class="modal fade" role="dialog" style="z-index: 2500; border-radius: 25px">'
			+ '<div class="modal-dialog" style="border: 2px green solid">'
			+ '<div class="modal-content">'
			+ '<div class="modal-header">'
			+ '<h4 class="modal-title">Elimina Ortaggio</h4>'
			+ '<button type="button" class="close" data-dismiss="modal">&times;</button>'
			+ '</div>'
			+ '<div class="modal-body">'
			+ '<p>Sei sicuro di voler eliminare questo ortaggio?</p>'
			+ '</div>'
			+ '<div class="modal-footer">'
			+ '<div class="container" align="right">'
			+ '<button type="button" class="btn" style="border-radius: 15px" data-dismiss="modal" id="buttonoverflow">Annulla</button>'
			+ '<button type="button" class="btn btn-success" style="border-radius: 15px" id="btnConfermaCancellaOrtaggio">Conferma</button>'
			+ '</div>' + '</div>' + '</div>' + '</div>' + '</div>')
			$(document).ready(function() {
				$('body').append($modal);
				$('#modalCancellaOrtaggio').modal('show');
			});

	$(document)
	.ready(
			function() {
				$("#btnConfermaCancellaOrtaggio")
				.click(
						function(e) {
							$('#modalCancellaOrtaggio').modal(
							'hide');
							$
							.ajax({
								url : 'TerrenoOspitaOrtaggi?delete=true&deleteOrtaggio&idTerreno='
									+ idTerreno
									+ '&idOrtaggio='
									+ idOrtaggio,
									method : 'GET',
									error : function() {
										alert("si è verificato un errore");
									},
									success : function(data) {
										$(
										'#modalCancellaOrtaggio')
										.remove();
										$("#info_terreno")
										.show(
										"slow");
										mostraOrtaggi($(
										"#editFormId")
										.val());
										var allerta = $('<div class="alert alert-success alert-dismissible fade show" role="alert" id="alertConferma">'
												+ '<button type="button" class="close" data-dismiss="alert" aria-label="Close">'
												+ '<span aria-hidden="true">&times;</span>'
												+ '</button>'
												+ '<strong>Perfetto! ortaggio cancellato'
												+ '</div>');
										$("#info_terreno")
										.prepend(
												allerta);
										$("#alertConferma")
										.show(
										'slow')
										.delay(5000)
										.fadeOut();
									}
							});
						});
			});

}
//preleva i dati se checked
function salvaOrtaggi(terrenoId) {
	$
	.ajax({
		url : 'TerrenoOspitaOrtaggi?edit=false&editOrtaggio=false&aggiuntaOrtaggi&terrenoId='
			+ terrenoId,
			method : 'POST',
			data : $("#formAddOrtaggio").serialize(),
			error : function() {
				alert("si è verificato un errore");
			},
			success : function(data) {
				$('#divAddOrtaggio').remove();
				// $("#containerModificaOrtaggi").show("slow");
				$("#info_terreno").show("slow");
				mostraOrtaggi($("#editFormId").val());
				var allerta = $('<div class="alert alert-success alert-dismissible fade show" role="alert" id="alertConferma">'
						+ '<button type="button" class="close" data-dismiss="alert" aria-label="Close">'
						+ '<span aria-hidden="true">&times;</span>'
						+ '</button>'
						+ '<strong>Perfetto! I nuovi ortaggi sono stati aggiunti.'
						+ '</div>');
				$("#info_terreno").prepend(allerta);
				// $("#alertConferma").hide('slow').delay('9000');
				$("#alertConferma").show('slow').delay(5000).fadeOut();
			}
	});

}
//ajax Aggiungi ortaggi a terreno pre-esistente
function funAggiungiOrtaggi() {

	var terreno_id = $("#editFormId").val();
	$
	.ajax({
		url : "PrelevaOrtaggi?edit=false&addOrtaggio=true",
		dataType : 'json',
		error : function() {
			alert("si è verificato un errore");
		},
		success : function(data) {
			$("#info_terreno").hide('slow');
			var table = $('<div class="container-fluid" id="divAddOrtaggio">'
					+ '<form class="custom-form" method="post" id="formAddOrtaggio">'
					+ '<div class="form-row form-group">'
					+ '<div class="table-responsive" id="table-scroll">'
					+ '<table class="table table-hover" id="tabAggiuntaOrtaggi">'
					+ '<thead>'
					+ '<tr>'
					+ '<th></th>'
					+ '<th><strong>Nome</strong></th>'
					+ '<th><strong>Resa</strong></th>'
					+ '<th><strong>Prezzo (€/mt²)</strong></th>'
					+ '<th><strong>Tempo Coltivazione (giorni)</strong></th>'
					+ '</tr>'
					+ '</thead>'
					+ '<tbody id="ortaggiColtivabili">'
					+ '</tbody>'
					+ '</table>'
					+ '</div>'
					+ '</div>'
					+ '<div align="center">'
					+ '<button class="button buttonoverflow btn" onclick="annullaAddOrtaggio()" type="button">Annulla</button>'
					+ '<button class="button btn" onclick="salvaOrtaggi('
					+ terreno_id
					+ ')" type="button">Salva</button>'
					+ '</div>' + '</form>' + '</div>');
			$("#imieiterreni").append(table);
			for (var i = 0; i < data.length; i++) {
				var $row = $('<tr class="accordion-toggle" data-toggle="collapse">'
						+ '<td><input type="checkbox" value="'
						+ data[i].id
						+ '" name="ortaggiSelezionati"></td>'
						+ '<td id="nome'
						+ data[i].id
						+ '">'
						+ data[i].nome
						+ '</td>'
						+ '<td id="resa'
						+ data[i].id
						+ '">'
						+ data[i].resa
						+ '</td>'
						+ '<td><input class="input-column" type="text" style="max-width: 80px" name="prezzo'
						+ data[i].id
						+ '" id="prezzo" placeholder="prezzo"></td>'
						+ '<td><input class="input-column" type="text" style="max-width: 80px" name="tempo'
						+ data[i].id
						+ '" id="tempo" placeholder="giorni"></td>'
						+ '</tr>')
						$("#tabAggiuntaOrtaggi > tbody:last").append($row);
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

	$
	.ajax({
		url : "PrelevaOrtaggi?edit=true&addOrtaggio=false&editFormId="
			+ terreno_id,
			dataType : 'json',
			error : function() {
				alert("si è verificato un errore");
			},
			success : function(data) {
				// alert(JSON.stringify(data));
				// var x = JSON.parse(data);
				$('#formModificaOrtaggi> tbody').empty();
				for (i = 0; i < data.length; i++) {
					var $row = $('<tr align="center" >'
							+ '<th id="listaOrtaggioId'
							+ data[i].id
							+ '" style="display:none;">'
							+ data[i].id
							+ '</th>'
							+ '<th id="listaOrtaggioNome'
							+ data[i].id
							+ '">'
							+ data[i].nome
							+ '</th>'
							+ '<th id="listaOrtaggioResa'
							+ data[i].id
							+ '">'
							+ data[i].resa
							+ '</th>'
							+ '<th id="listaOrtaggioCosto'
							+ data[i].id
							+ '">'
							+ data[i].costo
							+ '</th>'
							+ '<th id="listaOrtaggioTempo'
							+ data[i].id
							+ '">'
							+ data[i].tempo
							+ '</th>'
							+ '<th><button type="button" class="button_modifica btn" onclick="modificaOrtaggi('
							+ data[i].id
							+ ')" id=modifica_ortaggio></th>'
							+ '<th><button type="button" class="button_elimina btn" onclick="cancellaOrtaggio('
							+ terreno_id
							+ ','
							+ data[i].id
							+ ')"></th>'
							+ '</tr>');
					$('#formModificaOrtaggi> tbody:last').append($row);
				}
				// var colHeader = Object.keys(data[0]);
				//
				// for(var i=0; i<3; i++){
				// $('#formModificaOrtaggi> tbody').append('<tr></tr>')
				// for(var j= 0; j<colHeader.length; j++){
				// $('#formModificaOrtaggi> tbody tr').append('<td>' +
				// data[i][colHeader[j]] +
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
//function SalvaTerrenoModificato() {
$(document)
.ready(
		function() {
			$("#confermaModificaOrtaggio")
			.click(
					function(e) {
						e.preventDefault();
						// var dati =
						// $("#editOrtaggioNome").val();
						var nome = {
								idTerreno : $("#editFormId").val(),
								idOrtaggio : $("#editOrtaggioId")
								.val(),
								nomeOrtaggio : $(
								"#editOrtaggioNome").val(),
								resaOrtaggio : $(
								"#editOrtaggioResa").val(),
								costoOrtaggio : $(
								"#editOrtaggioCosto").val(),
								tempoOrtaggio : $(
								"#editOrtaggioTempo").val()
						};
						// alert(nome.nomeOrtaggio+"
						// "+nome.idOrtaggio);
						// alert(dati);
						$
						.ajax({
							type : "POST",
							url : "TerrenoOspitaOrtaggi?edit=false&editOrtaggio=true",
							// data: {nomeOrtaggio:
							// $("#editOrtaggioNome").val()},
							contentType : "application/json; charset=utf-8",
							dataType : "json",
							data : JSON.stringify(nome),
							success : function(data) {
								// alert(data.success);
								$(
								"#formModificaOrtaggio")
								.hide("slow");
								$(
								"#containerModificaOrtaggi")
								.show("slow");
								$("#info_terreno")
								.show("slow");
								mostraOrtaggi($(
								"#editFormId")
								.val());
								var allerta = $('<div class="alert alert-success alert-dismissible fade show" role="alert" id="alertConferma">'
										+ '<button type="button" class="close" data-dismiss="alert" aria-label="Close">'
										+ '<span aria-hidden="true">&times;</span>'
										+ '</button>'
										+ '<strong>Perfetto! I dati sono stati aggiornati.'
										+ '</div>');
								$("#info_terreno")
								.prepend(
										allerta);
								// $("#alertConferma").hide('slow').delay('9000');
								$("#alertConferma")
								.show('slow')
								.delay(5000)
								.fadeOut();

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
function edit(id, locazione, dim, dimSerra, costo, servizioC, servizioP,
		periodo) {
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
	$("#editOrtaggioNome").val($('#listaOrtaggioNome' + id).text());
	$("#editOrtaggioResa").val($('#listaOrtaggioResa' + id).text());
	$("#editOrtaggioCosto").val($('#listaOrtaggioCosto' + id).text());
	$("#editOrtaggioTempo").val($('#listaOrtaggioTempo' + id).text());

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
