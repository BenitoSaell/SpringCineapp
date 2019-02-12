package testRelations;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Detail;
import net.itinajero.app.repository.DetailsRepository;

public class AppRepoDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		DetailsRepository repo =  context.getBean("detailsRepository",DetailsRepository.class);
		List<Detail> details=repo.findAll();
		for(Detail detail: details) {
			System.out.println(detail);
		}
		context.close();
	}

}
