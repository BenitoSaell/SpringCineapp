package testjpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.NewsRepository;

public class AppCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo =  context.getBean("newsRepository",NewsRepository.class);
		long count = repo.count();
		System.out.println("Numero de registros: "+ count);
		context.close();
	}

}
