package com.djellalifouad.restapirh.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.List;
@ToString
@Eager
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Departement {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false,length = 20)
    private String nom ;
    @OneToMany(mappedBy = "departement")
    @ToString.Exclude
    private List<Employee> employeeList;

}
