package com.example.demo.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="especialidades")
public class Especialidad {
	
	@Id
	@Column
	private int id_especialidad;
	
	@Column
	private String nombre_especialidad;
	
	private String nick_medico;
	
	@OneToMany
	@JoinColumn(name="id_especialidad",insertable = false, updatable = false)
	private List<Medico> medicos;

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

	public String getNick_medico() {
		return nick_medico;
	}

	public void setNick_medico(String nick_medico) {
		this.nick_medico = nick_medico;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	@Override
	public String toString() {
		return "Especialidad [id_especialidad=" + id_especialidad + ", nombre_especialidad=" + nombre_especialidad
				+ ", nick_medico=" + nick_medico + ", medicos=" + medicos + "]";
	}
	
	
}
