package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import net.itinajero.app.model.Movie;

public interface IMoviesService {
	List<Movie> searchAll();
	//List<Movie> searchStatusAndDate(Date date);
	Movie searchByID(int idMovie);
	void insert(Movie movie);
	List<String> searchGenders();
	void delete(int idMovie);

}
