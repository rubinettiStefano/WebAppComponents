class CommentsBlock
{
	constructor(componentname, targetdiv)
	{
		this.componentname = componentname;
		this.targetdiv = targetdiv;
		this.render();
	}
	
	// Di cosa ho bisogno io? Dei miei dati, delle news
					
	
	render()
	{
		// questa è una SCORCIATOIA PER AJAX!
		// questo chiama .ajax dietro le quinte
		$.getJSON
		(
			"../comments",			// CHIAMO URI
								// CALLBACK E VIENE ESEGUITA QUANDO IL SERVER RISPONDE
			(function(data)		
			{
				let res = "";
				for(let i=0;i<data.length;i++)
				{
					let comment = data[i];
					res+=`
							<div class=news>
								<h3>${comment.title}</h3> <br/>
								
								${comment.content} <br/>
								<span style="font-size:70%">Author: ${comment.author}</span>
							</div>
						  `;
				}
				$("#"+this.targetdiv).html(res);
			}).bind(this)
		);	
		
	}
}