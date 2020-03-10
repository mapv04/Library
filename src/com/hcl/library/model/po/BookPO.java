package com.hcl.library.model.po;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity(name="BookPO")
@Table(name = "book")
public class BookPO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String edition;
	
	@Column
	private String editorial;
		
	@Column 
	private String category;
	
	@Column
	private String language;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "book_author", 
				joinColumns = @JoinColumn(name = "id_book"), 
				inverseJoinColumns = @JoinColumn(name = "id_author"))
	private List<AuthorPO> authors = new ArrayList<>();
	
	@ManyToMany(mappedBy="books")
	private List<LoanPO> loans = new ArrayList<>();
	
	
	public BookPO() {
		
	}
	
	public BookPO(String name, String edition, String editorial, String category, String language) {
		super();
		this.name = name;
		this.edition = edition;
		this.editorial = editorial;
		this.category = category;
		this.language = language;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<AuthorPO> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorPO> authors) {
		this.authors = authors;
	}

	public List<LoanPO> getLoans() {
		return loans;
	}

	public void setLoans(List<LoanPO> loans) {
		this.loans = loans;
	}

	
	
	
}
