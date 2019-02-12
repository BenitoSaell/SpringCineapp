package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Banner;

public interface IBannersService {
	void insert(Banner banner); 
	List<Banner> searchAll();
	Banner searchById(int idBanner);
	void delete(int idBanner);
}
