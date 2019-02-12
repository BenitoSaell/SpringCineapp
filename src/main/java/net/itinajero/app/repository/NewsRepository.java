package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.News;

@Repository
//public interface NewsRepository extends CrudRepository<News, Integer> {
public interface NewsRepository extends JpaRepository<News, Integer> {
	
	//Select * from News where status=?
	List<News> findByStatus(String status);
	
	List<News> findByStatusOrderByDateDesc(String status);
	
	//Select * from News where date=?
	List<News> findByDate(Date date);
	
	//Select * from News where status=? and date=?
	List<News> findByStatusAndDate(String status,Date date);
	
	//Select * from News where status=? or date=?
	List<News> findByStatusOrDate(String status,Date date);
	
	//Select * from News where date between ? and ?
	List<News> findByDateBetween(Date start,Date end);
	
	//Select * from News where id between ? and ?
	List<News> findByIdBetween(int start,int end);
	
}
