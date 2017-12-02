package com.uprm.prhr.repositories;

import com.uprm.prhr.models.Resource;
import com.uprm.prhr.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<User,Long> {
    User findByName(@Param("name") String name);
    List<User> findByRegion(@Param("region") String region);
    List<User> findByRegionAndName(@Param("region") String region, @Param("name")  String name);

}

