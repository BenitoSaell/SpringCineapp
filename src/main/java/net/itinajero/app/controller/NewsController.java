package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.News;
import net.itinajero.app.service.INewsService;

@Controller
@RequestMapping(value="/news")
public class NewsController {
	
	@Autowired
	private INewsService serviceNews; 
	
	@GetMapping("/index")
	public String showIndex(Model model) {
		model.addAttribute("listNews",serviceNews.searchAll());
		return "news/listNews";
	}
	
	
	@GetMapping(value="/create")
	public  String create(@ModelAttribute News news, Model model) {
		return "news/formNews";
	}
	
	@PostMapping(value="/save")
	public  String save(News news, RedirectAttributes attribute) {
		serviceNews.save(news);
		attribute.addFlashAttribute("message", "Noticia guardada.");
		return "redirect:/news/index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int idNews, Model model){
		model.addAttribute("news",serviceNews.searchById(idNews));
		return "news/formNews";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int idNews, RedirectAttributes attribute) {
		serviceNews.delete(idNews);
		attribute.addFlashAttribute("message", "La noticia fue borrada.");
		return "redirect:/news/index";
	}
}
