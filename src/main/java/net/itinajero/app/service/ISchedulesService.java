package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import net.itinajero.app.model.Schedule;

public interface ISchedulesService {
	List<Schedule> searchAll();
	void insert(Schedule schedule);
	Schedule searchById(int idSchedule);
	void delete(int idSchedule);
	List<Schedule> searchByIdMovie(int idMovie, Date date);
}