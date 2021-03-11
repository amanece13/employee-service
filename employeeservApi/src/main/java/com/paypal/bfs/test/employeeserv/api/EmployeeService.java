package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

import java.util.zip.DataFormatException;

/**
 * Interface for employee service operations.
 */
public interface EmployeeService {

    public Employee employeeGetById(String id);

    public Employee createEmployee( Employee employee) throws DataFormatException;
}
