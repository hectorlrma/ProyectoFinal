package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.beans.Medico;
import com.example.demo.dto.MedicoDTO;

public interface IMedicoSERVICE {

	//public List <MedicoDTO> buscarMedicoPorLocalidad(int id_localidad);
	
	public Medico buscarMedico(String nick_medico);
	
	public void addMedico (Medico medico);

	List<MedicoDTO> buscarMedicoPorLocalidadAndByEspecialidad(int id_localidad, int id_espcialidad);
	
	
	
}
