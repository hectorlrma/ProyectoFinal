package com.example.demo.dto;

import java.util.List;

import com.example.demo.beans.Cita;

public class MedicoDTO {
 
	
	private String nick_medico;
	
	private String nombre_medico;
	
	private String password_medico;
	
	private String email_medico;
	
	private String rol_medico;
	
	private String especialidad_medico;
	
	private int id_localidad;
	
	private List<Cita> citas;

	public MedicoDTO(String nick_medico, String nombre_medico, String password_medico, String email_medico,
			String rol_medico, String especialidad_medico, int id_localidad) {
		super();
		this.nick_medico = nick_medico;
		this.nombre_medico = nombre_medico;
		this.password_medico = password_medico;
		this.email_medico = email_medico;
		this.rol_medico = rol_medico;
		this.especialidad_medico = especialidad_medico;
		this.id_localidad = id_localidad;
	}

	public MedicoDTO() {
		
	}

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

	public String getEspecialidad_medico() {
		return especialidad_medico;
	}

	public void setEspecialidad_medico(String especialidad_medico) {
		this.especialidad_medico = especialidad_medico;
	}

	public int getId_localidad() {
		return id_localidad;
	}

	public void setId_localidad(int id_localidad) {
		this.id_localidad = id_localidad;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	@Override
	public String toString() {
		return "MedicoDTO [nick_medico=" + nick_medico + ", nombre_medico=" + nombre_medico + ", password_medico="
				+ password_medico + ", email_medico=" + email_medico + ", rol_medico=" + rol_medico
				+ ", especialidad_medico=" + especialidad_medico + ", id_localidad=" + id_localidad + ", citas=" + citas
				+ "]";
	}
	
	
	
	
	
	
}
