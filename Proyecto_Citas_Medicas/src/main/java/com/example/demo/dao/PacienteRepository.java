package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.beans.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, String> {

}
