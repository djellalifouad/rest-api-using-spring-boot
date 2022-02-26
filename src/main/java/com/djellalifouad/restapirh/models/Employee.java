package com.djellalifouad.restapirh.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;
import javax.persistence.*;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Eager
@Entity
@ToString
@Data
public class Employee {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false,length = 20)
    private String nom;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private Date date_aumbauche;
    @Column(unique = true)
    private String email ;
    @ManyToOne(fetch = FetchType.LAZY)
    private Departement departement ;
    private Adresse adresse;
    @ManyToOne
    private Projet projet;
}
