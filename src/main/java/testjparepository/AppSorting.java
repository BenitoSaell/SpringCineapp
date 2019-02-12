package testjparepository;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import net.itinajero.app.model.News;
import net.itinajero.app.repository.NewsRepository;

public class AppSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo =  context.getBean("newsRepository",NewsRepository.class);
		//List<News> listNews=repo.findAll(Sort.by("title").descending());
		
		List<News> listNews=repo.findAll(Sort.by("date").descending().and(Sort.by("title").ascending()));
		
		for(News news: listNews) {
			System.out.println("Noticia: "+news);
		}
		context.close();
	}

}
