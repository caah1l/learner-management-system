package com.lmca.learnerService.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Learner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Email
    @Column(unique = true)
    private String emailId;

    @NotNull
    private LocalDate registeredDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull @Email String getEmailId() {
        return emailId;
    }

    public void setEmailId(@NotNull @Email String emailId) {
        this.emailId = emailId;
    }

    public @NotNull LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(@NotNull LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }
}
