package com.example.demo.dto;

import java.util.List;

import com.example.demo.beans.Cita;

public class PacienteDTO {
	
	private String nick_paciente;

	private String nombre_paciente;
	
	private String password_paciente;
	
	private String email_paciente;
	
	private String rol_paciente;
	
	private List<Cita> citas;

	public PacienteDTO(String nick_paciente, String nombre_paciente, String password_paciente, String email_paciente,
			String rol_paciente, List<Cita> citas) {
		super();
		this.nick_paciente = nick_paciente;
		this.nombre_paciente = nombre_paciente;
		this.password_paciente = password_paciente;
		this.email_paciente = email_paciente;
		this.rol_paciente = rol_paciente;
		this.citas = citas;
	}

	public PacienteDTO() {
		
	}

	public String getNick_paciente() {
		return nick_paciente;
	}

	public void setNick_paciente(String nick_paciente) {
		this.nick_paciente = nick_paciente;
	}

	public String getNombre_paciente() {
		return nombre_paciente;
	}

	public void setNombre_paciente(String nombre_paciente) {
		this.nombre_paciente = nombre_paciente;
	}

	public String getPassword_paciente() {
		return password_paciente;
	}

	public void setPassword_paciente(String password_paciente) {
		this.password_paciente = password_paciente;
	}

	public String getEmail_paciente() {
		return email_paciente;
	}

	public void setEmail_paciente(String email_paciente) {
		this.email_paciente = email_paciente;
	}

	public String getRol_paciente() {
		return rol_paciente;
	}

	public void setRol_paciente(String rol_paciente) {
		this.rol_paciente = rol_paciente;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	@Override
	public String toString() {
		return "PacienteDTO [nick_paciente=" + nick_paciente + ", nombre_paciente=" + nombre_paciente
				+ ", password_paciente=" + password_paciente + ", email_paciente=" + email_paciente + ", rol_paciente="
				+ rol_paciente + ", citas=" + citas + "]";
	}
	
	
	
	

}
