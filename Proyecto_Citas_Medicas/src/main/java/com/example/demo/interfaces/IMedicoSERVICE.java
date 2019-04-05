package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.dto.MedicoDTO;

public interface IMedicoSERVICE {

	public List <MedicoDTO> buscarMedicoPorLocalidad(int id_localidad);
	
	
	
}
