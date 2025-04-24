package com.crm.crm_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserDTO - Data Transfer Object for User.
 * This class is used to transfer user data between layers
 * (for example: Controller -> Service) and for client requests/responses.
 */
@Data  // Lombok generates boilerplate code{getters, setters, toString(), equals(), and hashCode() methods}
@AllArgsConstructor  // Generates constructor with all fields
@NoArgsConstructor   // Generates no-argument constructor
public class UserDTO {

    private Long id;            // User ID
    private String firstName;   // User's First Name
    private String lastName;    // User's Last Name
    private String email;       // Email Address
    private String phoneNumber; // Phone Number
    private String notes;       // Notes about the user
    private String username;    // Login Username
    private String password;    // Login Password

}
