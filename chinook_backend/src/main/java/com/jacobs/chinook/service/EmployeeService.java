package com.jacobs.chinook.service;

import com.jacobs.chinook.entity.Customer;
import com.jacobs.chinook.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Retrieves info about/related to employees. This class is NOT about the
 * employee use case, but rather the employee object itself.
 * Also
 */
@Service
public class EmployeeService {
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Given an employee id, list all customers who have that employee as their service rep
     *
     * @param employeeId
     * @return
     */
    public List<Customer> listAssistedCustomers(Integer employeeId) {
        // TODO make sure to convert cust into a DTO
        Customer cust = customerRepository.getAssistedCustomers(employeeId);
        return null;
    }


}
