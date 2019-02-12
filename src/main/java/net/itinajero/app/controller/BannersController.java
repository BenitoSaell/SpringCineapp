package net.itinajero.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Banner;
import net.itinajero.app.model.Movie;
import net.itinajero.app.service.IBannersService;
import net.itinajero.app.util.utileria;

@Controller
@RequestMapping("/banners")
public class BannersController {
	@Autowired
	IBannersService serviceBanners;
	
	@GetMapping("/index")
	public String showIndex(Model model) {
		model.addAttribute("banners", serviceBanners.searchAll());
		
		return "banners/listBanners";
	}

	@GetMapping("/create")
	public String create(@ModelAttribute Banner banner, Model model) {
		return "banners/formBanner";
	}
	
	@PostMapping(value = "/save")
	public String save(Banner banner, BindingResult result, RedirectAttributes attributes,
			@RequestParam("fileImage") MultipartFile multiPart, HttpServletRequest request) {
		if (!multiPart.isEmpty()) {
			String nameImage = utileria.saveImage(multiPart, request);
			banner.setFile(nameImage);
		}
		System.out.println("Banner:  "+ banner);
		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			return "banners/formBanner";

		}
		
		serviceBanners.insert(banner);
		attributes.addFlashAttribute("message","Registro guardado.");
		return "redirect:/banners/index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int idBanner, Model model) {
		model.addAttribute("banner", serviceBanners.searchById(idBanner));
		return "banners/formBanner";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int idBanner, RedirectAttributes attribute) {
		serviceBanners.delete(idBanner);
		attribute.addFlashAttribute("message","Bannner guardado.");
		return "redirect:/banners/index";
	}
}
