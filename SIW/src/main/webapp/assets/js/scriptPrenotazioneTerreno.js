var button = "";

function changecolour() {

	console.log(button);

	if(button == 1){
		document.getElementById(button).style.background = "#cccccc";
		document.getElementById(3).style.background = "#cccccc";
		document.getElementById("completo").value = "true";
		document.getElementById("parziale").value = "false";
		document.getElementById(2).style.background = "#f7f3e8";
		document.getElementById(4).style.background = "#f7f3e8";

	}
	if(button == 2){
		document.getElementById(button).style.background = "#cccccc";
		document.getElementById(4).style.background = "#cccccc";
		document.getElementById("parziale").value = "true";	
		document.getElementById("completo").value = "false";
		document.getElementById(1).style.background = "#f7f3e8";
		document.getElementById(3).style.background = "#f7f3e8";
		

	}

}
