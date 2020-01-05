/**
 * 
 */
package com.todo.entity;

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
	
	@Column(name="complete")
	private boolean complete;

	/**
	 * @param id
	 * @param title
	 * @param complete
	 */
	public Todo(Long id, String title, boolean complete) {
		super();
		this.id = id;
		this.title = title;
		this.complete = complete;
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
	public boolean isComplete() {
		return complete;
	}

	/**
	 * @param complete the complete to set
	 */
	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", complete=" + complete + "]";
	}
	
	

}
