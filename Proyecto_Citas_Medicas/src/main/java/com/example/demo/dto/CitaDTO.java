package com.example.demo.dto;

import java.util.Date;

public class CitaDTO {

	
	private int id_cita;
	
	private Date fecha_cita;
	
	private String hora_cita;
	
	private String nick_medico;
	
	private String nick_paciente;

	public CitaDTO(int id_cita, Date fecha_cita, String hora_cita, String nick_medico, String nick_paciente) {
		super();
		this.id_cita = id_cita;
		this.fecha_cita = fecha_cita;
		this.hora_cita = hora_cita;
		this.nick_medico = nick_medico;
		this.nick_paciente = nick_paciente;
	}

	public CitaDTO() {
	
	}

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
	
	
}
