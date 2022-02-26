package com.djellalifouad.restapirh.controllers;
import com.djellalifouad.restapirh.models.Departement;
import com.djellalifouad.restapirh.models.Employee;
import com.djellalifouad.restapirh.models.Projet;
import com.djellalifouad.restapirh.repositories.DepartmentRepository;
import com.djellalifouad.restapirh.repositories.EmployeeRepository;
import com.djellalifouad.restapirh.repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class RhController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
private ProjetRepository projetRepository;

@PostMapping("/employee2")
public Employee addEmployee(Employee employee) {
    employeeRepository.save(employee);
    return employee;
}
   @PatchMapping("/employee/{idemp}")
   public Employee patchEmployee(Employee employee,@PathVariable("idemp") String idemp) {
       Employee e1 = employeeRepository.getById(Long.parseLong(idemp));
       Employee e2 = employeeRepository.getById(Long.parseLong(idemp));
       e1 = employee;
       e1.setId(Long.parseLong(idemp));
       employeeRepository.save(employee);
       return e1;
   }
    // a
    @GetMapping("/departement/employe-projet")
    public List<String> getEmployesWithDepName(@RequestParam("name") String name) {
        return employeeRepository.findEmployeeWithDepName(name);
    } ;
    //b
    @PostMapping("/employe")
    public String addEmployee(@RequestParam("iddep") String  iddep,Employee employee) {
        Departement d = departmentRepository.getById(Long.parseLong(iddep));
        employee.setDepartement(d);
        employeeRepository.save(employee);
        return "success";
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
    Projet p = projetRepository.getById(Long.parseLong(idemp));
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

