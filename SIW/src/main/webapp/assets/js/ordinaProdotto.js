var prodotti = {
    carrello: []
};


function aggiungiAlCarrello(nome, categoria, quantita, prezzo, azienda){
	
	  prodotti.carrello.push({ 
	        "nome" : nome,
	        "categoria" : categoria,
	        "quantita" : quantita,
	        "prezzo" : prezzo,
	        "azienda" : azienda
	    });
	  
}

function visualizzaCarrello(){
	$('#divScegliProdotti').hide('slow');
	$('#divCarrello').show('slow');
	
	
	var body = document.getElementById('body');
	alert("sono fuori dal for");
	
	for(var i = 0; i<prodotti.carrello.length; i++){
		alert("Sono nel for");
		var $row = $(  "<tr> <td>" +
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
						"<td><select class='form-control'>"+
						"<option>1</option>"+
						"<option>2</option>"+
						"<option>3</option>"+
						"<option>4</option>"+
						"</select></td>"+
						"<td>"+
						"<div class='price-wrap'>"+
						"<var class='price'>USD 145</var>"+
						"<small class='text-muted'>(USD5 each)</small>"+
						"</div>" +
						"</td>" +
						"<td class='text-right'><a href='' class='btn btn-outline-danger'> × Rimuovi</a></td>"+
						"</tr>"
				
		);
		
		$(body).append($row);
	
	}





	



}
