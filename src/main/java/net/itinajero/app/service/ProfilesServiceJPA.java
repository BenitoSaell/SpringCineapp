package net.itinajero.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Profile;
import net.itinajero.app.repository.ProfilesRepository;

@Service
public class ProfilesServiceJPA implements IProfilesService{
	@Autowired
	private ProfilesRepository profilesRepo;
	
	@Override
	public void save(Profile profile) {
		profilesRepo.save(profile);
		
	}

}
