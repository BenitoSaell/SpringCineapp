package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Profile;
import net.itinajero.app.model.User;
import net.itinajero.app.service.IProfilesService;
import net.itinajero.app.service.IUsersService;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	public BCryptPasswordEncoder encoder;
	
	@Autowired
	private IUsersService serviceUsers;
	
	@Autowired 
	private IProfilesService serviceProfiles;
	
	@GetMapping("/index")
	public String index() {
		return "users/listUsers";
	}
	
	@GetMapping("/create")
	public String create(@ModelAttribute User user) {
		return "users/formUser";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute User user,@RequestParam("profile") String profile ,RedirectAttributes attribute) {
		System.out.println("Datos de usuario: "+ user + "   " + profile);
		String tmpPass = user.getPwd();
		String encriptado = encoder.encode(tmpPass);
		user.setPwd(encriptado);
		user.setActivo(1);
		serviceUsers.save(user);
		Profile profileTmp = new Profile();
		profileTmp.setUsername(user.getUsername());
		profileTmp.setProfile(profile);
		serviceProfiles.save(profileTmp);
		
		attribute.addFlashAttribute("message","Nuevo usuario registrado.");
		return "redirect:/users/index";
	}
	
	@GetMapping("/testBCrypt")
	public String testBCrypt() {
		String password = "mari123";
		String encriptado = encoder.encode(password);
		System.out.println("Password encryptado: "+ encriptado);
		return "users/demo";
	}
	
	
	
	

}
