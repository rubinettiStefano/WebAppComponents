package com.generation.javaprint.model.entities;

import java.time.LocalDateTime;


public class NewsFactory
{

	public static News makeRandom()
	{
		News n = new News();
		n.setTitle("Random Title "+((int)(Math.random()*1000000)));
		n.setAuthor("Admin");
		n.setContent(_generateLoremIpsum());
		n.setDatetime(getNow());
		n.setImage("/img/randomimage1.png");
		
		return n;
	}

	public static String getNow()
	{
		String res="";
		LocalDateTime now = LocalDateTime.now();
		
		int day = now.getDayOfMonth();
		int month = now.getMonthValue();
		int year = now.getYear();
		res+= day>=10 ? day : "0"+day;
		res+="/"+ (month>=10 ? month : "0"+month);
		res+="/"+year;
		res+= " "+now.toLocalTime().toString();
		return res;
	}

	private static String _generateLoremIpsum()
	{
		String lorem = "\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"\n"
				+ "\n"
				+ "Section 1.10.32 of \"de Finibus Bonorum et Malorum\", written by Cicero in 45 BC\n"
				+ "\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\"";
		String res = "";
		
		for(int i=0;i<Math.random()*4;i++)
			res+="<p>"+lorem+"</p>";
		
		return res;
	}
	
	
	
	
	
}
