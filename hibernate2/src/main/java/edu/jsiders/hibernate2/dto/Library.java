package edu.jsiders.hibernate2.dto;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = true,unique=true)
	private String name;
	@Column(nullable = true,unique=false)
	private String location;
	
	@ManyToMany
	private Collection<Book> books;
}
