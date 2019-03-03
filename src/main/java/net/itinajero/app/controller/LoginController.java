package net.itinajero.app.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.realm.GenericPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="admin")
public class LoginController {
	
	@GetMapping("/index")
	public String showMainAdmin(HttpSession sessionMain, Principal principal) {
		GenericPrincipal generic = (GenericPrincipal) principal;
		if(sessionMain.getAttribute("user") == null) {
			for(String rol: generic.getRoles()) {
				System.out.println("Rol: "+ rol);
			}
			System.out.println("El usuario tiene rol editor: "+generic.hasRole("editor"));
			
			sessionMain.setAttribute("user", generic);
		}
		
		return "admin";
	}
	
	@GetMapping("/logout")
	private String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	

}
