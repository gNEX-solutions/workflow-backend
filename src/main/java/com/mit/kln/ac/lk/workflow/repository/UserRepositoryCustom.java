package com.mit.kln.ac.lk.workflow.repository;

import com.mit.kln.ac.lk.workflow.model.User.User;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepositoryCustom {

    @Query(value = "SELECT * FROM users WHERE designation=?1 AND status=?2 ",nativeQuery = true)
    Optional<User> findInspectors(String designation, String userStatus);
}
