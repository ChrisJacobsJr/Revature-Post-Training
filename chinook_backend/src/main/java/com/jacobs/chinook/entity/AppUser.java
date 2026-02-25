package com.jacobs.chinook.entity;

import com.jacobs.chinook.utils.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
//@Table(name = "User")
@Table(name = "\"User\"")
public class AppUser implements UserDetails {
    @Id
    @Column(name = "UserId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    @NotNull
    @Column(name = "Username", nullable = false, unique = true)
    private String username;

    @NonNull
    @NotNull
    @Column(name = "Password", nullable = false)
    private String password;

    @NonNull
    @NotNull
    @Column(name = "Role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "EmployeeId", referencedColumnName = "EmployeeId")
    private Employee employee;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

}

