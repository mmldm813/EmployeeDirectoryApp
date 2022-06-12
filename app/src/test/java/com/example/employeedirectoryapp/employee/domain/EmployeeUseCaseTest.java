package com.example.employeedirectoryapp.employee.domain;

import com.example.employeedirectoryapp.employee.domain.model.Employee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUseCaseTest {

    private EmployeeUseCase useCase;

    @Before
    public void setup() {
        useCase = new EmployeeUseCase();
    }

    @Test
    public void testSuccessfulEmployeeValidation() {
        // GIVEN
        List<Employee> validEmployeeList = new ArrayList<>();
        Employee employee = new Employee(
                "0d8fcc12-4d0c-425c-8355-390b312b909c",
                "Justine Mason",
                "5553280123",
                "https://s3.amazonaws.com/sq-mobile-interview/photos/16c00560-6dd3-4af4-97a6-d4754e7f2394/small.jpg",
                "Point of Sale");
        validEmployeeList.add(employee);

        // WHEN
        boolean result = useCase.validateEmployeeList(validEmployeeList);

        // THEN
        Assert.assertTrue(result);
    }

    @Test
    public void testMalformedEmployeeValidation() {
        // GIVEN
        List<Employee> validEmployeeList = new ArrayList<>();
        Employee employee = new Employee(
                "0d8fcc12-4d0c-425c-8355-390b312b909c",
                null,
                "5553280123",
                "https://s3.amazonaws.com/sq-mobile-interview/photos/16c00560-6dd3-4af4-97a6-d4754e7f2394/small.jpg",
                "Point of Sale");
        validEmployeeList.add(employee);

        // WHEN
        boolean result = useCase.validateEmployeeList(validEmployeeList);

        // THEN
        Assert.assertFalse(result);
    }

    @Test
    public void testIfNotEmptyEmployeeListIsEmpty() {
        // GIVEN
        List<Employee> validEmployeeList = new ArrayList<>();
        Employee employee = new Employee(
                "0d8fcc12-4d0c-425c-8355-390b312b909c",
                "Justine Mason",
                "5553280123",
                "https://s3.amazonaws.com/sq-mobile-interview/photos/16c00560-6dd3-4af4-97a6-d4754e7f2394/small.jpg",
                "Point of Sale");
        validEmployeeList.add(employee);

        // WHEN
        boolean result = useCase.checkIfEmployeeListEmpty(validEmployeeList);

        // THEN
        Assert.assertFalse(result);
    }

    @Test
    public void testIfEmptyEmployeeListIsEmpty() {
        // GIVEN
        List<Employee> validEmployeeList = new ArrayList<>();

        // WHEN
        boolean result = useCase.checkIfEmployeeListEmpty(validEmployeeList);

        // THEN
        Assert.assertTrue(result);
    }
}
