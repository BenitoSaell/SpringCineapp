package testRelations;

import java.util.List;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Movie;
import net.itinajero.app.model.Schedule;
import net.itinajero.app.repository.MoviesRepository;
import net.itinajero.app.repository.SchedulesRepository;

public class AppGetSchedulesMovies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		MoviesRepository repo =  context.getBean("moviesRepository",MoviesRepository.class);
		Optional<Movie> movie=repo.findById(3);
		
		System.out.println(movie.get().getSchedules().size());
		
		context.close();
	}

}
