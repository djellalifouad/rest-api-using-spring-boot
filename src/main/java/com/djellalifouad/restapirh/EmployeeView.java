package com.djellalifouad.restapirh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "employeeView",
        types = Employee.class)
public interface EmployeeView {
    String getNom();
    @Value("#{target.departement.nom}")
    public String getDepartmentName();
}