// $ -> jQuery, o "SELETTORE". Libreria o modo per prendere parti del DOM
// $(document) -> SELEZIONA l'intera pagina
// $(document).ready -> GESTORE DI EVENTO. VIENE ESEGUITO QUANDO TUTTA LA PAGINA E' STATA CARICATA
// HO GIA' TUTTO L'HTML QUI!
// function() - > CALLBACK CHE VIENE ESEGUITA QUANDO LA PAGINA E' STATA CARICATA 
// CUORE DI JQUERY. BLOCCO DI INIZIALIZZAZIONE DELLA PAGINA! IO QUI INIZIALIZZO I MIEI COMPONENTI
var controller = 
{
	components:[],
	refresh:function(componentname)
	{
		for(let i=0;i<controller.components.length;i++)
			if(controller.components[i].componentname==componentname)
				controller.components[i].render(true);		
	}
	
}


$(document).ready(function()
{
	// ho appena creato una proprietà in un oggetto vuoto
	controller.components.push(new NewsBlock("n1", "block1"));
	controller.components.push(new CommentsBlock("n2", "block2"));
	controller.components.push(new FormPostComment("n3", "leavecomment"));
	
	
	
	
});