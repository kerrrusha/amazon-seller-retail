package com.kerrrusha.amazonsellerretail.repository;

import com.kerrrusha.amazonsellerretail.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
