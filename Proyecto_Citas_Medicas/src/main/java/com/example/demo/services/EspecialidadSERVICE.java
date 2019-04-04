package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EspecialidadRepository;
import com.example.demo.interfaces.IEspecialidadSERVICE;

@Service
public class EspecialidadSERVICE implements IEspecialidadSERVICE {

	@Autowired
	EspecialidadRepository especialidadRepository;
}
