package com.example.blogwebsitespirng.repositories;
import com.example.blogwebsitespirng.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByMobile(String mobile);

    boolean existsUserByEmail(String email);
    boolean existsUserByMobile(String mobile);

}
