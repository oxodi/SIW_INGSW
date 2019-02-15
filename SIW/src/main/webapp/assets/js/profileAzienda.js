function mostraOrtaggi(terreno_id) {

	$.ajax({
		url : "PrelevaOrtaggi?edit=true&editFormId="+terreno_id,
		dataType : 'json',
		error : function() {
			alert("si è verificato un errore");
		},
		success : function(data) {
			//alert(JSON.stringify(data));
			//var x = JSON.parse(data);
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
//			var colHeader = Object.keys(data[0]);
//
//			for(var i=0; i<3; i++){
//				  $('#formModificaOrtaggi> tbody').append('<tr></tr>')
//				  for(var j= 0; j<colHeader.length; j++){
//				    $('#formModificaOrtaggi> tbody tr').append('<td>' + data[i][colHeader[j]] + '</td>');
//				  }
//				}
//			
//			
		}
	});	
}


//function SalvaTerrenoModificato() {
	$(document).ready(function() {
		$("#confermaModificaOrtaggio").click(function(e) {
			e.preventDefault();
		//var dati = $("#editOrtaggioNome").val();
		var nome = {
				nomeOrtaggio: $("#editOrtaggioNome").val(),	
				resaOrtaggio: $("#editOrtaggioResa").val(),
				costoOrtaggio: $("#editOrtaggioCosto").val(),
				tempoOrtaggio: $("#editOrtaggioTempo").val(),
		};
		alert(nome.nomeOrtaggio+" "+nome.resaOrtaggio);
		//alert(dati);
	$.ajax({
		type: "POST",
		url : "TerrenoOspitaOrtaggi?edit=false&editOrtaggio=true",
		//data: {nomeOrtaggio: $("#editOrtaggioNome").val()},
		contentType: "application/json; charset=utf-8",
		dataType : "json",
		data: JSON.stringify(nome),
	
		error: function(data) {
			alert("errore");
		},
		success: function(data){
			alert("tutto ok");
		}
		
	});
		});
});	
	

$(function() {
	$("#navbar").load("navBarAreaAziende.jsp");
	$("#footer").load("footer.jsp");
});

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
function del(id) {
	//alert(id);
	$('#idDaEliminare').val(id);

}
function delProdotto(id) {
	//alert(id);
	$('#prodottoDaEliminare').val(id);

}
$(document).ready(function() {
	$("#annulla_modifica").click(function() {
		$("#terreni").show("slow");
		$("#info_terreno").hide("fast");

	});
});

$(document).ready(function() {
	$("#modificaOrtaggi").click(function() {
		$("#formModificaTerreno").hide("fast");
		$("#containerModificaOrtaggi").show("slow");
		

	});
});
$(document).ready(function() {
	$("#annulla_ortaggi").click(function() {
		$("#containerModificaOrtaggi").hide("fast");
		$("#formModificaTerreno").show("slow");

	});
});
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
$(document).ready(function() {
	$("#annulla_prodotto").click(function() {
		$("#info_prodotto").hide("fast");
		$("#prodotti").show("slow");

	});
});

function modificaOrtaggi(id) {
	$("#containerModificaOrtaggi").hide("slow");
	$("#info_terreno").hide("slow");
	$("#formModificaOrtaggio").show("slow");
	
	$("#editOrtaggioNome").val($('#listaOrtaggioNome'+id).text());
	$("#editOrtaggioResa").val($('#listaOrtaggioResa'+id).text());
	$("#editOrtaggioCosto").val($('#listaOrtaggioCosto'+id).text());
	$("#editOrtaggioTempo").val($('#listaOrtaggioTempo'+id).text());
	
	
}
$(document).ready(function() {
	$("#annulla_ortaggio").click(function() {
		$("#formModificaOrtaggio").hide("slow");
		$("#containerModificaOrtaggi").show("slow");
		$("#info_terreno").show("slow");

	});
});

function formModificaOrtaggi(){
	
}