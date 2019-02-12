package net.itinajero.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import net.itinajero.app.model.Movie;

//@Service
public class MoviesServiceImpl implements IMoviesService{
	private List<Movie> movies= null;
	public MoviesServiceImpl() {
		System.out.println("Creando lista de peliculas");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		 
		try {
			movies = new LinkedList<>();
			Movie movie1 = new Movie();
			movie1.setId(1);
			movie1.setTitle("Power Rangers");
			movie1.setDuration(120);
			movie1.setClassification("B");
			movie1.setGender("Aventura");
			movie1.setReleaseDate(formatter.parse("02-05-2017"));
			
			Movie movie2 = new Movie();
			movie2.setId(2);
			movie2.setTitle("La bella y la bestia");
			movie2.setDuration(132);
			movie2.setClassification("A");
			movie2.setGender("Infantil");
			movie2.setImage("bella.jpg");
			movie2.setReleaseDate(formatter.parse("20-05-2017"));
			
			Movie movie3 = new Movie();
			movie3.setId(3);
			movie3.setTitle("Contratiempo");
			movie3.setDuration(106);
			movie3.setClassification("B");
			movie3.setGender("Thriller");
			movie3.setImage("contratiempo.jpg");
			movie3.setReleaseDate(formatter.parse("28-05-2017"));
			
			Movie movie4 = new Movie();
			movie4.setId(4);
			movie4.setTitle("It");
			movie4.setDuration(106);
			movie4.setClassification("B");
			movie4.setGender("Thriller");
			movie4.setImage("it.jpg");
			movie4.setStatus("Inactiva");
			movie4.setReleaseDate(formatter.parse("30-05-2017"));
			
			Movie movie5 = new Movie();
			movie5.setId(5);
			movie5.setTitle("Life: Vida inteligente");
			movie5.setDuration(104);
			movie5.setClassification("B");
			movie5.setGender("Drama");
			movie5.setImage("estreno5.png");
			movie5.setStatus("Activa");
			movie5.setReleaseDate(formatter.parse("10-06-2017"));
			
			movies.add(movie1);
			movies.add(movie2);
			movies.add(movie3);
			movies.add(movie4);
			movies.add(movie5);
		}catch(ParseException e) {
			System.out.println(e);
		}
	}
	
	@Override
	public List<Movie> searchAll() {
		return movies;
	}

	@Override
	public Movie searchByID(int idMovie) {
		for(Movie p: movies) {
			if(p.getId()==idMovie) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void insert(Movie movie) {
		movies.add(movie);
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
		
		
	}

	//@Override
	//public List<Movie> searchStatusAndDate(Date date) {
		// TODO Auto-generated method stub
		//return null;
	//}
	
}
