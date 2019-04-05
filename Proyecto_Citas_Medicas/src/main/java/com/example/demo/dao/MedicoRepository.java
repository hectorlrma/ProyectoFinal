package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.beans.Medico;

public interface MedicoRepository extends CrudRepository<Medico, String> {

	public List<Medico> findByLocalidad(int id_localidad);
	
}
