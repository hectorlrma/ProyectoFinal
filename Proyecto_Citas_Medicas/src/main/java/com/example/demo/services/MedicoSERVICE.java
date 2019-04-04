package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.dao.MedicoRepository;
import com.example.demo.interfaces.IMedicoSERVICE;

@Service
public class MedicoSERVICE implements IMedicoSERVICE {

	MedicoRepository medicoRepository;
	
	
}
