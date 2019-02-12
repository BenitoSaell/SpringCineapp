package testjpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.NewsRepository;

public class AppDeleteAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo =  context.getBean("newsRepository",NewsRepository.class);
		repo.deleteAll();
		context.close();

	}

}
