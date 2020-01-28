package org.sid.scolariteservice.repository;

import java.util.List;


import org.sid.scolariteservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long>{

	@RestResource(path="/byName")
	public List<Student> findByNameContains(@Param(value="mc") String mc);
}
