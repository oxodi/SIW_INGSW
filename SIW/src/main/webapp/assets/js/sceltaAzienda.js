function mostraTerreno(idAzienda){
	$.ajax({
		type: "GET",
		url: "DammiTerreno",
		data: {idAz : idAzienda},
		success: function(data){
			$("#land").empty();
			$("#land").load("sceltaTerreno.jsp");
		}
	});
}