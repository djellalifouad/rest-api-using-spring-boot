package com.djellalifouad.restapirh;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Embeddable;
import java.io.Serializable;
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Data
public class Adresse  implements Serializable {
    private int numero;
    private String ville;
    private  String rue;
}
