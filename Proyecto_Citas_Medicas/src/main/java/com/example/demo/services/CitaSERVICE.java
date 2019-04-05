package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Cita;
import com.example.demo.beans.Medico;
import com.example.demo.dao.CitaRepository;
import com.example.demo.dto.CitaDTO;
import com.example.demo.interfaces.ICitaSERVICE;

@Service
public class CitaSERVICE implements ICitaSERVICE {

	
	@Autowired
	CitaRepository citaRepository;
	
	@Override
	public List<CitaDTO> buscarCitaPorMedico(String nick_medico) {
		
		Medico medico;
		List<Cita> citas = citaRepository.findByMedico(nick_medico);
		
		
		
		return null;
		
	}
	
}
