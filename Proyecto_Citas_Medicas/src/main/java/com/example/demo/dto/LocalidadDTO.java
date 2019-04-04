package com.example.demo.dto;

import java.util.List;



import com.example.demo.beans.Medico;

public class LocalidadDTO {

	
	
	private int id_localidad;
	private String nombre_localidad;
	private List<Medico> medicos;
	
	public LocalidadDTO(int id_localidad, String nombre_localidad, List<Medico> medicos) {
		super();
		this.id_localidad = id_localidad;
		this.nombre_localidad = nombre_localidad;
		this.medicos = medicos;
	}

	public LocalidadDTO() {
		
	}

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
	
	
	
	
}
