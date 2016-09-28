$(function(){

	console.log("Loading pizzas");
	
	function loadPizzas(){
	
		$.getJSON("/api/pizzas/", function( pizzas ){
			console.log(pizzas);
			var pizza = "Margherita";
			if( pizzas.length > 0) {
			
				message = pizzas[0].toppings[0];
				for(var i = 1; i < pizzas[0].toppings.length; i++){
				
					message += " " + pizzas[0].toppings[i];
					
				}
				
			}
			$(".intro-text").text(message);
		
		});
	
	};
	
	setInterval(loadPizzas, 2000);

});