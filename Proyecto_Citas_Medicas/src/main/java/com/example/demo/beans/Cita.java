package com.example.demo.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="citas")
public class Cita {
	
	@Id
	@Column
	private int id_cita;
	@Column
	private Date fecha_cita;
	@Column
	private String hora_cita;
	@Column
	private String nick_medico;
	@Column
	private String nick_paciente;
	
	@ManyToOne
	@JoinColumn(name="nick_medico",insertable = false, updatable = false)
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name="nick_paciente",insertable = false, updatable = false)
	private Paciente paciente;

	public int getId_cita() {
		return id_cita;
	}

	public void setId_cita(int id_cita) {
		this.id_cita = id_cita;
	}

	public Date getFecha_cita() {
		return fecha_cita;
	}

	public void setFecha_cita(Date fecha_cita) {
		this.fecha_cita = fecha_cita;
	}

	public String getHora_cita() {
		return hora_cita;
	}

	public void setHora_cita(String hora_cita) {
		this.hora_cita = hora_cita;
	}

	public String getNick_medico() {
		return nick_medico;
	}

	public void setNick_medico(String nick_medico) {
		this.nick_medico = nick_medico;
	}

	public String getNick_paciente() {
		return nick_paciente;
	}

	public void setNick_paciente(String nick_paciente) {
		this.nick_paciente = nick_paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Cita [id_cita=" + id_cita + ", fecha_cita=" + fecha_cita + ", hora_cita=" + hora_cita + ", nick_medico="
				+ nick_medico + ", nick_paciente=" + nick_paciente + ", medico=" + medico + ", paciente=" + paciente
				+ "]";
	}
	
	
	
}
