package com.login.LoginWebServices.repositories;

import com.login.LoginWebServices.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer> {
     User findByEmailId(String email);
}
