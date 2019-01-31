function Azienda(id) {
	this.id = id;
}

function mostraTerreno(idAzienda){
	var a = {
			id : azienda.id,
	}
	
	$.ajax({
		type: "GET",
		url: "DammiTerreno",
		datatype: "json",
		data: JSON.stringify(stud),
		success: function(data){
			var terreni = JSON.parse(data);
			$("#divSceltaTerreno").text(terreni.id);
			
		}
	});
	
}