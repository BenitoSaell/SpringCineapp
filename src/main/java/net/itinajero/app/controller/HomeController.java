package net.itinajero.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Banner;
import net.itinajero.app.model.Movie;
import net.itinajero.app.model.News;
import net.itinajero.app.model.Schedule;
import net.itinajero.app.service.IBannersService;
import net.itinajero.app.service.IMoviesService;
import net.itinajero.app.service.INewsService;
import net.itinajero.app.service.ISchedulesService;
import net.itinajero.app.util.utileria;

@Controller
public class HomeController {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
	private IBannersService serviceBanners;
	
	@Autowired 
	private INewsService serviceNews;
	
	@Autowired 
	private IMoviesService serviceMovies;
	
	@Autowired
	private ISchedulesService serviceSchedules;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam("dateF") Date dateF, Model model) {
		System.out.println("Fecha de busqueda "+dateF);
		try {
			Date date = dateFormat.parse(dateFormat.format(dateF));
			List<String> dateList = utileria.getNextDays(4);
			List <Movie> movies = serviceMovies.searchStatusAndDate(date);
			model.addAttribute("movies", movies);
			model.addAttribute("dateList", dateList);
			model.addAttribute("dateSearch", dateFormat.format(dateF));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "home";
		
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showMain(Model model) {
		try {
			Date date = dateFormat.parse(dateFormat.format(new Date()));
			List<String> dateList = utileria.getNextDays(4);
			List <Movie> movies = serviceMovies.searchStatusAndDate(date);
			List <Banner> banners = serviceBanners.searchAll();
			model.addAttribute("movies", movies);
			model.addAttribute("banners", banners);
			model.addAttribute("dateList", dateList);
			model.addAttribute("dateSearch", dateFormat.format(new Date()));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "home";
	}
	
	
	
	@RequestMapping(value="/detail/{id}/{date}", method=RequestMethod.GET)
	//@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String showDetail(Model model, @PathVariable("id") int idMovie, @PathVariable("date") Date date) {
		List<Schedule> schedules = serviceSchedules.searchByIdMovie(idMovie, date);
		Movie movie = serviceMovies.searchByID(idMovie);
		model.addAttribute("dateSearch", dateFormat.format(date));
		model.addAttribute("schedules", schedules);
		model.addAttribute("movie", movie);
		return "detail";
	}
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String showAbout(Model model) {
		return "about";
	}
	
	@ModelAttribute("listNews")
	public List<News> getListNews(){
		return serviceNews.searchNewsByStatusOrder();
	}
	
	@RequestMapping(value="/formLogin", method=RequestMethod.GET)
	public String showLogin() {
		return "formLogin";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
