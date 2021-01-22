package com.dam.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Departamentos {

	@Id
	private int id;
	@Column
	private String nombre;
	@Column
	private String region;
	
	public Departamentos(int id, String nombre, String region) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.region = region;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	

}
