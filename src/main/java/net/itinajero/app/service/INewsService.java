package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.News;

public interface INewsService {
	List<News> searchAll();
	List<News> searchNewsByStatusOrder();
	News searchById(int idNews);
	void save(News news); 
	void delete(int idNews);
}
