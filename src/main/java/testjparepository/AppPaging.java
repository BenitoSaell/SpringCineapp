package testjparepository;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import net.itinajero.app.model.News;
import net.itinajero.app.repository.NewsRepository;

public class AppPaging {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo =  context.getBean("newsRepository",NewsRepository.class);
		
		Page<News> listNews=repo.findAll(PageRequest.of(0, 2, Sort.by("title")));
		
		for(News news: listNews) {
			System.out.println("Noticia: "+news);
		}
		context.close();
	}

}
