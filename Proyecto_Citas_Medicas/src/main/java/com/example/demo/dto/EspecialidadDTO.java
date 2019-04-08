package com.example.demo.dto;

import java.util.List;

import com.example.demo.beans.Medico;

public class EspecialidadDTO {

	private int id_especialidad;
		
	private String nombre_especialidad;
	
	private List<Medico> medicos;

	public EspecialidadDTO(int id_especialidad, String nombre_especialidad, List<Medico> medicos) {
		super();
		this.id_especialidad = id_especialidad;
		this.nombre_especialidad = nombre_especialidad;
		this.medicos = medicos;
	}

	public EspecialidadDTO() {
		
	}

	public int getId_especialidad() {
		return id_especialidad;
	}

	public void setId_especialidad(int id_especialidad) {
		this.id_especialidad = id_especialidad;
	}

	public String getNombre_especialidad() {
		return nombre_especialidad;
	}

	public void setNombre_especialidad(String nombre_especialidad) {
		this.nombre_especialidad = nombre_especialidad;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	@Override
	public String toString() {
		return "EspecialidadDTO [id_especialidad=" + id_especialidad + ", nombre_especialidad=" + nombre_especialidad
				+ ", medicos=" + medicos + "]";
	}
	
		
}
