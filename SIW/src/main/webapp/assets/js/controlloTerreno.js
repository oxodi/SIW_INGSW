$(function(){
	$(".input-column").blur(function(){
		var x=this.value;
		$(this).next(".error-message").remove();
		if(x===""){
			
			$("<span class=\"error-message\" style=\"color:red\">Non puo essere vuoto </span>").insertAfter(this);
			$("#submit").remove();
		}
		else{
			controllaForm();
		}
	});
});
