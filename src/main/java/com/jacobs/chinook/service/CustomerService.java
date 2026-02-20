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
     * TODO: check to see if I should implement authentication here (through Spring Security) based on best practices
     * @param customerId
     * @return a list of Track SpringBoot @Entity's
     */
    public List<Track> getOwnedTracks(Integer customerId) {
        List<Track> tracks = trackRepository.getOwnedTracksByCustomerId(customerId)
        return null;
    }

    /**
     * Returns a list of InvoiceLine entities for the purpose of viewing a given customer's purchases
     * TODO: see if authentication here would be best practice, or an unnecessary limitation
     * todo alternatively, make it so that the DTO changes depending on who the user is
     * @param customerId
     * @return a list of InvoiceLine @Entity's
     */
    public List<InvoiceLine> getCustomerPurchases(Integer customerId) {
        List<InvoiceLine> purchases = invoiceLineRepository.getCustomerPurchases(customerId);
        return null;
    }

    /**
     * Returns the total spending for a given customer
     * TODO: add an annotation so only employees can access this
     * @param customerId
     * @return a double representing the total expenditure of a given customer
     */
    public double getCustomerTotalSpending(Integer customerId) {
        return invoiceLineRepository.getCustomerTotalSpending(customerId);
    }


}
