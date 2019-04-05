package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MedicoRepository;
import com.example.demo.dto.MedicoDTO;
import com.example.demo.interfaces.IMedicoSERVICE;

@Service
public class MedicoSERVICE implements IMedicoSERVICE {
	
	@Autowired
	MedicoRepository medicoRepository;

	@Override
	public List<MedicoDTO> buscarMedicoPorLocalidad(int id_localidad) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
