package com.example.demo.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="localidades")
public class Localidad {
	
	@Id
	@Column
	private int id_localidad;
	@Column
	private String nombre_localidad;
	
	@OneToMany
	@JoinColumn(name="id_localidad",insertable = false, updatable = false)
	private List<Medico> medicos;

	public int getId_localidad() {
		return id_localidad;
	}

	public void setId_localidad(int id_localidad) {
		this.id_localidad = id_localidad;
	}

	public String getNombre_localidad() {
		return nombre_localidad;
	}

	public void setNombre_localidad(String nombre_localidad) {
		this.nombre_localidad = nombre_localidad;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	@Override
	public String toString() {
		return "Localidad [id_localidad=" + id_localidad + ", nombre_localidad=" + nombre_localidad + "]";
	}

	

	
}
