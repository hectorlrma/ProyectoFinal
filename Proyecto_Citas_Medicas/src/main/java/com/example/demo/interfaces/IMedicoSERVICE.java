package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.demo.beans.Medico;
import com.example.demo.dto.MedicoDTO;

public interface IMedicoSERVICE {

	//public List <MedicoDTO> buscarMedicoPorLocalidad(int id_localidad);
	
	public MedicoDTO buscarMedicoDTO(String nick_medico);
	
	public void addMedicoDTO (MedicoDTO medicoDTO);

//	List<MedicoDTO> buscarMedicoPorLocalidadAndByEspecialidad(int id_localidad, int id_espcialidad);

	List<MedicoDTO> findByLocalidadAndEspecialidad2(int id_localidad, int id_especialidad);
	
	
	
	
}
