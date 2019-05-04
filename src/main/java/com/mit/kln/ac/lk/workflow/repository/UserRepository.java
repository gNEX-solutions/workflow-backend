package com.mit.kln.ac.lk.workflow.repository;

import com.mit.kln.ac.lk.workflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> getUserById(String username);
    Optional<String> findByResetToken(String resetToken);
	User findByusername(String userName);
}
