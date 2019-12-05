package com.ing.tech.repository;

import com.ing.tech.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
    public List<Person> findByTeamId(Long teamID);
}
