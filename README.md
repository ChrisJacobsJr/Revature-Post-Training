# Revature-Post-Training
This project is a post-training exercise to develop a full-stack java app (SpringBoot backend, Angular frontend)

## Notable Dependencies
### This spring boot project was initialized with:
Validation
Lombok
Spring Security
Spring Boot DevTools
Spring Web
Spring Data JPA

### Manually added:
JWT
SQLite

## Some things to note
### Annotations
You will see a lot of @NotNull and @NonNull annotations used.
With regards to this project, the NotNull are for jakarta validation, wheras the @NonNull are for
use with the @RequiredArgsConstructor annotation.
### Environment variables:
Currently using two:
- JWT_SECRET="your-secret-key-here"
- JWT_EXPIRATION="86400000" (one day)