package com.example.demo.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="medicos")
public class Medico {
	
	@Id
	@Column
	private String nick_medico;
	@Column
	private String nombre_medico;
	@Column
	private String password_medico;
	@Column
	private String email_medico;
	@Column
	private String rol_medico;
	@Column
	private int id_especialidad;
	@Column
	private int id_localidad;
	
	public Medico() {
		
	}


	@ManyToOne
	@JoinColumn(name="id_localidad", insertable=false,updatable=false)
	private Localidad localidad;
	
	@OneToMany
	@JoinColumn(name="nick_medico",insertable = false, updatable = false)
	private List<Cita> citas;
	
	@ManyToOne
	@JoinColumn(name="id_especialidad", insertable=false,updatable=false)
	private Especialidad especialidad;

	public String getNick_medico() {
		return nick_medico;
	}


	public void setNick_medico(String nick_medico) {
		this.nick_medico = nick_medico;
	}


	public String getNombre_medico() {
		return nombre_medico;
	}


	public void setNombre_medico(String nombre_medico) {
		this.nombre_medico = nombre_medico;
	}


	public String getPassword_medico() {
		return password_medico;
	}


	public void setPassword_medico(String password_medico) {
		this.password_medico = password_medico;
	}


	public String getEmail_medico() {
		return email_medico;
	}


	public void setEmail_medico(String email_medico) {
		this.email_medico = email_medico;
	}


	public String getRol_medico() {
		return rol_medico;
	}


	public void setRol_medico(String rol_medico) {
		this.rol_medico = rol_medico;
	}


	public int getId_especialidad() {
		return id_especialidad;
	}


	public void setId_especialidad(int id_especialidad) {
		this.id_especialidad = id_especialidad;
	}


	public int getId_localidad() {
		return id_localidad;
	}


	public void setId_localidad(int id_localidad) {
		this.id_localidad = id_localidad;
	}


	public Localidad getLocalidad() {
		return localidad;
	}


	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}


	public List<Cita> getCitas() {
		return citas;
	}


	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	

	public Especialidad getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}


	@Override
	public String toString() {
		return "Medico [nick_medico=" + nick_medico + ", nombre_medico=" + nombre_medico + ", password_medico="
				+ password_medico + ", email_medico=" + email_medico + ", rol_medico=" + rol_medico
				+ ", id_especialidad=" + id_especialidad + ", id_localidad=" + id_localidad + ", localidad="
				+ localidad + ", citas=" + citas + "]";
	}


	
}
