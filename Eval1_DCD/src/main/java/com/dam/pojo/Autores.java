package com.dam.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Autores {
	@Id
	private int codigo;
	@Column
	private String nombre;
	@Column
	private String pais;
	
	public Autores(int codigo, String nombre, String pais) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.pais = pais;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	
}
