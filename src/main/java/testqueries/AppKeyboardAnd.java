package testqueries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.News;
import net.itinajero.app.repository.NewsRepository;

public class AppKeyboardAnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo =  context.getBean("newsRepository",NewsRepository.class);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<News> list = null;
		try {
			list = repo.findByStatusAndDate("Activa",format.parse("2018-11-19"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(News news: list) {
			System.out.println(news);
		}
		context.close();
	}

}
