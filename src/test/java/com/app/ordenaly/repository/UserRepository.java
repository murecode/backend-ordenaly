package com.app.ordenaly.repository;

import com.app.ordenaly.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
