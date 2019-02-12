package net.itinajero.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Detail;
import net.itinajero.app.repository.DetailsRepository;

@Service
public class DetailsServiceJPA implements IDetailsService{
	@Autowired
	private DetailsRepository detailsRepo;
	
	@Override
	public void insert(Detail detail) {
		detailsRepo.save(detail);
	}

	@Override
	public void delete(int idDetail) {
		detailsRepo.deleteById(idDetail);
		
	}

}
