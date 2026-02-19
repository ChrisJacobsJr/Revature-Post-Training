package com.jacobs.chinook.service;

import com.jacobs.chinook.entity.Message;
import com.jacobs.chinook.entity.Ticket;
import com.jacobs.chinook.repository.CustomerRepository;
import com.jacobs.chinook.repository.MessageRepository;
import com.jacobs.chinook.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // TODO: Spring Security annotations for role control with some of these.
    Ticket createTicket(Integer userId, String issue) {
        // check to ensure user is a customer
        
        return null;
    }

    Ticket closeTicket(Integer userId, Integer ticketId) {
        // check to ensure that the user is an employee
        return null;
    }

    Ticket reopenTicket(Integer userId, Integer ticketId) {
        // check to ensure that the user is an employee
        return null;
    }

    Message createMessage(Integer userId, Integer ticketId, String msg) {
        return null;
    }
    // TODO: instead of Ticket, return a DTO that holds conversation history
    // some_DTO getMessageInfo(userId, ticketId)
    Ticket getMessageInfo(Integer userId, Integer ticketId) {
        return null;
    }

}
