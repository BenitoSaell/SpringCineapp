package net.itinajero.app.service;

import net.itinajero.app.model.Detail;

public interface IDetailsService {
	void insert(Detail detail);
	void delete(int idDetail);
}
