package com.samgreen.bookClub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")

	public class Book {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    
	    @NotBlank(message="Please enter a title")
	    private String title;
		
	    
	    @NotBlank(message="Please enter an author")
	    private String author;
		
	    @NotBlank(message="Please write a short description")
	    private String description;
	    
		
	    @Column(updatable=false)
	    @DateTimeFormat(pattern = "yyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern = "yyy-MM-dd")
	    private Date updatedAt;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User user;
	    
	    public Book() {
	        
	    }
//	    
//	    public Book(Long id, String title, String author, String description, Date createdAt, Date updatedAt, User user) {
//	    	this.id = id;
//    	this.title = title;;
//    	this.author = author;
//	    	this.description = description;
//	    	this.createdAt = createdAt;
//	    	this.updatedAt = updatedAt;
//	    	this.user = user;
//	    }
	    
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
	    

}