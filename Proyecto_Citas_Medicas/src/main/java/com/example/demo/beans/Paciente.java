package com.example.demo.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pacientes")
public class Paciente {
	
	@Id
	@Column
	private String nick_paciente;
	@Column
	private String nombre_paciente;
	@Column
	private String password_paciente;
	@Column
	private String email_paciente;
	@Column
	private int rol_paciente;
	
	@OneToMany
	@JoinColumn(name="nick_paciente",insertable = false, updatable = false)
	private List<Cita> citas;

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

	public int getRol_paciente() {
		return rol_paciente;
	}

	public void setRol_paciente(int rol_paciente) {
		this.rol_paciente = rol_paciente;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	
	
}
