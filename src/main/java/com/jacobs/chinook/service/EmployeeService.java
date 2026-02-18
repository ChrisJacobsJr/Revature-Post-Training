package com.jacobs.chinook.service;

import com.jacobs.chinook.entity.Customer;
import com.jacobs.chinook.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Retrieves info about/related to employees
 */
@Service
public class EmployeeService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> listAssistedCustomers(Integer employeeId) {
        return customerRepository.getAssistedCustomers(employeeId);
    }


}
