package testjpa;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.News;
import net.itinajero.app.repository.NewsRepository;

public class AppRead {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo =  context.getBean("newsRepository",NewsRepository.class);
		Optional<News> news = repo.findById(1);
		System.out.println("Noticia guardada: "+ news.get());
		context.close();
	}
}
