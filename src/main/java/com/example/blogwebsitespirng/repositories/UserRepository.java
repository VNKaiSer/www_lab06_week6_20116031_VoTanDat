package com.example.blogwebsitespirng.repositories;
import com.example.blogwebsitespirng.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Long, User> {
}
