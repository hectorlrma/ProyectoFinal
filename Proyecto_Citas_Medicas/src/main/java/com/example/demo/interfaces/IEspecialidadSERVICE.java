package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.dto.EspecialidadDTO;
import com.example.demo.dto.LocalidadDTO;

public interface IEspecialidadSERVICE {

	public List<EspecialidadDTO> listarEspecialidades();
	
	public EspecialidadDTO buscarEspecialidadDTO(int id_especialidad);
	
	
}
