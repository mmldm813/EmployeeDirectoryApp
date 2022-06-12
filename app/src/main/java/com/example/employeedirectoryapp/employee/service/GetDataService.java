package com.example.employeedirectoryapp.employee.service;

import com.example.employeedirectoryapp.employee.domain.model.EmployeeList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("sq-mobile-interview/employees.json")
    Call<EmployeeList> getEmployees();
}
