package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.beans.Cita;

public interface CitaRepository extends CrudRepository<Cita, Integer> {

	public List <Cita> findByMedico(String nick_medico);
}
