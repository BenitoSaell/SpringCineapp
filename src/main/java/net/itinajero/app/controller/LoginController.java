package net.itinajero.app.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="admin")
public class LoginController {
	
	@GetMapping("/index")
	public String showMainAdmin(HttpSession sessionMain, Principal principal) {
		String user = principal.getName();
		sessionMain.setAttribute("user", user);
		return "admin";
	}
	
	@GetMapping("/logout")
	private String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	

}
