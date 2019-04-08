package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Paciente;
import com.example.demo.dao.PacienteRepository;
import com.example.demo.interfaces.IPacienteSERVICE;

@Service
public class PacienteSERVICE implements IPacienteSERVICE {

	@Autowired
	PacienteRepository pacienteRepository;

	@Override
	public Paciente buscarPaciente(String nick_paciente) {
		
				Optional <Paciente> pacienteOp= pacienteRepository.findById(nick_paciente);
				Paciente paciente = null;
				if(pacienteOp.isPresent())
				{
					paciente = pacienteOp.get();
				}
				
				return paciente;
		
	}

	@Override
	public void addPaciente(Paciente paciente) {
		
		pacienteRepository.save(paciente);
		
	}

	
}
