package com.example.socialnetwork.entity;

import com.example.socialnetwork.entity.enumClass.Gender;
import com.example.socialnetwork.entity.enumClass.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;


@Getter
@Setter
@Entity
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users", schema = "socal_network")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "middle_name")
    String middleName;

    @Column(name = "first_time_login")
    Timestamp first_time_login;

    @Column(name = "phone")
    String phoneNumber;

    @Column(name = "avatar")
    String avatar;

    @Column(name = "bio")
    String bio;

    @Column(name = "email")
    private String email;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(name = "github")
    String github;

    @Column(name = "birthday")
    Date dateBirthday;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(name = "technology")
    String technology;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    Role role;

    private Boolean locked = false;

    private Boolean enabled = false;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return middleName;
    }

    public String getEmail() {
        return email;
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
