package com.tps.user.repository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tps.user.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}