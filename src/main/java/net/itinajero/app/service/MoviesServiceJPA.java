package net.itinajero.app.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Movie;
import net.itinajero.app.model.Schedule;
import net.itinajero.app.repository.MoviesRepository;
import net.itinajero.app.repository.SchedulesRepository;


@Service
public class MoviesServiceJPA implements IMoviesService{
	
	@Autowired
	private MoviesRepository moviesRepo;
	
	@Autowired
	private SchedulesRepository schedulesRepo;
	
	@Override
	public List<Movie> searchAll() {
		return moviesRepo.findAll();
	}

	@Override
	public Movie searchByID(int idMovie) {
		Optional<Movie> optional= moviesRepo.findById(idMovie);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void insert(Movie movie) {
		moviesRepo.save(movie);
		
	}

	@Override
	public List<String> searchGenders() {
		List<String> genders = new LinkedList<>();
		genders.add("Accion");
		genders.add("Aventura");
		genders.add("Accion y Aventura");
		genders.add("Clasica");
		genders.add("Ciencia ficcion");
		genders.add("Comedia Romantica");
		genders.add("Drama");
		genders.add("Infantil");
		genders.add("Romantica");
		genders.add("Terror");	
		
		return genders;
	}

	@Override
	public void delete(int idMovie) {
		moviesRepo.deleteById(idMovie);
	}

	//@Override
	//public List<Movie> searchStatusAndDate(Date date) {
		//return searchMovies(schedulesRepo.findByDate(date));
	//}
	
	private List<Movie> searchMovies(List<Schedule> schedules){
		List<Movie> movies = new LinkedList<>();
		
		for(Schedule schedule: schedules) {
			movies.add(schedule.getMovie());
		}
		return movies;
	}

}
