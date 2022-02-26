package com.djellalifouad.restapirh.repositories;

import com.djellalifouad.restapirh.models.Employee;
import com.djellalifouad.restapirh.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;



@RepositoryRestResource
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {

    @Query(value = "select count(*) from Employee where Employee.genre = :genre",nativeQuery = true)
    int  getNbrEmployeeBuGenre(@Param("genre") String genre);
    @Query(value = "select concat('nom projet : ' ,Projet.nom,' ','id emp : ',Employee.id) from Projet,Employee,Departement where Departement.nom = :nom and Employee.projet_id = Projet.id and Employee.departement_id =Departement.id  ",nativeQuery = true)
    List<String> findEmployeeByEmailEndingWith(@Param("nom") String nom);



}
