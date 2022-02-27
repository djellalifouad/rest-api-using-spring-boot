package com.djellalifouad.restapirh;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



import javax.persistence.*;
import java.util.Collection;
import java.util.List;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data

public class Departement {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false,length = 20)
    private String nom ;
    @ToString.Exclude
    @OneToMany(mappedBy = "departement",fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private Collection<Employee> employeeList;
}
