package com.app.ordenaly.repository;

import com.app.ordenaly.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  public List<User> findByEmail(String email);
  Optional<User> findByUsername(String username);
}


