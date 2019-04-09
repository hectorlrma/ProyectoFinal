package com.example.demo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Cita;
import com.example.demo.beans.Paciente;
import com.example.demo.dao.PacienteRepository;
import com.example.demo.dto.CitaDTO;
import com.example.demo.dto.PacienteDTO;
import com.example.demo.interfaces.IPacienteSERVICE;

@Service
public class PacienteSERVICE implements IPacienteSERVICE {

	@Autowired
	PacienteRepository pacienteRepository;

	@Override
	public PacienteDTO buscarPacienteDTO(String nick_paciente) {
		
				Optional <Paciente> pacienteOp= pacienteRepository.findById(nick_paciente);
				
				
				if(pacienteOp.isPresent())
				{
				
					Paciente paciente = pacienteOp.get();
					List<Cita> citas = paciente.getCitas();
					List<CitaDTO> citasDTO = new ArrayList<CitaDTO>();
					for (Cita cita : citas) {
						Date fechaCita = cita.getFecha_cita();
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						String fechaCitaString = formatter.format(fechaCita);
						CitaDTO citaDTO = new CitaDTO(cita.getId_cita(),fechaCitaString,cita.getHora_cita(), cita.getNick_medico(), cita.getNick_paciente());
						citasDTO.add(citaDTO);
					}
					
					PacienteDTO pacienteDTO = new PacienteDTO(paciente.getNick_paciente(), paciente.getNombre_paciente(), paciente.getPassword_paciente(), paciente.getEmail_paciente(),
							paciente.getRol_paciente(), citasDTO);
					
					return pacienteDTO;
				}
				
				return null;
		
	}

	@Override
	public void addPacienteDTO(PacienteDTO pacienteDTO) {
		
		Paciente paciente = new Paciente();
		
		List<CitaDTO> citasDTO = pacienteDTO.getCitas();
		List<Cita> citas = new ArrayList<Cita>();
		for (CitaDTO citaDTO : citasDTO) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String fechaCitaString = citaDTO.getFecha_cita();
			Date fechaCita = new Date();
			try {
				fechaCita = formatter.parse(fechaCitaString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Cita cita = new Cita();
			cita.setId_cita(citaDTO.getId_cita());
			cita.setFecha_cita(fechaCita);
			cita.setHora_cita(citaDTO.getHora_cita());
			cita.setNick_medico(citaDTO.getNick_medico());
			cita.setNick_paciente(citaDTO.getNick_paciente());
			citas.add(cita);
		
		}
		
		paciente.setNick_paciente(pacienteDTO.getNick_paciente());
		paciente.setNombre_paciente(pacienteDTO.getNombre_paciente());
		paciente.setEmail_paciente(pacienteDTO.getEmail_paciente());
		paciente.setPassword_paciente(pacienteDTO.getPassword_paciente());
		paciente.setRol_paciente(pacienteDTO.getRol_paciente());
		paciente.setCitas(citas);
		
		pacienteRepository.save(paciente);
		
	}

	
}
