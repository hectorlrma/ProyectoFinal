package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Controlador {

	@RequestMapping("/index") // ("/")esto quiere decir mi pagina de inicio mapeo a nivel de metodo
	public String inicio(HttpServletRequest request) {
		return "index";
	}
}
