package net.itinajero.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Banner;
import net.itinajero.app.repository.BannersRepository;

@Service
public class BannersServiceJPA implements IBannersService {
	@Autowired
	private BannersRepository bannersRepo;
	
	@Override
	public void insert(Banner banner) {
		bannersRepo.save(banner);
		
	}

	@Override
	public List<Banner> searchAll() {
		return bannersRepo.findAll();
	}

	@Override
	public Banner searchById(int idBanner) {
		Optional<Banner> optional = bannersRepo.findById(idBanner);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void delete(int idBanner) {
		bannersRepo.deleteById(idBanner);
	}
}
