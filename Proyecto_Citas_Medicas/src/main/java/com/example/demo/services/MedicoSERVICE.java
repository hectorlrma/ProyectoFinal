package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public List<MedicoDTO> buscarMedicoPorLocalidadAndByEspecialidad(int id_localidad, int id_especialidad) {
		
		
		List<Medico> lista = medicoRepository.findByLocalidadAndEspecialidad(id_localidad,id_especialidad);
		List<MedicoDTO> listaDTO = new ArrayList<MedicoDTO>();
		
		for (Medico medico : lista) {
			listaDTO.add(new MedicoDTO(medico.getNick_medico(), medico.getNombre_medico(), medico.getPassword_medico(), medico.getEmail_medico(), medico.getRol_medico(),
					    medico.getId_especialidad(), medico.getId_localidad()));
		
		}
	
		return listaDTO;
		
	}

	@Override
	public MedicoDTO buscarMedicoDTO(String nick_medico) {

		Optional <Medico> medicoOp= medicoRepository.findById(nick_medico);
		if(medicoOp.isPresent())
		{
			Medico medico = medicoOp.get();
			MedicoDTO medicoDTO = new MedicoDTO(medico.getNick_medico(), medico.getNombre_medico(), medico.getPassword_medico(), medico.getEmail_medico(), medico.getRol_medico(),
					medico.getId_especialidad(), medico.getId_localidad());
			
			return medicoDTO;
		}
		
		return null;
		
	}

	@Override
	public void addMedicoDTO(MedicoDTO medicoDTO) {
	
		Medico medico = new Medico();
		
		medico.setNick_medico(medicoDTO.getNick_medico());
		medico.setNombre_medico(medicoDTO.getNombre_medico());
		medico.setPassword_medico(medicoDTO.getPassword_medico());
		medico.setEmail_medico(medicoDTO.getEmail_medico());
		medico.setRol_medico(medicoDTO.getRol_medico());
		medico.setId_localidad(medicoDTO.getId_localidad());
		medico.setEmail_medico(medicoDTO.getEmail_medico());
		medico.setId_especialidad(medicoDTO.getId_Especialidad());
		medico.setCitas(medicoDTO.getCitas());
		
		medicoRepository.save(medico);
		
		
	}



}
