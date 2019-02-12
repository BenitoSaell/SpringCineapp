package testjpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.News;
import net.itinajero.app.repository.NewsRepository;

public class AppCreate {
	public static void main(String[] args) {
		News news = new News();
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo =  context.getBean("newsRepository",NewsRepository.class);
	
		news.setTitle("Noticia 1");
		news.setDetail("El proxime mes tendremos sorpresas");
		repo.save(news);
		context.close();
	}
}
