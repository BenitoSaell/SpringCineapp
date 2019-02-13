package net.itinajero.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.itinajero.app.model.Profile;

public interface ProfilesRepository extends JpaRepository<Profile,Integer> {

}
