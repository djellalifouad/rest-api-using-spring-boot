package com.djellalifouad.restapirh.repositories;

import com.djellalifouad.restapirh.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjetRepository extends JpaRepository<Projet,Long> {
}
