package testjpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.News;
import net.itinajero.app.repository.NewsRepository;

public class AppFindAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo =  context.getBean("newsRepository",NewsRepository.class);
		Iterable<News> it=repo.findAll();
		for(News n: it) {
			System.out.println("Noticia: "+ n);
		}
		context.close();
	}

}
