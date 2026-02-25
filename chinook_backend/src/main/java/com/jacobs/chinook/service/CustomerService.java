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
 * Retrieves info about/related to customers. This class is NOT about the
 * customer use case, but rather the customer object itself.
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
     * @param customerId
     * @return a list of Track SpringBoot @Entity's
     */
    public List<Track> getOwnedTracks(Integer customerId) {
        // Data isn't particularly sensitive, so we'll skip the DTO and auth
        return trackRepository.getOwnedTracksByCustomerId(customerId);
    }

    /**
     * Returns a list of InvoiceLine entities for the purpose of viewing a given customer's purchases
     * @param customerId
     * @return a list of InvoiceLine @Entity's
     */
    public List<InvoiceLine> getCustomerPurchases(Integer customerId) {
        // try to make it so that either the owning customer or an employee can call this function
        List<InvoiceLine> purchases = invoiceLineRepository.getCustomerPurchases(customerId);
        // convert these into a DTO and save
        return null;
    }

    /**
     * Returns the total spending for a given customer
     * @param customerId
     * @return a double representing the total expenditure of a given customer
     */
    public double getCustomerTotalSpending(Integer customerId) {
        // add security such that only the owning customer or an employee can access this
        return invoiceLineRepository.getCustomerTotalSpending(customerId);
    }


}
