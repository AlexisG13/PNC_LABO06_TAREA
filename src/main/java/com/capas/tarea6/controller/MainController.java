package com.capas.tarea6.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capas.tarea6.domain.Contribuyente;
import com.capas.tarea6.domain.Importancia;
import com.capas.tarea6.service.ContribuyenteService;
import com.capas.tarea6.service.ImportanciaService;

@Controller
public class MainController {
	@Autowired
	ContribuyenteService contribuyenteService;

	@Autowired
	ImportanciaService importanciaService;

	@RequestMapping("inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancias = null;
		importancias = this.getImportancias();
		mav.addObject("importanciaCombo", importancias);
		mav.addObject("contribuyente", new Contribuyente());
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("ingresarContribuyente")
	public ModelAndView save(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println(format.format(date));
		if (result.hasErrors()) {
			List<Importancia> importancias = null;
			importancias = this.getImportancias();
			mav.addObject("importanciaCombo", importancias);
			mav.setViewName("index");
			return mav;
		}
		try {
			contribuyente.setF_fecha_ingreso(date);
			contribuyenteService.save(contribuyente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("exito");
		return mav;
	}

	@RequestMapping("listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		try {
			contribuyentes = contribuyenteService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("listado");
		return mav;
	}

	private List<Importancia> getImportancias() {
		List<Importancia> importancias = null;
		try {
			importancias = importanciaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return importancias;
	}
}
