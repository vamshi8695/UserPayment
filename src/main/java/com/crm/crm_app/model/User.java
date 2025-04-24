package com.crm.crm_app.model;  // The package this class belongs to.

import jakarta.persistence.*;
import lombok.Data;

@Entity  // This tells Spring Boot: "This class will create a table in the database."
@Data    // Lombok creates getters, setters, toString, equals, and hashCode automatically.
@Table(name = "users")  // Rename from "user" to "users"
public class User {

    @Id  // This marks 'id' as the Primary Key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Auto-generates the ID value for each record in the database.
    private Long id;

    private String firstName;    // First name of the user
    private String lastName;     // Last name of the user
    private String email;        // Email of the user
    private String phoneNumber;  // Phone number
    private String notes;        // Notes about the user
    private String username;     // Username for login
    private String password;     // Password for login
}
