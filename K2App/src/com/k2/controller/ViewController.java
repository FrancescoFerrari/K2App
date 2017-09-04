package com.k2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.k2.entity.Layer;
import com.k2.exception.ServiceException;
import com.k2.service.LayerService;


@Controller
public class ViewController {
	
	

	private LayerService layerService;

	@Inject
	public ViewController(final LayerService layerService) {
		this.layerService = layerService;  
	}
	





	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String showHome() {
		return "/indexx";
	}


	@RequestMapping(value= "/upload", method = RequestMethod.GET)
	public String showForm() {
		return "/form"; 
	}

	@RequestMapping(value="/show", method = RequestMethod.GET)
	public String showForm(ModelMap model ) {

		List<Layer> layersListregioni = new ArrayList<Layer>();
		List<Layer> layersListprovincie = new ArrayList<Layer>();
		List<Layer> layersListcomuni = new ArrayList<Layer>();

		try {
			layersListregioni = this.layerService.getRegioni();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		model.addAttribute("regioni",layersListregioni);
		model.addAttribute("provincie",layersListprovincie);
		model.addAttribute("comuni",layersListcomuni);

		return "/vediCaricati";
	}

	
	
	

	//	@RequestMapping(value="/delete", method = RequestMethod.GET)
	//	public String showForm(ModelMap model, @RequestParam("id") Long id) {
	//		uploadedFileService.removeUploadedFile(id);
	//		List<UploadedFile> uploadedFiles = uploadedFileService.listUploadedFile();
	//		model.addAttribute("uploadedFiles", uploadedFiles);	
	//		return "/vediCaricati";
	//
	//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public ViewController() {
	}






}
