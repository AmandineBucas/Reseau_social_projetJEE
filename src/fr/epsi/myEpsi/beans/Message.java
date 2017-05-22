package fr.epsi.myEpsi.beans;

import java.sql.Timestamp;

public class Message {

	private Long id;
	private String title;
	private String content;
	private User author;
	private Timestamp creationDate;
	private Timestamp updateDate;
	private int status;
	
	
	// Constructeur
	public Message(){
		super();
	}
	
	public Message(Long id, String title, String content, User author, Timestamp creationDate, Timestamp updateDate,
			int status) {
		super();
		
		// Déclaration des variables
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.status = status;
	}
	
	/*** Getter et Setter ***/
	
	// STATUS
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	// ID
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	// TITLE
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	// CONTENT
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	// AUTHOR
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	
	// CREATIONDATE
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	
	// UPDATEDATE
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String toString() {
		// affiche Message : id, content, author, creationDate, updateDate, status
		return "Message : [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author
				+ ", creationDate=" + creationDate + ", updateDate=" + updateDate + ", status=" + status + "]";
	}

	// Prend les données  stockées et les mets dans une valeur de hachage
	public int hashCode() {
		final int hash = 31;
		int result = 1;
		
		result = hash * result + ((author == null) ? 0 : author.hashCode());
		result = hash * result + ((content == null) ? 0 : content.hashCode());
		result = hash * result + ((id == null) ? 0 : id.hashCode());
		result = hash * result + status;
		result = hash * result + ((title == null) ? 0 : title.hashCode());
		
		return result;
	}

}
