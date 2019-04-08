package com.example.demo.interfaces;

import java.util.Date;
import java.util.List;

import com.example.demo.beans.Medico;
import com.example.demo.dto.MedicoDTO;

public interface IMedicoSERVICE {

	//public List <MedicoDTO> buscarMedicoPorLocalidad(int id_localidad);
	
	public MedicoDTO buscarMedico(String nick_medico);
	
	public void addMedico (Medico medico);

	List<MedicoDTO> buscarMedicoPorLocalidadAndByEspecialidad(int id_localidad, int id_espcialidad);
	
	
	
	
}
