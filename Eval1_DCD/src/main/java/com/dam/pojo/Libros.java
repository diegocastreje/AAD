package com.dam.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Libros {
	@Id
	private String isbn;
	@Column
	private String titulo;
	@Column
	private String editorial;
	@Column
	private int CodAutor;
	
	public Libros(String isbn, String titulo, String editorial, int codAutor) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.editorial = editorial;
		CodAutor = codAutor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getCodAutor() {
		return CodAutor;
	}

	public void setCodAutor(int codAutor) {
		CodAutor = codAutor;
	}
	
	

}
