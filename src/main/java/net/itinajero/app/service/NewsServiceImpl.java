package net.itinajero.app.service;

import java.util.List;

//import org.springframework.stereotype.Service;

import net.itinajero.app.model.News;

//@Service
public class NewsServiceImpl implements INewsService{
	
	public NewsServiceImpl() {
		System.out.println("Servicio NewsServiceImpl");
	}
	
	@Override
	public void save(News news) {
		System.out.println("Noticia "+ news);
	}

	@Override
	public List<News> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public News searchById(int idNews) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int idNews) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<News> searchNewsByStatusOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
