package com.jacobs.chinook.service;

import com.jacobs.chinook.entity.InvoiceLine;
import com.jacobs.chinook.entity.Track;
import com.jacobs.chinook.repository.CustomerRepository;
import com.jacobs.chinook.repository.InvoiceLineRepository;
import com.jacobs.chinook.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Retrieves info about/related to customers
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TrackRepository trackRepository;
    @Autowired
    private InvoiceLineRepository invoiceLineRepository;

    /**
     * Returns a list of Track entities that a customer has a license for.
     * TODO: check to see if I should implement authentication here (through Spring Security) based on best practices
     * @param customerId
     * @return a list of Track SpringBoot @Entity's
     */
    public List<Track> getOwnedTracks(Integer customerId) {
        return trackRepository.getOwnedTracksByCustomerId(customerId);
    }

    /**
     * Returns a list of InvoiceLine entities for the purpose of viewing a given customer's purchases
     * TODO: see if authentication here would be best practice, or an unnecessary limitation
     * @param customerId
     * @return a list of InvoiceLine @Entity's
     */
    public List<InvoiceLine> getCustomerPurchases(Integer customerId) {
        return invoiceLineRepository.getCustomerPurchases(customerId);
    }

    /**
     * Returns the total spending for a given customer
     * TODO: see above
     * @param customerId
     * @return a double representing the total expenditure of a given customer
     */
    public double getCustomerTotalSpending(Integer customerId) {
        return invoiceLineRepository.getCustomerTotalSpending(customerId);
    }


}
