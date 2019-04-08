package com.example.demo.interfaces;

import com.example.demo.beans.Paciente;

public interface IPacienteSERVICE {

	public Paciente buscarPaciente(String nick_paciente);
	
	public void addPaciente(Paciente paciente);

}
