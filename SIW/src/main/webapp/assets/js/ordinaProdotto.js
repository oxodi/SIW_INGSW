var prodotti = {
    carrello: []
};


function aggiungiAlCarrello(nome, categoria, quantita, prezzo){
	
	  prodotti.carrello.push({ 
	        "nome" : nome,
	        "categoria" : categoria,
	        "quantita" : quantita,
	        "prezzo" : prezzo
	    });
}