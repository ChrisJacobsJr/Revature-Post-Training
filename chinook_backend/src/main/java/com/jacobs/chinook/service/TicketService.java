package com.jacobs.chinook.service;

import com.jacobs.chinook.entity.*;
import com.jacobs.chinook.repository.CustomerRepository;
import com.jacobs.chinook.repository.MessageRepository;
import com.jacobs.chinook.repository.TicketRepository;
import com.jacobs.chinook.repository.UserRepository;
import com.jacobs.chinook.utils.AuthUtil;
import com.jacobs.chinook.utils.Role;
import com.jacobs.chinook.utils.TicketStatus;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

/**
 * Manipulates tickets and messages
 * Retrieves info about/related to tickets and messages
 *
 * Note: Use Spring Security if possible
 */
@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthUtil authUtil;

    @PreAuthorize("hasRole('CUSTOMER')")
    public Ticket createTicket() {

        AppUser appUser = authUtil.getAuthenticatedUser();

        // get customer and support rep who are associated with the user object
        Customer customer = appUser.getCustomer();

        if (customer == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No customer info associated with user");
        }

        Employee supportRep = customer.getSupportRep();

        if (supportRep == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No support rep assigned");
        }

        Ticket ticket = new Ticket(customer, supportRep);

        return ticketRepository.save(ticket);
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    public Ticket closeTicket(Integer ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found: " + ticketId));
        ticket.setStatus(TicketStatus.CLOSED);
        return ticket;
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    public Ticket openTicket(Integer ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found: " + ticketId));
        ticket.setStatus(TicketStatus.OPEN);
        return ticket;
    }

    public Message createMessage(Integer ticketId, String msg) {
        // todo ensure userId is valid for ticketId
        AppUser appUser = authUtil.getAuthenticatedUser();
        return null;
    }

    // TODO: instead of Ticket, return a DTO that holds conversation history
    // some_DTO getMessageInfo(userId, ticketId)
    public Ticket getMessageInfo(Integer ticketId) {
        AppUser appUser = authUtil.getAuthenticatedUser();
        return null;
    }

}
