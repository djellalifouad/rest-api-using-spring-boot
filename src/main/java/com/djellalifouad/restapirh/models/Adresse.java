package com.djellalifouad.restapirh.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
@Eager
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Data
public class Adresse  implements Serializable {
    private int numero;
    private String ville;
    private  String rue;
}
