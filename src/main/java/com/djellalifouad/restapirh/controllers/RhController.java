package com.djellalifouad.restapirh.controllers;
import com.djellalifouad.restapirh.forms.EmployeeForm;
import com.djellalifouad.restapirh.Departement;
import com.djellalifouad.restapirh.Employee;
import com.djellalifouad.restapirh.Projet;
import com.djellalifouad.restapirh.repositories.DepartmentRepository;
import com.djellalifouad.restapirh.repositories.EmployeeRepository;
import com.djellalifouad.restapirh.repositories.ProjetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rsu")
@RestController
public class RhController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
private ProjetRepository projetRepository;

    @PatchMapping("/employee/{id}")
    public Employee patchtEmployee( @RequestBody EmployeeForm employeeForm,@PathVariable("id") String id) {
        Departement departement = departmentRepository.getById(employeeForm.getDepartement_id());
        Projet projet = projetRepository.getById(employeeForm.getProjet_id());
        Employee e= employeeRepository.getById(Long.parseLong(id));
        e.setProjet(employeeForm.getProjet_id() != null ? projet : e.getProjet());
        e.setDepartement(employeeForm.getDepartement_id() != null ? departement : e.getDepartement());
        e.setEmail(employeeForm.getEmail() != null  ? employeeForm.getEmail() : e.getEmail());
        e.setGenre(employeeForm.getGenre() != null  ? employeeForm.getGenre() : e.getGenre());
        e.setDate_aumbauche(employeeForm.getDate_aumbauche() != null  ? employeeForm.getDate_aumbauche() : e.getDate_aumbauche() );
        e.setNom(employeeForm.getNom() != null  ? employeeForm.getNom() : e.getNom() );
        e.setAdresse(employeeForm.getAdresse() != null  ? employeeForm.getAdresse() : e.getAdresse() );
        return employeeRepository.save(e);
    }
    @PutMapping("/employee/{id}")
    public Employee putEmployee( @RequestBody EmployeeForm employeeForm,@PathVariable("id") String id) {
        Departement departement = departmentRepository.getById(employeeForm.getDepartement_id());
        Projet projet = projetRepository.getById(employeeForm.getProjet_id());
        Employee e= employeeRepository.getById(Long.parseLong(id));
        e.setProjet(projet);
        e.setDepartement(departement);
        e.setEmail(employeeForm.getEmail());
        e.setGenre(employeeForm.getGenre());
        e.setDate_aumbauche(employeeForm.getDate_aumbauche());
        e.setNom(employeeForm.getNom());
        e.setAdresse(employeeForm.getAdresse());
        return employeeRepository.save(e);
    }
    // a
    @GetMapping("/departement/employe-projet")
    public List<String> getEmployesWithDepName(@RequestParam("dn") String name) {
        return employeeRepository.findEmployeeWithDepName(name);
    } ;
    //b
    @PostMapping("/employe")
    public Employee addEmployee(@RequestParam("iddepart") String  iddep, @RequestBody EmployeeForm employeeForm) {
        System.out.println(employeeForm);
        Departement departement = departmentRepository.getById(Long.parseLong(iddep));
        Projet projet = projetRepository.getById(employeeForm.getProjet_id());
        Employee employee = new Employee(
                null,
                employeeForm.getNom(),
                employeeForm.getGenre(),
                employeeForm.getDate_aumbauche(),
                employeeForm.getEmail(),departement,employeeForm.getAdresse(),projet);
  Employee e = employeeRepository.save(employee);
  return e;
    }

@PostMapping("/employee2")
public Employee addEmployee( @RequestBody EmployeeForm employeeForm) {
        System.out.println(employeeForm.toString());
    Departement departement = departmentRepository.getById(employeeForm.getDepartement_id());
    Projet projet = projetRepository.getById(employeeForm.getProjet_id());
    Employee employee = new Employee(
            null,
            employeeForm.getNom(),
            employeeForm.getGenre(),
            employeeForm.getDate_aumbauche(),
            employeeForm.getEmail(),departement,employeeForm.getAdresse(),projet);
    employeeRepository.save(employee);
    return employee;
}
    @DeleteMapping("/projet/{idprojet}/{idemp}")
    public String deleteEmployeeFromProjet(@PathVariable("idprojet") String idprojet,@PathVariable("idemp") String idemp) {
        Employee e = employeeRepository.getById(Long.parseLong(idemp));
        if(e.getProjet().getId().toString().equals(idprojet)) {
            e.setProjet(null);
            employeeRepository.save(e);
            return "succes";
        }
        return "failed";
    }







    @PutMapping("/projet/{idprojet}/{idemp}")
    public String addEmployeetoProjet(@PathVariable("idprojet") String idprojet,@PathVariable("idemp") String idemp) {
    Employee e = employeeRepository.getById(Long.parseLong(idemp));
    Projet p = projetRepository.getById(Long.parseLong(idprojet));
    e.setProjet(p);
    employeeRepository.save(e);
    return "succes";
}
    @PostMapping("/employee")
    public String addEmployeetoDep(@RequestParam("iddepart") String iddepart,Employee employee) {
      Departement departement = departmentRepository.getById(Long.parseLong(iddepart));
      employee.setDepartement(departement);
        employeeRepository.save(employee);
        return "succes";
    }
}

