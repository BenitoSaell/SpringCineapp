package net.itinajero.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.News;
import net.itinajero.app.repository.NewsRepository;

@Service
public class NewsServiceJPA implements INewsService{

	@Autowired
	private NewsRepository newsRepo; 
	
	@Override
	public List<News> searchAll() {
		return newsRepo.findAll(); 
	}

	@Override
	public News searchById(int idNews) {
		Optional<News> optional= newsRepo.findById(idNews);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void save(News news) {
		newsRepo.save(news);
	}

	@Override
	public void delete(int idNews) {
		newsRepo.deleteById(idNews);
	}

	@Override
	public List<News> searchNewsByStatusOrder() {
		// TODO Auto-generated method stub
		return newsRepo.findByStatusOrderByDateDesc("Activa");
	}

}
