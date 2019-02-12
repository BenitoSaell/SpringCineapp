package testjpa;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.News;
import net.itinajero.app.repository.NewsRepository;

public class AppUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo =  context.getBean("newsRepository",NewsRepository.class);
		Optional<News> optional = repo.findById(9);
		if(optional.isPresent()) {
			News news = optional.get();
			System.out.println("Noticia guardada: "+ news);
			news.setStatus("Inactiva");
			repo.save(news);
		}
		
		context.close();

	}

}
