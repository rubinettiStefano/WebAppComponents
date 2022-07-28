class FormPostComment
{
	constructor(componentname, divid)
	{
		this.componentname 	= componentname;
		this.divid 			= divid;
		this.render();
	}
	
	render()
	{
		$("#"+this.divid).html
		(
			`
				<form>
					Author 
					<input type="text" class="w3-input" name="author" />
					Title
					<input type="text" class="w3-input" name="commenttitle" />
					Content
					<textarea name="content" class="w3-input"></textarea>
					<br />
					News id
					<input type="text" class="w3-input" name="newsid" />
					<input 
							type="button" 
							value="insert"
							class="w3-btn w3-input w3-teal"
							onClick=
							"
									let c = 
									{
										'author':author.value, 
										'title':commenttitle.value, 
										'content':content.value
									};
									//qui, this è il bottone. Lo disabilito.
									this.disabled = true;
									$.ajax
									(
										{
											type:'POST',			
											url:'../news/'+newsid.value+'/comments',
											contentType:'application/json',
											data: JSON.stringify(c),  	// Una specie di toString in JSON di city
											success:(function(data)     //Success uguale a StatusCode 200
											{
												// mi hai inserito la città? Me la hai rimandata con l'id? AGGIORNO LA MIA LISTA
												// mi aspetto che il servizio mi mandi la nuova città, con tanto di id. La aggiungo alla mia lista
												this.disabled = false;
												alert('Done');
												controller.refresh('n2');
												
											}).bind(this)
											,
											statusCode:
											{
												'400': (function(){alert('Bad request');this.disabled = false;}).bind(this),	
												'403': (function(){alert('Forbidden');this.disabled = false;}).bind(this),
												'404': (function(){alert('Not found');this.disabled = false;}).bind(this)
											}
										}
									);
							"
					/>
				</form>
			`
		);		
	}
	
	
	
}