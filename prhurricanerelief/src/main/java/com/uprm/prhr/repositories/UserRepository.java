package com.uprm.prhr.repositories;

import com.uprm.prhr.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(@Param("name") String name);
    List<User> findByRegion(@Param("region") String region);
    List<User> findByRegionAndName(@Param("region") String region, @Param("name")  String name);
}
