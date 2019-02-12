package net.itinajero.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Movie;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer> {

}
