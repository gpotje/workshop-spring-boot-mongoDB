package com.gpotgames.curso.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gpotgames.curso.dto.AuthorDTO;
import com.gpotgames.curso.dto.CommentDTO;

@Document
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO autor;
	
	private List<CommentDTO> comment = new ArrayList<>();
	
	public List<CommentDTO> getComment() {
		return comment;
	}

	public void setComment(List<CommentDTO> comment) {
		this.comment = comment;
	}

	public Post() {}
	
	public Post(String id, Date date2, String title, String body,AuthorDTO autor) {
		super();
		this.id = id;
		this.date = date2;
		this.title = title;
		this.body = body;
		this.autor = autor;
	}



	public AuthorDTO getAutor() {
		return autor;
	}

	public void setAutor(AuthorDTO autor) {
		this.autor = autor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}
