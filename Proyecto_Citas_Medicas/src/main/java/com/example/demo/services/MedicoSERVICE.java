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
import com.example.demo.beans.Medico;
import com.example.demo.dao.MedicoRepository;
import com.example.demo.dto.CitaDTO;
import com.example.demo.dto.MedicoDTO;
import com.example.demo.interfaces.IMedicoSERVICE;

@Service
public class MedicoSERVICE implements IMedicoSERVICE {
	
	@Autowired
	MedicoRepository medicoRepository;

/*	@Override
	public List<MedicoDTO> buscarMedicoPorLocalidadAndByEspecialidad(int id_localidad, int id_especialidad) {
		
		
		List<Medico> lista = medicoRepository.findByLocalidadAndEspecialidad(id_localidad,id_especialidad);
		List<MedicoDTO> listaDTO = new ArrayList<MedicoDTO>();
		
		for (Medico medico : lista) {
			listaDTO.add(new MedicoDTO(medico.getNick_medico(), medico.getNombre_medico(), medico.getPassword_medico(), medico.getEmail_medico(), medico.getRol_medico(),
					    medico.getId_especialidad(), medico.getId_localidad(), medico.getCitas()));
		
		}
	
		return listaDTO;
		
	}
*/
	@Override
	public MedicoDTO buscarMedicoDTO(String nick_medico) {

		Optional <Medico> medicoOp= medicoRepository.findById(nick_medico);
		List<CitaDTO> citasDTO = new ArrayList<CitaDTO>();
		if(medicoOp.isPresent())
		{
			Medico medico = medicoOp.get();
			List<Cita> citas = medico.getCitas();
			for (Cita cita : citas) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date fechaCita = cita.getFecha_cita();
				String fechaCitaString = formatter.format(fechaCita);
			
				CitaDTO citaDTO = new CitaDTO(cita.getId_cita(), fechaCitaString, cita.getHora_cita(), cita.getNick_medico(), cita.getNick_paciente());
				citasDTO.add(citaDTO);
			}
			MedicoDTO medicoDTO = new MedicoDTO(medico.getNick_medico(), medico.getNombre_medico(), medico.getPassword_medico(), medico.getEmail_medico(), medico.getRol_medico(),
					medico.getId_especialidad(), medico.getId_localidad(),citasDTO);
			
			return medicoDTO;
		}
		
		return null;
		
	}

	@Override
	public void addMedicoDTO(MedicoDTO medicoDTO) {
	
		Medico medico = new Medico();
		
		List<CitaDTO> citasDTO = medicoDTO.getCitas();
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
		
		medico.setNick_medico(medicoDTO.getNick_medico());
		medico.setNombre_medico(medicoDTO.getNombre_medico());
		medico.setPassword_medico(medicoDTO.getPassword_medico());
		medico.setEmail_medico(medicoDTO.getEmail_medico());
		medico.setRol_medico(medicoDTO.getRol_medico());
		medico.setId_localidad(medicoDTO.getId_localidad());
		medico.setEmail_medico(medicoDTO.getEmail_medico());
		medico.setId_especialidad(medicoDTO.getId_Especialidad());
		medico.setCitas(citas);
		
		medicoRepository.save(medico);
		
		
	}

	@Override
	public List<MedicoDTO> findByLocalidadAndEspecialidad2(int id_localidad, int id_espcialidad) {
		Optional<List<Medico>> medicosOpt = medicoRepository.findByLocalidadAndEspecialidad2(id_localidad, id_espcialidad);
		List<MedicoDTO> medicosDTO = new ArrayList<MedicoDTO>();
		List<CitaDTO> citasDTO = new ArrayList<CitaDTO>();
		if (medicosOpt.isPresent()){
			List<Medico> medicosList = medicosOpt.get();
			for (Medico medico : medicosList) {
				List<Cita> citas = medico.getCitas();
				for (Cita cita : citas) {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date fechaCita = cita.getFecha_cita();
					String fechaCitaString = formatter.format(fechaCita);
				
					CitaDTO citaDTO = new CitaDTO(cita.getId_cita(), fechaCitaString, cita.getHora_cita(), cita.getNick_medico(), cita.getNick_paciente());
					citasDTO.add(citaDTO);
				}
				MedicoDTO medicoDTO = new MedicoDTO(medico.getNick_medico(), medico.getNombre_medico(),
				medico.getPassword_medico(), medico.getEmail_medico(), medico.getRol_medico(), 
				medico.getId_localidad(), medico.getId_localidad(), citasDTO);
				medicosDTO.add(medicoDTO);
			}
		}
		System.out.println("anuncio: "+medicosDTO);
		return medicosDTO;
	}


}
