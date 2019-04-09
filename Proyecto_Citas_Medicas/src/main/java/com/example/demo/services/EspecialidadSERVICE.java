package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Especialidad;
import com.example.demo.beans.Localidad;
import com.example.demo.dao.EspecialidadRepository;
import com.example.demo.dto.EspecialidadDTO;
import com.example.demo.dto.LocalidadDTO;
import com.example.demo.interfaces.IEspecialidadSERVICE;

@Service
public class EspecialidadSERVICE implements IEspecialidadSERVICE {

	@Autowired
	EspecialidadRepository especialidadRepository;

	@Override
	public List<EspecialidadDTO> listarEspecialidades() {
		List<EspecialidadDTO> listaDTO = new ArrayList<EspecialidadDTO>();		
		Iterable<Especialidad> especialidades = especialidadRepository.findAll();
		
		for (Especialidad esp : especialidades) {
			EspecialidadDTO especialidadDTO = new EspecialidadDTO(esp.getId_especialidad(),esp.getNombre_especialidad(),esp.getMedicos());
			listaDTO.add(especialidadDTO);
			System.out.println(especialidadDTO);
		}
		return listaDTO;
	}

	@Override
	public EspecialidadDTO buscarLocalidadDTO(int id_especialidad) {
		Optional<Especialidad> especialidadOp = especialidadRepository.findById(id_especialidad);
		
		if(especialidadOp.isPresent()) {
			Especialidad especialidad = especialidadOp.get();
			EspecialidadDTO especialidadDTO = new EspecialidadDTO(especialidad.getId_especialidad(), especialidad.getNombre_especialidad(), especialidad.getMedicos());
			
			return especialidadDTO;
		}
		
		return null;
	}
}
