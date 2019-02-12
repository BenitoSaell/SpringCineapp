package testRelations;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Movie;
import net.itinajero.app.repository.MoviesRepository;

public class AppFindAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		MoviesRepository repo =  context.getBean("moviesRepository",MoviesRepository.class);
		List<Movie> movies=repo.findAll();
		for(Movie movie: movies) {
			System.out.println(movie);
		}
		context.close();

	}

}
