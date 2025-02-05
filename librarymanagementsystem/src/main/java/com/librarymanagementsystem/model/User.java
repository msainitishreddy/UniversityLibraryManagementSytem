package com.librarymanagementsystem.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "university_id_generator")
    @SequenceGenerator(name = "university_id_generator", sequenceName = "university_id_seq", initialValue = 100000, allocationSize = 1)
    private Long univeristyId;

    private String name;

    private LocalDate dateOfBirth;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUniveristyId() {
        return univeristyId;
    }

    public void setUniveristyId(Long univeristyId) {
        this.univeristyId = univeristyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
