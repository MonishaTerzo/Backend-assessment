package com.example.asses.demo.EmployeeDto;

import com.example.asses.demo.model.Users;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@Data
public class UserDto implements UserDetails {
    private long id;
    private String email;
    private String password;
    private String role;
    private List<GrantedAuthority> authorities;

    public UserDto(Users users) {
        this.id = users.getId();
        this.email = users.getEmail();
        this.password =users.getPassword();
        this.role = users.getRole();
        this.authorities = Arrays.asList(new SimpleGrantedAuthority(users.getRole()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}