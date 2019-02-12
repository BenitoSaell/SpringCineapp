package net.itinajero.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.itinajero.app.model.Contact;
import net.itinajero.app.service.IMoviesService;

@Controller
public class ContactController {
	@Autowired
	IMoviesService serviceMovies;
	
	@GetMapping("/contact")
	public String showForm(@ModelAttribute Contact contact, Model model) {
		model.addAttribute("genders", serviceMovies.searchGenders());
		model.addAttribute("types", typeNotifications());
		return "formContact";
	}
	
	@PostMapping("/contact")
	public String save(@ModelAttribute Contact contact) {
		System.out.print("Contact: "+contact);
		//model.addAttribute("types", typeNotifications());
		return "redirect:/contact";
	}
	
	private List<String> typeNotifications(){
		List<String> types = new LinkedList<>();
		types.add("Estrenos");
		types.add("Promociones");
		types.add("Noticias");
		types.add("Preventas");
		return types;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
