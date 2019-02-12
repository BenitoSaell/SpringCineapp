package net.itinajero.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Schedule;
import net.itinajero.app.repository.SchedulesRepository;

@Service
public class SchedulesServiceJPA implements ISchedulesService {

	@Autowired
	SchedulesRepository schedulesRepo;
	
	@Override
	public List<Schedule> searchByIdMovie(int idMovie, Date date) {
		return schedulesRepo.findByMovie_IdAndDateOrderByHour(idMovie, date);
	}

	@Override
	public List<Schedule> searchAll() {
		return schedulesRepo.findAll();
	}

	@Override
	public void insert(Schedule schedule) {
		schedulesRepo.save(schedule);	
	}

	@Override
	public Schedule searchById(int idSchedule) {
		Optional<Schedule> optional = schedulesRepo.findById(idSchedule);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void delete(int idSchedule) {
		schedulesRepo.deleteById(idSchedule);
	}

}
