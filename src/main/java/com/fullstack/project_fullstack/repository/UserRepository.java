package com.fullstack.project_fullstack.repository;

import com.fullstack.project_fullstack.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<Object> findByAccountNumber(String sender);
    // Optional<User> findByAccountNumber(String AccountNumber);

    User findByEmail(String email);

}
