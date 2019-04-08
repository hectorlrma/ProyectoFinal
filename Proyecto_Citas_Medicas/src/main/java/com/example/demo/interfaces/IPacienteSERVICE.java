package com.example.demo.interfaces;

import com.example.demo.dto.PacienteDTO;

public interface IPacienteSERVICE {

	public PacienteDTO buscarPaciente(String nick_paciente);
	
	public void addPaciente(PacienteDTO pacienteDTO);
	

}
