package com.crm.crm_app.dto;

// Lombok annotations to reduce boilerplate code
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;  // 🔹 Generates a constructor with all fields
import lombok.Data;               // 🔹 Generates getters, setters, toString(), equals(), and hashCode()
import lombok.NoArgsConstructor; // 🔹 Generates a no-argument constructor

/**
 * UserDTO - Data Transfer Object for User.
 * 🔸 Used to transfer user data between different layers (Controller <-> Service).
 * 🔸 Also used in API requests and responses, instead of exposing the entity directly.
 */
@Data  // ✅ Lombok: Automatically generates getters, setters, equals(), hashCode(), and toString()
@AllArgsConstructor  // ✅ Lombok: Creates a constructor with all fields (useful for manual object creation)
@NoArgsConstructor   // ✅ Lombok: Creates a default constructor with no parameters (useful for serialization/deserialization)
public class UserDTO {

    // 🔸 Unique ID of the user, usually generated by the database
    private Long id;

    // 🔸 First name of the user (e.g., "John")
    @NotNull(message = "First name cannot be null")
    private String firstName;

    // 🔸 Last name of the user (e.g., "Doe")
    private String lastName;

    // 🔸 Email address of the user (e.g., "john.doe@example.com")
    private String email;

    // 🔸 Phone number of the user (e.g., "+91-9876543210")
    private String phoneNumber;

    // 🔸 Optional notes about the user (e.g., "VIP customer")
    private String notes;

    // 🔸 Username for user login (e.g., "johndoe")
    private String username;

    // 🔸 Password for login (usually should be encrypted and never returned in API responses)
    private String password;

}
