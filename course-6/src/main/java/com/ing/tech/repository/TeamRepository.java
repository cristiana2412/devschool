package com.ing.tech.repository;

import com.ing.tech.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository  extends CrudRepository<Team,Long> {

}
