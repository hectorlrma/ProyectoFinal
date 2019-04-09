package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.beans.Medico;

public interface MedicoRepository extends CrudRepository<Medico, String> {

//	public List<Medico> findByLocalidadAndEspecialidad(int id_localidad, int id_espcialidad);
	

	@Query(value="SELECT * FROM citas_medicas.medicos where id_localidad =:id_localidad and id_especialidad=:id_especialidad",nativeQuery=true)

	public Optional<List<Medico>> findByLocalidadAndEspecialidad2(@Param("id_localidad") int id_localidad, @Param("id_especialidad") int id_especialidad);
}
