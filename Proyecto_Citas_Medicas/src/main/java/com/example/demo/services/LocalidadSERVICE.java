package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Localidad;
import com.example.demo.dao.LocalidadRepository;
import com.example.demo.dto.LocalidadDTO;
import com.example.demo.interfaces.ILocalidadSERVICE;

@Service
public class LocalidadSERVICE implements ILocalidadSERVICE {
	
	@Autowired
	LocalidadRepository localidadRepository;

	@Override
	public List<LocalidadDTO> listarLocalidades() {
		
		List<LocalidadDTO> listaDTO = new ArrayList<LocalidadDTO>();		
		Iterable<Localidad> localidades = localidadRepository.findAll();
		
		for (Localidad loc : localidades) {
			LocalidadDTO localidadDTO = new LocalidadDTO(loc.getId_localidad(), loc.getNombre_localidad(), loc.getMedicos());
			listaDTO.add(localidadDTO);
		}
		return listaDTO;
	}
}
