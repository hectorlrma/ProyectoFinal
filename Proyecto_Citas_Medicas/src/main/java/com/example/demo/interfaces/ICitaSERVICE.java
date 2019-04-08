package com.example.demo.interfaces;



import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.example.demo.beans.Cita;
import com.example.demo.dto.CitaDTO;

public interface ICitaSERVICE {

	public List <CitaDTO> buscarCitaPorMedico(String nick_medico);
	
	public List <CitaDTO> buscarCitaPorPaciente(String nick_paciente);
	
	public void altaCita (CitaDTO citaDTO);
	
	public void borrarCita (int id_cita);
	
	public void modificarCita(CitaDTO citaDTO);
	
	public Date getFechaDia() throws ParseException;
}
