package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	
	
	@RequestMapping("/index") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String index(HttpServletRequest request) {
		System.out.println("TRAZA INDEX");
		HttpSession session = request.getSession(true); // abro sesion
		List<LocalidadDTO> localidades = localidadSERVICE.listarLocalidades();
		List<EspecialidadDTO> especialidades=especialidadSERVICE.listarEspecialidades();
		System.out.println("localidades: "+localidades);
		System.out.println("especialidades: "+especialidades);
		for (EspecialidadDTO especialidadDTO : especialidades) {
			System.out.println("especialidades: "+especialidades);
		}

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
		System.out.println("pacienteDTO: "+pacienteDTO);
		if (pacienteSERVICE.buscarPacienteDTO(pacienteDTO.getNick_paciente()) == null) {
			System.out.println("entra en if");	
			pacienteDTO.setRol_paciente("paciente");
			pacienteSERVICE.addPacienteDTO(pacienteDTO);
				request.setAttribute("mensaje", "alta realizada correctamente");
//				session.setAttribute("nick_paciente", paciente);
				return "index";
			} else {
				System.out.println("entra en else");
				request.setAttribute("mensaje", "usuario ya existe");
				return "index";
			}
		} 
	
	@RequestMapping("/registroMedico") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String registroMedico(HttpServletRequest request, @ModelAttribute MedicoDTO medicoDTO) {
		System.out.println("TRAZA REGISTRO MEDICO");		
		HttpSession session = request.getSession(true); // abro sesion
//		int id_especialidad = request.getParameter("id_especialidad");
		
		System.out.println("medicoDTO: "+medicoDTO);
			if (medicoSERVICE.buscarMedicoDTO(medicoDTO.getNick_medico()) == null) {
				medicoDTO.setRol_medico("medico");
				medicoSERVICE.addMedicoDTO(medicoDTO);
				request.setAttribute("mensaje", "alta realizada correctamente");
//				session.setAttribute("nick_medico", medico);
				return "index";
			} else {
				request.setAttribute("mensaje", "usuario ya existe");
				return "index";
			}
		}
	

	@RequestMapping("/loginpaciente") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String loginpaciente(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA LOGIN PACIENTE");
		String nick_paciente = (String)request.getParameter("nick_paciente");
		System.out.println("nick_paciente: "+nick_paciente);
		PacienteDTO pacienteDTO=pacienteSERVICE.buscarPacienteDTO(nick_paciente);
		List<Cita> citas = pacienteDTO.getCitas();
		List<Cita> citadia = new ArrayList<Cita>();
		for (Cita cita : citas) {
			try {
				Date fecha_cita = cita.getFecha_cita();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String fecha_cita_string = formatter.format(fecha_cita);
				Date fecha_cita_formatted = formatter.parse(fecha_cita_string);
				System.out.println("fecha_cita_formatted: "+fecha_cita_formatted);
				if (fecha_cita_formatted.compareTo(citaSERVICE.getFechaDia())==0) {
					citadia.add(cita);
					System.out.println("citadia: "+citadia);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.setAttribute("cita_paciente", citadia);
		session.setAttribute("nick_paciente", nick_paciente);

		return "citasPaciente";
	}
	@RequestMapping("/loginmedico") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String loginmedico(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA LOGIN MEDICO");
		String nick_medico =(String) request.getParameter("nick_medico");
		System.out.println("nick_medico: "+nick_medico);
		MedicoDTO medicoDTO=medicoSERVICE.buscarMedicoDTO(nick_medico);
		System.out.println("medicoDTO: "+medicoDTO);
		System.out.println("medicoDTO: "+medicoDTO.getCitas());
		Date fechadia = new Date();
		try {
			fechadia = citaSERVICE.getFechaDia();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("fechadia: "+fechadia);
		List<CitaDTO> citas = medicoDTO.getCitas();
		List<CitaDTO> citadia = new ArrayList<CitaDTO>();
		for (CitaDTO cita : citas) {
			try {
				String fecha_cita_string = cita.getFecha_cita();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha_cita_formatted = formatter.parse(fecha_cita_string);
				System.out.println("fecha_cita_formatted: "+fecha_cita_formatted);
				if (fecha_cita_formatted.compareTo(citaSERVICE.getFechaDia())==0) {
					citadia.add(cita);
					System.out.println("citadia: "+citadia);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.setAttribute("cita_medico", citadia);
		session.setAttribute("nick_medico", nick_medico);
		return "citasMedicas";
//		return "paciente";
	}
	
	@RequestMapping("/borrarcita") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String borrarcita(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA BORRAR CITA");
		int id_cita = Integer.parseInt(request.getParameter("id_cita"));
		citaSERVICE.borrarCita(id_cita);
		return citaHoyMed(request);
	}
	
	@RequestMapping("/citaantiguapac") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String citaantiguapac(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA CITA ANTIGUA PACIENTE");
		String nick_paciente = (String)session.getAttribute("nick_paciente");
		PacienteDTO paciente=pacienteSERVICE.buscarPacienteDTO(nick_paciente);
		List<Cita> citas = paciente.getCitas();
		List<Cita> citadia = new ArrayList<Cita>();
		for (Cita cita : citas) {
			try {
				Date fecha_cita = cita.getFecha_cita();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String fecha_cita_string = formatter.format(fecha_cita);
				Date fecha_cita_formatted = formatter.parse(fecha_cita_string);
				System.out.println("fecha_cita_formatted: "+fecha_cita_formatted);
				if (fecha_cita_formatted.compareTo(citaSERVICE.getFechaDia())<0) {
					citadia.add(cita);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block  
				e.printStackTrace();
			}
		}
		request.setAttribute("cita_paciente", citadia);
		return "citasPaciente";
	}
	
	@RequestMapping("/citaproximapac") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String citaproximapac(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA CITA PROXIMA PACIENTE");
		session.getAttribute("nick_paciente");
		String nick_paciente = (String)session.getAttribute("nick_paciente");
		PacienteDTO paciente=pacienteSERVICE.buscarPacienteDTO(nick_paciente);
		List<Cita> citas = paciente.getCitas();
		List<Cita> citadia = new ArrayList<Cita>();
		for (Cita cita : citas) {
			try {
				Date fecha_cita = cita.getFecha_cita();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String fecha_cita_string = formatter.format(fecha_cita);
				Date fecha_cita_formatted = formatter.parse(fecha_cita_string);
				System.out.println("fecha_cita_formatted: "+fecha_cita_formatted);
				System.out.println("fehca cita: "+cita.getFecha_cita());
				System.out.println("fecha service: "+citaSERVICE.getFechaDia());
				if (fecha_cita_formatted.compareTo(citaSERVICE.getFechaDia())>0) {
					citadia.add(cita);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("cita_paciente", citadia);
		return "citasPaciente";
	}
	
	@RequestMapping("/citaantiguamed") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String citaantiguamed(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA CITA ANTIGUA MEDICO");
		String nick_medico = (String) session.getAttribute("nick_medico");
		MedicoDTO medicoDTO=medicoSERVICE.buscarMedicoDTO(nick_medico);
		List<CitaDTO> citas = medicoDTO.getCitas();
		List<CitaDTO> citadia = new ArrayList<CitaDTO>();
		for (CitaDTO cita : citas) {
			try {
				String fecha_cita_string = cita.getFecha_cita();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha_cita_formatted = formatter.parse(fecha_cita_string);
				if ((fecha_cita_formatted.compareTo(citaSERVICE.getFechaDia())<0)&cita.getNick_paciente()!=null) {
					citadia.add(cita);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.setAttribute("cita_medico", citadia);
		return "citasMedicas";
	}
	
	@RequestMapping("/citaproximamed") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String citaproximamed(HttpServletRequest request) {
	HttpSession session = request.getSession(true); // abro sesion
	System.out.println("TRAZA CITA PROXIMA MEDICO");
	String nick_medico = (String) session.getAttribute("nick_medico");
	MedicoDTO medicoDTO=medicoSERVICE.buscarMedicoDTO(nick_medico);
	List<CitaDTO> citas = medicoDTO.getCitas();
	List<CitaDTO> citadia = new ArrayList<CitaDTO>();
	for (CitaDTO cita : citas) {
		try {
			String fecha_cita_string = cita.getFecha_cita();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha_cita_formatted = formatter.parse(fecha_cita_string);
			System.out.println("fecha_cita_formatted: "+fecha_cita_formatted);
			if (fecha_cita_formatted.compareTo(citaSERVICE.getFechaDia())>0) {
				citadia.add(cita);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	request.setAttribute("cita_medico", citadia);
		return "citasMedicas";
	}
	
	@RequestMapping("/citaconfirmada") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String citaconfirmada(HttpServletRequest request) {
	HttpSession session = request.getSession(true); // abro sesion
	System.out.println("TRAZA CITA CONFIRMADA MEDICO");
	String nick_medico = (String) session.getAttribute("nick_medico");
	MedicoDTO medicoDTO=medicoSERVICE.buscarMedicoDTO(nick_medico);
	List<CitaDTO> citas = medicoDTO.getCitas();
	List<CitaDTO> citadia = new ArrayList<CitaDTO>();
	for (CitaDTO cita : citas) {
		try {
			String fecha_cita_string = cita.getFecha_cita();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha_cita_formatted = formatter.parse(fecha_cita_string);
			System.out.println("fecha_cita_formatted: "+fecha_cita_formatted);
			if ((fecha_cita_formatted.compareTo(citaSERVICE.getFechaDia())>=0)&cita.getNick_paciente()!=null) {
				citadia.add(cita);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	request.setAttribute("cita_medico", citadia);
		return "citasMedicas";
	}
	
	@RequestMapping("/altacita") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String altacita(HttpServletRequest request, @ModelAttribute CitaDTO citaDTO) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA ALTA CITA");
		String nick_medico = (String) session.getAttribute("nick_medico");
		citaDTO.setNick_medico(nick_medico);
		citaDTO.setNick_paciente(null);
		citaSERVICE.altaCita(citaDTO);
		return "altacita";
	}
 
	@RequestMapping("/citaHoyMed") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String citaHoyMed(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA CITA HOY MEDICO");
		String nick_medico = (String) session.getAttribute("nick_medico");
		System.out.println("nick_medico: "+nick_medico);
		MedicoDTO medicoDTO=medicoSERVICE.buscarMedicoDTO(nick_medico);
		System.out.println("medicoDTO: "+medicoDTO);
		List<CitaDTO> citas = medicoDTO.getCitas();
		List<CitaDTO> citadia = new ArrayList<CitaDTO>();
		for (CitaDTO cita : citas) {
			try {
				String fecha_cita_string = cita.getFecha_cita();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha_cita_formatted = formatter.parse(fecha_cita_string);
				System.out.println("fecha_cita_formatted: "+fecha_cita_formatted);
				if (fecha_cita_formatted.compareTo(citaSERVICE.getFechaDia())==0) {
					citadia.add(cita);
					System.out.println("citadia: "+citadia);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.setAttribute("cita_medico", citadia);
		return "citasMedicas";
	}
	@RequestMapping("/citaHoyPac") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String citaHoyPac(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA LOGIN PACIENTE");
		String nick_paciente = (String)session.getAttribute("nick_paciente");
		System.out.println("nick_paciente: "+nick_paciente);
		PacienteDTO pacienteDTO=pacienteSERVICE.buscarPacienteDTO(nick_paciente);
		List<Cita> citas = pacienteDTO.getCitas();
		List<Cita> citadia = new ArrayList<Cita>();
		for (Cita cita : citas) {
			try {
				Date fecha_cita = cita.getFecha_cita();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String fecha_cita_string = formatter.format(fecha_cita);
				Date fecha_cita_formatted = formatter.parse(fecha_cita_string);
				System.out.println("fecha_cita_formatted: "+fecha_cita_formatted);
				if (fecha_cita_formatted.compareTo(citaSERVICE.getFechaDia())==0) {
					citadia.add(cita);
					System.out.println("citadia: "+citadia);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.setAttribute("cita_paciente", citadia);
		return "citasPaciente";
	}
	
	@RequestMapping("/buscar") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String buscar(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA BUSCAR CITA");
		int id_especialidad=Integer.parseInt(request.getParameter("especialidad"));
		int id_localidad=Integer.parseInt(request.getParameter("localidad"));
		System.out.println("especialidad: "+id_especialidad);
		System.out.println("localidad: "+id_localidad);
		EspecialidadDTO especialidadDTO = especialidadSERVICE.buscarEspecialidadDTO(id_especialidad);
		LocalidadDTO localidadDTO= localidadSERVICE.buscarLocalidadDTO(id_localidad);
		List<MedicoDTO> medicoDTO=medicoSERVICE.findByLocalidadAndEspecialidad2(id_localidad, id_especialidad);
		System.out.println("medicoDTO: "+medicoDTO);
		List<CitaDTO> citas = new ArrayList<CitaDTO>();
		List<CitaDTO> citasmedico = new ArrayList<CitaDTO>();
		for (MedicoDTO medicoDTO2 : medicoDTO) {
			List<CitaDTO> citas1 = medicoDTO2.getCitas();
			for (CitaDTO cita : citas1) {
				citas.add(cita);
			}
		}
		for (CitaDTO cita : citas) {
			try {
				String fecha_cita_string = cita.getFecha_cita();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha_cita_formatted = formatter.parse(fecha_cita_string);
				System.out.println("fecha_cita_formatted: "+fecha_cita_formatted);
				if ((fecha_cita_formatted.compareTo(citaSERVICE.getFechaDia())>=0)&cita.getNick_paciente()==null) {
					citasmedico.add(cita);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("citaMedicosDTO: "+citasmedico);
		session.setAttribute("localidadDTO", localidadDTO);
		session.setAttribute("especialidadDTO", especialidadDTO);
		request.setAttribute("citaMedicosDTO", citasmedico);
		request.setAttribute("medicoDTO", medicoDTO);
//		citaSERVICE.altaCita(citaDTO);
		return "buscar";
	}
	
	@RequestMapping("/volverBuscar") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String volverBuscar(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA VOLVER A BUSCAR");
		EspecialidadDTO escepecialidadDTO=(EspecialidadDTO) session.getAttribute("especialidadDTO");
		LocalidadDTO localidadDTO=(LocalidadDTO) session.getAttribute("localidadDTO");
		System.out.println("escepecialidadDTO: "+escepecialidadDTO);
		System.out.println("localidadDTO: "+localidadDTO);
		
		List<MedicoDTO> medicoDTO=medicoSERVICE.findByLocalidadAndEspecialidad2(escepecialidadDTO.getId_especialidad(), localidadDTO.getId_localidad());
		System.out.println("medicoDTO: "+medicoDTO);
		List<CitaDTO> citas = new ArrayList<CitaDTO>();
		List<CitaDTO> citasmedico = new ArrayList<CitaDTO>();
		for (MedicoDTO medicoDTO2 : medicoDTO) {
			List<CitaDTO> citas1 = medicoDTO2.getCitas();
			for (CitaDTO cita : citas1) {
				citas.add(cita);
			}
		}
		for (CitaDTO cita : citas) {
			try {
				String fecha_cita_string = cita.getFecha_cita();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha_cita_formatted = formatter.parse(fecha_cita_string);
				System.out.println("fecha_cita_formatted: "+fecha_cita_formatted);
				if ((fecha_cita_formatted.compareTo(citaSERVICE.getFechaDia())>=0)&cita.getNick_paciente()==null) {
					citasmedico.add(cita);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("citaMedicosDTO: "+citasmedico);
		request.setAttribute("citaMedicosDTO", citasmedico);
		request.setAttribute("medicoDTO", medicoDTO);
//		citaSERVICE.altaCita(citaDTO);
		return "buscar";
	}
	
	@RequestMapping("/pideCita") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String pideCita(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA PIDE CITA");
		String nick_paciente = (String)session.getAttribute("nick_paciente");
		System.out.println("nick_paciente: "+nick_paciente);
		System.out.println("id_cita: "+request.getParameter("id_cita"));
		int id_cita = Integer.parseInt(request.getParameter("id_cita"));
		System.out.println("id_cita: "+id_cita);
		CitaDTO citaDTO=citaSERVICE.buscarCita(id_cita);
		citaDTO.setNick_paciente(nick_paciente);
		System.out.println("citaDTO: "+citaDTO);
		citaSERVICE.altaCita(citaDTO);
		System.out.println("citaDTO: "+citaDTO);
		request.setAttribute("citaDTO", citaDTO);		
		return citaHoyPac(request);
	}
	
	@RequestMapping("/cancelarCita") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String cancelarCita(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA CANCELAR CITA");
		int id_cita = Integer.parseInt(request.getParameter("id_cita"));
		CitaDTO citaDTO=citaSERVICE.buscarCita(id_cita);
		citaSERVICE.modificarCita(citaDTO);
		return citaHoyPac(request);
	}
	
	@RequestMapping("/detalleMedico") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String detalleMedico(HttpServletRequest request) {
		HttpSession session = request.getSession(true); // abro sesion
		System.out.println("TRAZA DETALLE MEDICO");
		String nick_medico = request.getParameter("nick_medico");
		MedicoDTO medicoDTO=medicoSERVICE.buscarMedicoDTO(nick_medico);
		EspecialidadDTO especialidadDTO = especialidadSERVICE.buscarEspecialidadDTO(medicoDTO.getId_Especialidad());
		LocalidadDTO localidadDTO= localidadSERVICE.buscarLocalidadDTO(medicoDTO.getId_localidad());
		request.setAttribute("localidadDTO", localidadDTO);
		request.setAttribute("especialidadDTO", especialidadDTO);		
		request.setAttribute("medicoDTO", medicoDTO);
		return "detalleMedico";
	}
}
