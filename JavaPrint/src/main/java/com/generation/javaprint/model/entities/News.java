package com.generation.javaprint.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class News
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String author, title, content, datetime, image;
	
	@OneToMany(mappedBy="news", cascade=CascadeType.MERGE)
	private List<Comment> comments = new ArrayList<Comment>();
	
			
	
	public News() {}
	

	public News(int id, String author, String title, String content, String datetime, String image)
	{
		this.id = id;
		this.author = author;
		this.title = title;
		this.content = content;
		this.datetime = datetime;
		this.image = image;
	}

	public void addComment(Comment comment)
	{
		if(comments.contains(comment)) //Contains deve vedere se il parametro è già presente nella lista
									   //per capirlo deve vedere se c'è già un oggetto UGUALE nella lista 
									   //usa EQUALS
			throw new RuntimeException("Comment already present");
		
		comments.add(comment);
		comment.setNews(this);
	}
	
	public void removeComment(int commentid)
	{
		Comment toRemove=null;
		for(Comment comment : comments)
			if(comment.getId()==commentid)
			{
				toRemove=comment;
				break;
			}
		
		if(toRemove==null)
			throw new RuntimeException("Comment with id "+commentid+" not present");
		
		comments.remove(toRemove);
		toRemove.setNews(null);
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getDatetime()
	{
		return datetime;
	}

	public void setDatetime(String datetime)
	{
		this.datetime = datetime;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public List<Comment> getComments()
	{
		return comments;
	}

	public void setComments(List<Comment> comments)
	{
		this.comments = comments;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(other==null)
			return false;
		if(!(other instanceof News))
			return false;
		if(other==this || other.hashCode()==this.hashCode())
			return true;

		return false;
	}
	
	@Override
	public int hashCode()
	{
		return id;
	}
	
	
}
