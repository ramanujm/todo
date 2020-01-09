/**
 * 
 */
package com.todo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author Ramanujm
 *
 */
@Entity
@Table(name="todo")
@JsonAutoDetect

public class Todo {

	/**
	 * Default Constructor
	 */
	public Todo() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="title", nullable = false, length = 50)
	private String title;
	
	@Column(name="completed")
	private boolean completed;
	
	@Column(name="created_on")
	private Date createdOn = new Date();

	/**
	 * @param id
	 * @param title
	 * @param description
	 * @param complete
	 * @param todoCreated
	 */
	public Todo(Long id, String title, boolean completed, Date createdOn) {
		super();
		this.id = id;
		this.title = title;
		this.completed = completed;
		this.createdOn = createdOn;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the complete
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * @param complete the complete to set
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", completed=" + completed + ", createdOn=" + createdOn + "]";
	}

	
	
}
