package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.beans.Paciente;
import com.example.demo.interfaces.IPacienteSERVICE;

@Controller
public class Controlador {

	@Autowired
	IPacienteSERVICE pacienteSERVICE;

	@RequestMapping("/index") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String index(HttpServletRequest request) {
		System.out.println("TRAZA INDEX");
		return "index";
	}

	@RequestMapping("/registrarse") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String registrarse(HttpServletRequest request) {
		System.out.println("TRAZA REGISTRARSE");
		return "registrarse";
	}

	/*@RequestMapping("/registro") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String registro(HttpServletRequest request, @ModelAttribute Paciente paciente) {
		System.out.println("TRAZA REGISTRO");
		Paciente paciente = new Paciente();
		if (pacienteSERVICE.buscar_idusuario(paciente.getNick_paciente()) == null) {
			pacienteSERVICE.altapaciente(paciente);
			request.setAttribute("mensaje", "alta realizada correctamente");
			return "index";
		} else {
			request.setAttribute("mensaje", "usuario ya existe");
			return "registrarse";
		}
	}
	
	@RequestMapping("/login") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String registrarse(HttpServletRequest request) {
		System.out.println("TRAZA LOGIN");
		return "medico";
		return "paciente";
	}*/

}
