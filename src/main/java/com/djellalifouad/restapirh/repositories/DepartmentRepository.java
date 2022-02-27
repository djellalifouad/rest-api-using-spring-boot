package com.djellalifouad.restapirh.repositories;

import com.djellalifouad.restapirh.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DepartmentRepository extends JpaRepository<Departement,Long> {
}
