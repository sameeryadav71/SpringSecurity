package com.web.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.web.domain.User;

/**
 * 
 * @author s.yadav
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
    User findByUserNameAndPassword(String userName, String password);
}