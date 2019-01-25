/*$(".slides img").imgCheckbox();


$('#dynamic').on('click', function() {
	$(this).lightGallery({
		dynamic: true,
		dynamicEl: [{
			src: 'assets\img\ruotaStagioni\primavera.png',
			thumb: 'assets\img\ruotaStagioni\primavera.png',
			subHtml: '<h4>Fading Light</h4><p>Classic view from Rigwood Jetty on Coniston Water an old archive shot similar to an old post but a little later on.</p>'
		}, {
			src: 'http://placekitten.com/200/300',
			thumb: 'http://placekitten.com/200/300',
			subHtml: '<h4>Bowness Bay</h4><p>A beautiful Sunrise this morning taken En-route to Keswick not one as planned but I\'m extremely happy I was passing the right place at the right time....</p>'
		}, {
			src: 'http://placekitten.com/300/400',
			thumb: 'http://placekitten.com/300/400',
			subHtml: '<h4>Sunset Serenity</h4><p>A gorgeous Sunset tonight captured at Coniston Water....</p>'
		}, {
			src: 'http://placekitten.com/g/300/400',
			thumb: 'http://placekitten.com/g/300/400',
			subHtml: '<h4>Coniston Calmness</h4><p>Beautiful morning</p>'
		}, {
			src: 'http://placekitten.com/g/300/400',
			thumb: 'http://placekitten.com/g/300/400',
			subHtml: '<h4>Coniston Calmness</h4><p>Beautiful morning</p>'
		}]
	})
});*/


var button = "";

function changecolour() {

	console.log(button);

	if(button == 1){
		document.getElementById(button).style.background = "#cccccc";
		document.getElementById("completo").value = "true";
		document.getElementById("parziale").value = "false";
		document.getElementById(2).style.background = "#f7f3e8";

	}
	if(button == 2){
		document.getElementById(button).style.background = "#cccccc";
		document.getElementById("parziale").value = "true";	
		document.getElementById("completo").value = "false";
		document.getElementById(1).style.background = "#f7f3e8";
		

	}

}
