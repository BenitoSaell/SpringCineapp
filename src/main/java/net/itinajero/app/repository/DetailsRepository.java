package net.itinajero.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.itinajero.app.model.Detail;

public interface DetailsRepository extends JpaRepository<Detail, Integer> {

}
