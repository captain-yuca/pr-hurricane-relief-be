package com.uprm.prhr.repositories;

import com.uprm.prhr.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(@Param("name") String name);
}