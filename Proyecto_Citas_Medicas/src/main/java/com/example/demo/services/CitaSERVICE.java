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
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaCita = cita.getFecha_cita();
			String fechaCitaString = formatter.format(fechaCita);
			listaDTO.add(new CitaDTO(cita.getId_cita(),fechaCitaString,cita.getHora_cita(),cita.getNick_medico(),cita.getNick_paciente()));
		}
		
				
		return listaDTO;
		
	}

	@Override
	public List<CitaDTO> buscarCitaPorPaciente(String nick_paciente) {
		
		List<Cita> lista = citaRepository.findByPaciente(nick_paciente);
		List<CitaDTO> listaDTO = new ArrayList<CitaDTO>();
		
		for (Cita cita : lista) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaCita = cita.getFecha_cita();
			String fechaCitaString = formatter.format(fechaCita);
			listaDTO.add(new CitaDTO(cita.getId_cita(),fechaCitaString,cita.getHora_cita(),cita.getNick_medico(),cita.getNick_paciente()));
		}
		
				
		return listaDTO;
	}

	@Override
	public void altaCita(CitaDTO citaDTO) {
		
		Cita cita = new Cita();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fechaCitaString = citaDTO.getFecha_cita();
		Date fechaCita = new Date();
		try {
			fechaCita = formatter.parse(fechaCitaString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		cita.setId_cita(citaDTO.getId_cita());
		cita.setFecha_cita(fechaCita);
		cita.setHora_cita(citaDTO.getHora_cita());
		cita.setNick_medico(citaDTO.getNick_medico());
		cita.setNick_paciente(citaDTO.getNick_paciente());
			
		citaRepository.save(cita);
	}

	@Override
	public void borrarCita(int id_cita) {
		
		citaRepository.deleteById(id_cita);
		
	}
	
	@Override
	public void modificarCita(CitaDTO citaDTO) {
		
		Cita cita = new Cita();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fechaCitaString = citaDTO.getFecha_cita();
		Date fechaCita = new Date();
		try {
			fechaCita = formatter.parse(fechaCitaString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cita.setId_cita(citaDTO.getId_cita());
		cita.setFecha_cita(fechaCita);
		cita.setHora_cita(citaDTO.getHora_cita());
		cita.setNick_medico(citaDTO.getNick_medico());
		cita.setNick_paciente(null);
		
		citaRepository.save(cita);
	}

	@Override
	public Date getFechaDia() throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dia = new Date(System.currentTimeMillis());
		String fechaDiaString = formatter.format(dia);
		Date fechaDia = formatter.parse(fechaDiaString);
		
		return fechaDia;
		
	}

	@Override
	public CitaDTO buscarCita(int id_cita) {
		
		Optional<Cita> citaOp = citaRepository.findById(id_cita);
		
		if(citaOp.isPresent()) {
			Cita cita = citaOp.get();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaCita = cita.getFecha_cita();
			String fechaCitaString = formatter.format(fechaCita);
			CitaDTO citaDTO = new CitaDTO(cita.getId_cita(), fechaCitaString, cita.getHora_cita(), cita.getNick_medico(), cita.getNick_paciente());
			
			return citaDTO;
		}
		
		return null;
		
		
		
	}

	@Override
	public Date getFechaManana() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		Date dia = new Date(System.currentTimeMillis());
		int day = Integer.parseInt(formatter.format(dia)) + 1;
		formatter = new SimpleDateFormat("MM");
		Date mes = new Date(System.currentTimeMillis());
		int month = Integer.parseInt(formatter.format(mes));
		formatter = new SimpleDateFormat("yyyy");
		Date anno = new Date(System.currentTimeMillis());
		int year = Integer.parseInt(formatter.format(anno));
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		
		String fechaDiaString = ""+year+""+month+""+day;
		Date fechaManana = new Date();
		try {
			fechaManana = formatter2.parse(fechaDiaString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fechaManana;
	}
	
	
	
	
}
