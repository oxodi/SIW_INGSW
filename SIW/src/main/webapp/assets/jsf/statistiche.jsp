<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="assets/js/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
<script >
function chartStatistiche(){ 
		
		var ctx = document.getElementById('myChart').getContext('2d');
		var chart = new Chart(ctx, {
		    // The type of chart we want to create
		    type: 'line',

		    // The data for our dataset
		    data: {
		        labels: ["Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto","Settembre"],
		        datasets: [{
		            label: "Info Terreni",
		            backgroundColor: 'rgb(255, 204, 0,.2)',
		            borderColor: 'rgb(153, 102, 0)',
		            data: [1, 10, 5, 2, 20, 30, 45, 40,10,],
		        }]
		    },

		    // Configuration options go here
		    options: {
		    	
		    }
		});
};

</script>
<title>Insert title here</title>
</head>
<body>
	<canvas id="myChart">
	</canvas>
</body>
</html>