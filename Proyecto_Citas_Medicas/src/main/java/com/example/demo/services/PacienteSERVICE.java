package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Paciente;
import com.example.demo.dao.PacienteRepository;
import com.example.demo.dto.PacienteDTO;
import com.example.demo.interfaces.IPacienteSERVICE;

@Service
public class PacienteSERVICE implements IPacienteSERVICE {

	@Autowired
	PacienteRepository pacienteRepository;

	@Override
	public PacienteDTO buscarPaciente(String nick_paciente) {
		
				Optional <Paciente> pacienteOp= pacienteRepository.findById(nick_paciente);
				
				
				if(pacienteOp.isPresent())
				{
					Paciente paciente = pacienteOp.get();
					PacienteDTO pacienteDTO = new PacienteDTO(paciente.getNick_paciente(), paciente.getNombre_paciente(), paciente.getPassword_paciente(), paciente.getEmail_paciente(),
							paciente.getRol_paciente(), paciente.getCitas());
					
					return pacienteDTO;
				}
				
				return null;
		
	}

	@Override
	public void addPaciente(Paciente paciente) {
		
		pacienteRepository.save(paciente);
		
	}

	
}
