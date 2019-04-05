package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.beans.Medico;
import com.example.demo.dao.MedicoRepository;
import com.example.demo.dto.MedicoDTO;
import com.example.demo.interfaces.IMedicoSERVICE;

@Service
public class MedicoSERVICE implements IMedicoSERVICE {
	
	@Autowired
	MedicoRepository medicoRepository;

	@Override
	public List<MedicoDTO> buscarMedicoPorLocalidad(int id_localidad) {
		
		List<Medico> lista = medicoRepository.findByLocalidad(id_localidad);
		List<MedicoDTO> listaDTO = new ArrayList<MedicoDTO>();
		
		for (Medico medico : lista) {
			listaDTO.add(new MedicoDTO(medico.getNick_medico(), medico.getNombre_medico(), medico.getPassword_medico(), medico.getEmail_medico(), medico.getRol_medico(),
					    medico.getEspecialidad_medico(), medico.getId_localidad()));
		
		}
	
		return listaDTO;
	
	}



}
