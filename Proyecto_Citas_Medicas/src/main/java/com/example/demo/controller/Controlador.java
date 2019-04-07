package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.beans.Cita;
import com.example.demo.beans.Medico;
import com.example.demo.beans.Paciente;
import com.example.demo.interfaces.ICitaSERVICE;
import com.example.demo.interfaces.IMedicoSERVICE;
import com.example.demo.interfaces.IPacienteSERVICE;

@Controller
public class Controlador {

	@Autowired
	IPacienteSERVICE pacienteSERVICE;
	
	@Autowired
	IMedicoSERVICE medicoSERVICE;
	
	@Autowired
	ICitaSERVICE citaSERVICE;
	
	@Autowired
	Paciente paciente = new Paciente();
	
	@Autowired
	Medico medico = new Medico();
	
	@Autowired
	Cita cita = new Cita();
	
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

	@RequestMapping("/registro") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String registro(HttpServletRequest request, @ModelAttribute Paciente paciente) {
		System.out.println("TRAZA REGISTRO");		
		HttpSession session = request.getSession(true); // abro sesion
		if (medico.getEspecialidad() == null) {
			if (pacienteSERVICE.buscar_idusuario(paciente.getNick_paciente()) == null) {
				pacienteSERVICE.altapaciente(paciente);
				request.setAttribute("mensaje", "alta realizada correctamente");
				session.setAttribute("nick_paciente", paciente);
				return "loginpaciente";
			} else {
				request.setAttribute("mensaje", "usuario ya existe");
				return "registrarse";
			}
		} else {
			if (medicoSERVICE.buscar_idusuario(medico.getNick_medico()) == null) {
				medicoSERVICE.altamedico(medico);
				request.setAttribute("mensaje", "alta realizada correctamente");
				session.setAttribute("nick_medico", medico);
				return "loginmedico";
			} else {
				request.setAttribute("mensaje", "usuario ya existe");
				return "registrarse";
			}
		}
	}

	@RequestMapping("/loginpaciente") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String loginpaciente(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA LOGIN PACIENTE");
		session.getAttribute("nick_paciente");
		paciente=pacienteSERVICE.buscarcita(paciente.getNick_paciente());
		List<Cita> cita = paciente.getCitas();
		request.setAttribute("cita_paciente", cita);
		//		return "medico";
		return "loginpaciente";
	}
	@RequestMapping("/loginmedico") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String loginmedico(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA LOGIN MEDICO");
		session.getAttribute("nick_medico");
		medico=medicoSERVICE.buscarcita(medico.getNick_medico());
		List<Cita> citas = medico.getCitas();
		for (Cita cita : citas) {
			if (cita.getFecha_cita()==fechadia()) {
				citas.add(cita);
			}
		}
		
		request.setAttribute("cita_medico", cita);
		return "loginmedico";
//		return "paciente";
	}
	
	@RequestMapping("/borrarcita") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String borrarcita(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA BORRAR CITA");
		citaSERVICE.borrarCita(cita.getId_cita());
		return "borrarcita";
	}
}
