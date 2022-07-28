class NewsBlock
{
	constructor(componentname, targetdiv)
	{
		this.componentname = componentname;
		this.targetdiv = targetdiv;
		this.news = [];
		this.render();
	}
	
	// Di cosa ho bisogno io? Dei miei dati, delle news
					
	// singola news				
	renderNews(news)
	{
		let splitted =news.content.split('\n');
		let formatted=""
		for(let par of splitted)
		{
			if(par!="")
			{
				formatted+=`<p>${par}</p>`;		
			}
		}
		return `
				<div class=news>
					<h3>${news.title}</h3> 
					<h4>Author:${news.author} - ${news.datetime}
					<div class=content>
						${formatted} 
					</div>
				</div>
			 `;
	}
	
	renderNewsBlock(newsblock)
	{
		let res = ``;
		for(let i=0;i<newsblock.length;i++)
			res+=this.renderNews(newsblock[i]);					
		
		return res;
		
	}
	
	render()
	{
		if(this.news.length==0)
			$.getJSON
			(
				"../news",			// CHIAMO URI
									// CALLBACK E VIENE ESEGUITA QUANDO IL SERVER RISPONDE
				(function(data)		//data=Il body della Response
				{
					// METTO IN CACHE!!
					this.news = data;
					$("#"+this.targetdiv).html(this.renderNewsBlock(data));
				}).bind(this)
			);
		else
			$("#"+this.targetdiv).html(this.renderNewsBlock(this.news));
	}
}