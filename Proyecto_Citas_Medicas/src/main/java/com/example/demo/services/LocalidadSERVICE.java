package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LocalidadRepository;
import com.example.demo.interfaces.ILocalidadSERVICE;

@Service
public class LocalidadSERVICE implements ILocalidadSERVICE {
	
	@Autowired
	LocalidadRepository localidadRepository;
}
