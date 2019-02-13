package net.itinajero.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.User;
import net.itinajero.app.repository.UsersRepository;
@Service
public class UsersServiceJPA implements IUsersService {
	@Autowired
	private UsersRepository usersRepo;
	
	@Override
	public void save(User user) {
		usersRepo.save(user);
	}

}
