package com.crm.crm_app.model;  // Defines the package this class belongs to.

// Importing necessary annotations from Jakarta Persistence for JPA support.
import jakarta.persistence.*;
// Importing Lombok annotations for automatic generation of boilerplate code.
import lombok.Data;

@Entity  // Tells Spring Boot that this class will be mapped to a database table.
@Data    // Lombok automatically generates getters, setters, toString, equals, and hashCode methods.
@Table(name = "users")  // Specifies the table name to be "users" instead of the default "user".
public class User {

    @Id  // Marks this field as the primary key of the entity (table).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Automatically generates a unique ID for each new record in the database, using auto-increment.
    private Long id;

    private String firstName;    // First name of the user, this column will be part of the "users" table.
    private String lastName;     // Last name of the user.
    private String email;        // Email address of the user.
    private String phoneNumber;  // User's phone number.
    private String notes;        // Additional notes about the user.
    private String username;     // Username for login or authentication.
    private String password;     // Password for the user's account.
}
