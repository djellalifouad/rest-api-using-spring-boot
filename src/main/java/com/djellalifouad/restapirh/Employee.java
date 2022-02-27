package com.djellalifouad.restapirh;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Departement departement ;
    @ToString.Exclude
    @ElementCollection(fetch = FetchType.EAGER)    @CollectionTable( name="AdresseTable")
    private Collection<Adresse> adresse;
    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Projet projet;

}
