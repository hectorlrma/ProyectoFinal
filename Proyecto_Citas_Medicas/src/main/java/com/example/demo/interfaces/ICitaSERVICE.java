package com.example.demo.interfaces;



import java.util.List;

import com.example.demo.dto.CitaDTO;

public interface ICitaSERVICE {

	public List <CitaDTO> buscarCitaPorMedico(String nick_medico);
}
