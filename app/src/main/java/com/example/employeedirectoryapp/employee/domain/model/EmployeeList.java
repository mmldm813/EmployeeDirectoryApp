package com.example.employeedirectoryapp.employee.domain.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class EmployeeList {

    @SerializedName("employees")
    private List<Employee> employees;

    private EmployeeList(List<Employee> employees) {
        this.employees = employees;
    }

    @Nullable
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
