package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Schedule;

@Repository
public interface SchedulesRepository extends JpaRepository<Schedule, Integer> {
	List<Schedule> findByMovie_IdAndDateOrderByHour(int idMovie, Date date);
	@Query("select s from Schedule s where s.date = :date and movie.status='Activa' group by s.movie order by movie.id asc")
	List<Schedule> findByDate(@Param("date") Date date);
}
