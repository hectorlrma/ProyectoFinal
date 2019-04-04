package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.beans.Medico;

public interface MedicoRepository extends CrudRepository<Medico, String> {

}
