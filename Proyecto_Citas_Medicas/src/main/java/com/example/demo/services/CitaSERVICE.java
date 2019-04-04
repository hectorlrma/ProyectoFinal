package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CitaRepository;
import com.example.demo.interfaces.ICitaSERVICE;

@Service
public class CitaSERVICE implements ICitaSERVICE {

	
	@Autowired
	CitaRepository citaRepository;
}
