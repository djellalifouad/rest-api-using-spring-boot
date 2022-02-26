package com.djellalifouad.restapirh.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Projet {
    @Id @GeneratedValue
    private Long id ;
    @Column(nullable = false,length = 20)
    private String nom;
    private int duree;
    @OneToMany(mappedBy = "id")
   private List<Employee> employee;
}
