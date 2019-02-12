package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.service.IMoviesService;
import net.itinajero.app.service.ISchedulesService;
import net.itinajero.app.util.utileria;
import net.itinajero.app.model.Movie;
import net.itinajero.app.model.Schedule;

@Controller
@RequestMapping(value="/schedules")
public class SchedulesController {
	@Autowired
	private ISchedulesService serviceSchedules;
	
	@Autowired
	IMoviesService serviceMovies;
	
	@GetMapping("/index")
	public String showMain(Model model) {
		model.addAttribute("schedules",serviceSchedules.searchAll());
		return "/schedules/listSchedules";
	}
	
	@GetMapping("/create")
	public String create(@ModelAttribute Schedule schedule, Model model) {
		return "/schedules/formSchedule";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Schedule schedule, BindingResult result, Model model, RedirectAttributes attribute) {
		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			return "/schedules/formSchedule";
		}
		serviceSchedules.insert(schedule);
		attribute.addFlashAttribute("message", "Horario guardado.");
		return "redirect:/schedules/index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int idSchedule, Model model) {
		model.addAttribute("schedule", serviceSchedules.searchById(idSchedule));
		return "/schedules/formSchedule";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int idSchedule, RedirectAttributes attribute) {
		serviceSchedules.delete(idSchedule);
		attribute.addFlashAttribute("message", "Horario eliminado.");
		return "redirect:/schedules/index";
	}
	
	@ModelAttribute("movies")
	public List<Movie> getMovies(){
		return serviceMovies.searchAll();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
	

}
