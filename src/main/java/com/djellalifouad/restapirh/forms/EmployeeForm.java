package com.djellalifouad.restapirh.forms;
import com.djellalifouad.restapirh.Adresse;
import com.djellalifouad.restapirh.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Collection;
import java.util.Date;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeForm {
    private String nom;
    private Genre genre;
    private Date date_aumbauche;
    private String email ;
    private Long departement_id ;
    private Collection<Adresse> adresse;
    private Long projet_id;
}
