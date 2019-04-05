package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.beans.Cita;
import com.example.demo.dao.CitaRepository;
import com.example.demo.dto.CitaDTO;
import com.example.demo.interfaces.ICitaSERVICE;

@Service
public class CitaSERVICE implements ICitaSERVICE {

	
	@Autowired
	CitaRepository citaRepository;
	
	@Override
	public List<CitaDTO> buscarCitaPorMedico(String nick_medico) {
		
		
		List<Cita> lista = citaRepository.findByMedico(nick_medico);
		List<CitaDTO> listaDTO = new ArrayList<CitaDTO>();
		
		for (Cita cita : lista) {
			listaDTO.add(new CitaDTO(cita.getId_cita(),cita.getFecha_cita(),cita.getHora_cita(),cita.getNick_medico(),cita.getNick_paciente()));
		}
		
				
		return listaDTO;
		
	}

	@Override
	public List<CitaDTO> buscarCitaPorPaciente(String nick_paciente) {
		
		List<Cita> lista = citaRepository.findByPaciente(nick_paciente);
		List<CitaDTO> listaDTO = new ArrayList<CitaDTO>();
		
		for (Cita cita : lista) {
			listaDTO.add(new CitaDTO(cita.getId_cita(),cita.getFecha_cita(),cita.getHora_cita(),cita.getNick_medico(),cita.getNick_paciente()));
		}
		
				
		return listaDTO;
	}

	@Override
	public void altaCita(Cita cita) {
		
		citaRepository.save(cita);
	}

	@Override
	public void borrarCita(int id_cita) {
		
		citaRepository.deleteById(id_cita);
		
	}

	
	
	
	
	
}
