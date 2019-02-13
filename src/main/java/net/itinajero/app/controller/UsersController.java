package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	public BCryptPasswordEncoder encoder;
	
	@GetMapping("/testBCrypt")
	public String testBCrypt() {
		String password = "mari123";
		String encriptado = encoder.encode(password);
		System.out.println("Password encryptado: "+ encriptado);
		return "users/demo";
	}
	
	

}
