package com.login.LoginWebServices.repositories;

import com.login.LoginWebServices.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<User, Integer> {

    User findByEmailIdAndPassword(String email, String password);
}
