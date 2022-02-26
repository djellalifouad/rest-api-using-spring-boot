package com.djellalifouad.restapirh;

import com.djellalifouad.restapirh.models.*;
import com.djellalifouad.restapirh.repositories.DepartmentRepository;
import com.djellalifouad.restapirh.repositories.EmployeeRepository;
import com.djellalifouad.restapirh.repositories.ProjetRepository;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class RestApiRhApplication implements CommandLineRunner {


    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProjetRepository projetRepository ;

    public static void main(String[] args) {
        SpringApplication.run(RestApiRhApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        // les adresses

        Adresse  address1  = new Adresse(1,"Oran","Miramar");
   Adresse  address2  = new Adresse(2,"Alger","Belle vue");
   Adresse  address3  = new Adresse(3,"Setif","Les palmiers");
   Adresse  address4  = new Adresse(4,"Constantine","el bahya");

        // les départements

   Departement departement1 = new Departement(null,"isi",null);
   Departement departement2 = new Departement(null,"siw",null);
   Departement departement3 = new Departement(null,"preparatoire",null);

         // les projets

   Projet projet1 = new Projet(null,"Site Ecommerce",20,null);
   Projet projet2 = new Projet(null,"Application e-sante",20,null);
   Projet projet3 = new Projet(null,"Arduino",20,null);

        // les employees;

   Employee employee1 = new Employee(
           null,
           "Djellali",
           Genre.Mr,
         Date.from(Instant.now()),
           "f.djellali@esi-sba.dz",
           departement1,
           address1,
           projet1);
        Employee employee2 = new Employee(
                null,
                "Hanani Fetheddine",
                Genre.Mr,
                Date.from(Instant.now()),
                "f.hanani@esi-sba.dz",
                departement2,
                address2,
                projet2);
        Employee employee3 = new Employee(
                null,
                "Hariri ali",
                Genre.Mr,
                Date.from(Instant.now()),
                "h.ali@gmail.com",
                departement3,
                address3,
                projet3);

        projetRepository.save(projet1);
        projetRepository.save(projet2);
        projetRepository.save(projet3);

        departmentRepository.save(departement1);
        departmentRepository.save(departement2);
        departmentRepository.save(departement3);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);

        System.out.println("liste des etudiants dans l'email  se termine avec @esi-sba.dz");
        employeeRepository.findEmployeeByEmailEndingWith("esi-sba.dz").forEach(System.out::println);
     int k = employeeRepository.getNbrEmployeeBuGenre("Mr");
        System.out.println("liste des projets et de de employee dans le departement isi");
     employeeRepository.findEmployeeByEmailEndingWith("isi").forEach(System.out::println);
    }
}
