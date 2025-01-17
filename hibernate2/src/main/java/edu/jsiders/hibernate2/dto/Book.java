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
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,unique = true)
	private String name;
	@Column(nullable = false,unique = false)
	private String author;
	@Column(nullable = false,unique = false)
	private double price;
	
	@ManyToMany(mappedBy = "books")
	private Collection<Library> libraries;
	
}
