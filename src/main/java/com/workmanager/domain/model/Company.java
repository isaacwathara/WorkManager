package com.workmanager.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

// Entité métier : une entreprise (en cours d'écriture).
@Entity
public class Company {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // constructeur
    protected Company() {}

    // constructeur pour enregistrer une nouvelle entreprise
    // (génère l'UUID et la date de création)
    public Company(String name, String description, String email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }

    //

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }


}
