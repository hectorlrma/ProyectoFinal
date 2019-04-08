package com.example.demo.interfaces;

import com.example.demo.dto.PacienteDTO;

public interface IPacienteSERVICE {

	public PacienteDTO buscarPacienteDTO(String nick_paciente);
	
	public void addPacienteDTO(PacienteDTO pacienteDTO);
	

}
