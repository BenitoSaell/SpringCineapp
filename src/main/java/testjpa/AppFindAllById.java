package testjpa;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.News;
import net.itinajero.app.repository.NewsRepository;

public class AppFindAllById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo =  context.getBean("newsRepository",NewsRepository.class);
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(3);
		ids.add(5);
		ids.add(7);
		Iterable<News> listNews=repo.findAllById(ids);
		for(News news: listNews) {
			System.out.println("Noticia: "+news);
		}
		
		context.close();
	}

}
