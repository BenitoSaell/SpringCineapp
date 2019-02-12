package testRelations;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import net.itinajero.app.model.Schedule;
import net.itinajero.app.repository.SchedulesRepository;

public class AppRepoSchedules {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		SchedulesRepository repo =  context.getBean("schedulesRepository",SchedulesRepository.class);
		List<Schedule> schedules=repo.findAll();
		for(Schedule schedule: schedules) {
			System.out.println(schedule);
		}
		context.close();
	}

}
