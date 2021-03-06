package com.example.germes.repo;

import com.example.germes.entity.Role;
import com.example.germes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

    List<User> findAllByRole(Role role);
}
