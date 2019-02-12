package net.itinajero.app.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Movie;
import net.itinajero.app.model.News;
import net.itinajero.app.service.IDetailsService;
import net.itinajero.app.service.IMoviesService;
import net.itinajero.app.util.utileria;

@Controller
@RequestMapping("/movies")
public class MoviesController {
	@Autowired
	IDetailsService serviceDetails;
	
	@Autowired
	IMoviesService serviceMovies;

	@GetMapping("/index")
	public String showIndex(Model model) {
		List<Movie> list = serviceMovies.searchAll();
		model.addAttribute("movies", list);
		return "movies/listMovies";
	} 

	@GetMapping("/create")
	public String create(@ModelAttribute Movie movie, Model model) {
		return "movies/formMovie";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int idMovie, Model model) {
		model.addAttribute("movie", serviceMovies.searchByID(idMovie));
		return "movies/formMovie";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int idMovie, RedirectAttributes attribute) {
		Movie movie = serviceMovies.searchByID(idMovie);
		serviceMovies.delete(idMovie);
		serviceDetails.delete(movie.getDetail().getId());
		attribute.addFlashAttribute("message","La pelicula fue eliminada");
		return "redirect:/movies/index";
	}

	@PostMapping(value = "/save")
	public String save(@ModelAttribute Movie movie, BindingResult result, RedirectAttributes attributes,
			@RequestParam("fileImage") MultipartFile multiPart, HttpServletRequest request) {
		if (!multiPart.isEmpty()) {
			String nameImage = utileria.saveImage(multiPart, request);
			System.out.println("name:   "+nameImage);
			movie.setImage(nameImage);
		}

		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			return "movies/formMovie";

		}
		System.out.println(movie);
		serviceDetails.insert(movie.getDetail());
		serviceMovies.insert(movie);
		attributes.addFlashAttribute("message", "La pelicula fue insertada correctamente");
		return "redirect:/movies/index";
	}
	
	@ModelAttribute("genders")
	public List<String> getGenders(){
		return serviceMovies.searchGenders();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
