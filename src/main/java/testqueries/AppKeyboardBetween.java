package testqueries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.News;
import net.itinajero.app.repository.NewsRepository;

public class AppKeyboardBetween {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo =  context.getBean("newsRepository",NewsRepository.class);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<News> list = null;
		//list = repo.findByDateBetween(format.parse("2018-11-15"),format.parse("2018-11-22"));
		list = repo.findByIdBetween(9,11);
		for(News news: list) {
			System.out.println(news);
		}
		context.close();

	}

}
