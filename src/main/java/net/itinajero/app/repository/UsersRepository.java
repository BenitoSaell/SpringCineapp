package net.itinajero.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.itinajero.app.model.User;

public interface UsersRepository extends JpaRepository<User,Integer> {

}
