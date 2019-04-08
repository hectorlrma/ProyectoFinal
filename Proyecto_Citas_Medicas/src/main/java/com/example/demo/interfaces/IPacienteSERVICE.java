package com.example.demo.interfaces;

import java.util.Date;

import com.example.demo.beans.Paciente;
import com.example.demo.dto.PacienteDTO;

public interface IPacienteSERVICE {

	public PacienteDTO buscarPaciente(String nick_paciente);
	
	public void addPaciente(Paciente paciente);
	

}
