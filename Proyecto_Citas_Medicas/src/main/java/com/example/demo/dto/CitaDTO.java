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
	
	
}
