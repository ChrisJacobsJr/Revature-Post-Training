#### As a rule, I'll avoid editing TODO entries once the day is over, aside from adding status notes like "(complete)."

### 2/15/2026
1. Make base repositories for all entities affected by MVP
   1. Make custom queries if and where it makes sense to (incomplete)
   2. Repositories: (partial completion)
      1. Track
         - List<Track> getOwnedTracksByCustomerId(customerId);
      2. Ticket 
      3. Message
      4. Customer
         - List<Customer> getAssistedCustomersByEmployeeId(employeeId);
      5. InvoiceLine
         - List<InvoiceLine> getCustomerPurchasesById(customerId)
      6. Invoice
         - int getCustomerTotalSpending(customerId)
2. Add a User entity (complete)
3. Set up JWT with Spring Security (presumably complete)

### 2/17/2026
1. Set up service class skeletons for MVP (complete)
2. Customer: (complete)
   - Given a customer, get all tracks the customer owns
     - Use TrackRepository getOwnedTracksByCustomerId(id)
   - Given a user (who is a customer), create & persist a Ticket object
     - Doable with basic TicketRepository functions
     - Check in the service to verify the user's role is customer

3. Employee: (complete)
   - Sales metrics: 
     - list customers who have been assisted (find by checking 'resolved' tickets)
     - Given a customer, find their purchases (organize by invoice, list prices) by their id
       - Unlike in the customer TODO, use InvoiceLineRepository's getCustomerPurchasesById(id)
     - List billing total
       - InvoiceRepository
   - Given a support ticket, close it
     - should be as simple as setting its status to closed and updating
4. Users: (complete)
   - Given a user & Ticket id, create a message, associate it with a Ticket & the user
       - Check to ensure that only the people in the Ticket can post messages to it
   - Given a ticket id, receive all messages, plus the Ticket object itself in one censored DTO
       - Again, check to ensure only involved persons can make this request
5. Start with custom SQL queries for repository actions (incomplete: didn't start)

### 2/18/2026
0. Implement Ticket and Message entities (completed)
   - uncomment Ticket and Message repositories (completed)
1. Implement service methods (partially completed)
   - Create relevant DTO's and have them returned by the service methods
   - Implement required repository methods
   - Including SQL queries 
2. Implement controllers (not completed)

### 2/19/2026
1. Refactor project such that there is a frontend and backend folder
   - do a quick convention check. I will be using Docker compose
2. Initialize Angular
3. Create views with dummy data

### 2/26/2026
1. finish repository
2. finish services
3. implement controllers
4. plan for tests




## New Database Tables & Entities
### User (Implemented)
Users are used to handle logging in as a customer or employer. They have:
- an id
- a username
- a hashed password
- a non-null ROLE (customer, employee, both)
- a nullable Customer foreign key
- a nullable Employee foreign key
### Ticket & Message
Implement a ticketing system:
- Messages table & Ticket table (organizes messages into ticket threads)
- Ticket records have an id, a customerId, employeeId, a status (open/closed), and a resolved flag.
  - Created by customers
- Message records have an Id, TicketId, SenderId (user), and text
  - Created by customers/employers
    - Can only do so if they are associated with the thread table, otherwise some 400 error.


## Client-side MVP
### Customer
Should be able to:
- See owned tracks with artist/album data shown
    - unowned tracks don't appear
- Create a support ticket, to the customer's assigned support employee.
    - See responses sent back by the employee
### Employee
Should be able to:
- See sales metrics in a dashboard:
    - What customers they assisted with sales (find by checking employee's resolved tickets for customer id)
    - "What tracks were purchased" (List of tracks purchased by customer)
        - (Consider organizing by Invoice, because the Invoice table has a total)
    - How much the customer was billed (Total of all invoices)
- See and respond to customer tickets