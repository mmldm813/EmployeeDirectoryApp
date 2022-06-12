package com.example.employeedirectoryapp.employee.domain;

import com.example.employeedirectoryapp.employee.domain.model.Employee;
import com.example.employeedirectoryapp.employee.domain.model.EmployeeList;
import com.example.employeedirectoryapp.employee.service.GetDataService;
import com.example.employeedirectoryapp.employee.networking.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class EmployeeUseCase {

    public void getEmployeeList(Callback<EmployeeList> callback) {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<EmployeeList> call = service.getEmployees();
        call.enqueue(callback);
    }

    public boolean validateEmployeeList(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeName() == null || employee.getEmployeeTeam() == null
                    || employee.getSmallPicUrl() == null) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfEmployeeListEmpty(List<Employee> employeeList) {
        return employeeList.isEmpty();
    }
}