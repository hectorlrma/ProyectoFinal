package com.example.demo.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.beans.Cita;
import com.example.demo.beans.Especialidad;
import com.example.demo.beans.Medico;
import com.example.demo.beans.Paciente;
import com.example.demo.dto.CitaDTO;
import com.example.demo.dto.EspecialidadDTO;
import com.example.demo.dto.LocalidadDTO;
import com.example.demo.dto.MedicoDTO;
import com.example.demo.dto.PacienteDTO;
import com.example.demo.interfaces.ICitaSERVICE;
import com.example.demo.interfaces.IEspecialidadSERVICE;
import com.example.demo.interfaces.ILocalidadSERVICE;
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
	IEspecialidadSERVICE especialidadSERVICE;
	
	@Autowired
	ILocalidadSERVICE localidadSERVICE;
	
//	Paciente paciente = new Paciente();
	
	
//	Medico medico = new Medico();
	
	
//	Cita cita = new Cita();
	
	@RequestMapping("/index") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String index(HttpServletRequest request) {
		System.out.println("TRAZA INDEX");
		HttpSession session = request.getSession(true); // abro sesion
		List<LocalidadDTO> localidades = localidadSERVICE.listarLocalidades();
		List<EspecialidadDTO> especialidades=especialidadSERVICE.listarEspecialidades();
		session.setAttribute("localidades", localidades);
		session.setAttribute("especialidades", especialidades);
		return "index";
	}

/*	@RequestMapping("/registrarse") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String registrarse(HttpServletRequest request) {
		System.out.println("TRAZA REGISTRARSE");
		return "registrarse";
	}*/

	@RequestMapping("/registroPaciente") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String registroPaciente(HttpServletRequest request, @ModelAttribute PacienteDTO pacienteDTO) {
		System.out.println("TRAZA REGISTRO PACIENTE");		
		HttpSession session = request.getSession(true); // abro sesion
		if (pacienteSERVICE.buscarPacienteDTO(pacienteDTO.getNick_paciente()) == null) {
				pacienteSERVICE.addPacienteDTO(pacienteDTO);
				request.setAttribute("mensaje", "alta realizada correctamente");
//				session.setAttribute("nick_paciente", paciente);
				return "index";
			} else {
				request.setAttribute("mensaje", "usuario ya existe");
				return "registrarse";
			}
		} 
	
	@RequestMapping("/registroMedico") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String registroMedico(HttpServletRequest request, @ModelAttribute MedicoDTO medicoDTO) {
		System.out.println("TRAZA REGISTRO MEDICO");		
		HttpSession session = request.getSession(true); // abro sesion
			if (medicoSERVICE.buscarMedicoDTO(medicoDTO.getNick_medico()) == null) {
				medicoSERVICE.addMedicoDTO(medicoDTO);
				request.setAttribute("mensaje", "alta realizada correctamente");
//				session.setAttribute("nick_medico", medico);
				return "index";
			} else {
				request.setAttribute("mensaje", "usuario ya existe");
				return "registrarse";
			}
		}
	

	@RequestMapping("/loginpaciente") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String loginpaciente(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA LOGIN PACIENTE");
//		session.getAttribute("nick_paciente");
		String nick_paciente = (String)session.getAttribute("nick_paciente");
		PacienteDTO pacienteDTO=pacienteSERVICE.buscarPacienteDTO(nick_paciente);
		List<Cita> citas = pacienteDTO.getCitas();
		List<Cita> citadia = (List<Cita>) new Cita();
		for (Cita cita : citas) {
//			if (cita.getFecha_cita()==fechadia()) {
				citadia.add(cita);
//			}
		}
		
		request.setAttribute("cita_paciente", citadia);
		//		return "medico";
		return "citaPaciente";
	}
	@RequestMapping("/loginmedico") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String loginmedico(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA LOGIN MEDICO");
//		session.getAttribute("nick_medico");
		String nick_medico =(String) session.getAttribute("nick_medico");
		MedicoDTO medicoDTO=medicoSERVICE.buscarMedicoDTO(nick_medico);
		List<Cita> citas = medicoDTO.getCitas();
		List<Cita> citadia = (List<Cita>) new Cita();
		for (Cita cita : citas) {
			try {
				if (cita.getFecha_cita().compareTo(citaSERVICE.getFechaDia())==0) {
					citadia.add(cita);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.setAttribute("cita_medico", citadia);
		return "citaMedico";
//		return "paciente";
	}
	
	@RequestMapping("/borrarcita") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String borrarcita(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA BORRAR CITA");
		int id_cita = (int) request.getAttribute("id_cita");
		citaSERVICE.borrarCita(id_cita);
		return "borrarcita";
	}
	
	@RequestMapping("/citaantiguapac") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String citaantiguapac(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA CITA ANTIGUA PACIENTE");
		session.getAttribute("nick_paciente");
		String nick_paciente = (String)session.getAttribute("nick_paciente");
		PacienteDTO paciente=pacienteSERVICE.buscarPacienteDTO(nick_paciente);
		List<Cita> citas = paciente.getCitas();
		List<Cita> citadia = (List<Cita>) new Cita();
		for (Cita cita : citas) {
//			if (cita.getFecha_cita()<fechadia()) {
				citadia.add(cita);
//			}
		}
		request.setAttribute("cita_paciente", citadia);
		return "citaPaciente";
	}
	
	@RequestMapping("/citaproximapac") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String citaproximapac(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA CITA ANTIGUA PACIENTE");
		session.getAttribute("nick_paciente");
		String nick_paciente = (String)session.getAttribute("nick_paciente");
		PacienteDTO paciente=pacienteSERVICE.buscarPacienteDTO(nick_paciente);
		List<Cita> citas = paciente.getCitas();
		List<Cita> citadia = (List<Cita>) new Cita();
		for (Cita cita : citas) {
//			if (cita.getFecha_cita()>fechadia()) {
				citadia.add(cita);
//			}
		}
		request.setAttribute("cita_paciente", citadia);
		return "citaPaciente";
	}
	
	@RequestMapping("/citaantiguamed") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String citaantiguamed(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA CITA ANTIGUA MEDICO");
		String nick_medico = (String) session.getAttribute("nick_medico");
		MedicoDTO medicoDTO=medicoSERVICE.buscarMedicoDTO(nick_medico);
		List<Cita> citas = medicoDTO.getCitas();
		List<Cita> citadia = (List<Cita>) new Cita();
		for (Cita cita : citas) {
//			if (cita.getFecha_cita().compareTo(medicoSERVICE.getFechaDia())<0) {
				citadia.add(cita);
//			}
		}
		
		request.setAttribute("cita_medico", citadia);
		return "citaMedico";
	}
	
	@RequestMapping("/citaproximamed") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String citaproximamed(HttpServletRequest request) {
	HttpSession session = request.getSession(true); // abro sesion
	System.out.println("TRAZA CITA PROXIMA MEDICO");
	String nick_medico = (String) session.getAttribute("nick_medico");
	MedicoDTO medicoDTO=medicoSERVICE.buscarMedicoDTO(nick_medico);
	List<Cita> citas = medicoDTO.getCitas();
	List<Cita> citadia = (List<Cita>) new Cita();
	for (Cita cita : citas) {
//		if (cita.getFecha_cita().compareTo(medicoSERVICE.getFechaDia())>0) {
			citadia.add(cita);
//		}
	}	
	request.setAttribute("cita_medico", citadia);
		return "citaMedico";
	}
 
}
