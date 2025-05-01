// Package location of this class
package com.crm.crm_app.controller;

// Importing Data Transfer Object (DTO) for user
import com.crm.crm_app.dto.UserDTO;

// Importing Entity class for user
import com.crm.crm_app.model.User;

// Importing the service layer that contains business logic
import com.crm.crm_app.service.UserService;

// Lombok annotation to enable logging (log.info, etc.)
import lombok.extern.slf4j.Slf4j;

// Spring annotations
import org.springframework.beans.factory.annotation.Autowired; // For dependency injection
import org.springframework.data.domain.Page;                  // For pagination support
import org.springframework.http.HttpStatus;                 // HTTP status codes
import org.springframework.http.ResponseEntity;             // Wrapper for HTTP responses
import org.springframework.web.bind.annotation.*;           // REST API annotations (GetMapping, PostMapping, etc.)

// Swagger/OpenAPI annotations for documentation
import io.swagger.v3.oas.annotations.Operation;             // Describes what the method does
import io.swagger.v3.oas.annotations.tags.Tag;              // Describes the class-level purpose
import io.swagger.v3.oas.annotations.responses.ApiResponse; // Describes possible API responses
import io.swagger.v3.oas.annotations.media.Content;         // Describes content type of responses
import io.swagger.v3.oas.annotations.media.Schema;          // Binds Swagger to your DTO class

import java.util.List;

// Describes this class as a group of user-related APIs in Swagger UI
@Tag(name = "User Management", description = "APIs for managing users")

// Enables logging in this class
@Slf4j

// Marks this class as a REST controller that handles HTTP requests
@RestController

// Sets the base URL for all endpoints in this controller
@RequestMapping("/api/users")
public class UserController {

    // Automatically injects the UserService bean into this controller
    @Autowired
    private UserService userService;

    // Documenting this method in Swagger with summary and possible responses
    @Operation(
            summary = "Create a new user",
            description = "Creates a user with the provided details",
            responses = {
                    @ApiResponse(responseCode = "201", description = "User created",
                            content = @Content(schema = @Schema(implementation = UserDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input")
            }
    )
    // Maps HTTP POST requests to /api/users to this method
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        // Call service method to save the user
        UserDTO createdUser = userService.createUser(userDTO);

        // Return the created user along with HTTP status 201 (Created)
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Swagger doc for getting all users
    @Operation(
            summary = "Get all users",
            description = "Fetches all users from the system",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Users found",
                            content = @Content(schema = @Schema(implementation = UserDTO.class))),
                    @ApiResponse(responseCode = "204", description = "No users found")
            }
    )
    // Maps HTTP GET requests to /api/users
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        // Call service method to get all users
        List<UserDTO> users = userService.getAllUsers();
log.info("hi stash check");
        // If no users found, return HTTP 204 (No Content)
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        // Otherwise, return the list with HTTP 200 (OK)
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Swagger doc for getting a user by ID
    @Operation(
            summary = "Get user by ID",
            description = "Fetches a user using their ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User found",
                            content = @Content(schema = @Schema(implementation = UserDTO.class))),
                    @ApiResponse(responseCode = "404", description = "User not found")
            }
    )
    // Maps HTTP GET requests to /api/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        // Call service method to fetch user by ID
        UserDTO userDTO = userService.getUserById(id);

        // If user not found, return HTTP 404 (Not Found)
        if (userDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Log message for debugging
        log.info("Returning user data for ID {}", id);

        // Return the user with HTTP 200 (OK)
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    // Swagger doc for deleting a user
    @Operation(
            summary = "Delete user by ID",
            description = "Deletes the user with the specified ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "User deleted"),
                    @ApiResponse(responseCode = "404", description = "User not found")
            }
    )
    // Maps HTTP DELETE requests to /api/users/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        // Call service method to delete user by ID
        userService.deleteUserById(id);

        // Return HTTP 204 (No Content) if deletion successful
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Swagger doc for basic pagination
    @Operation(
            summary = "Get users with pagination",
            description = "Returns a paginated list of users",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Page of users returned",
                            content = @Content(schema = @Schema(implementation = User.class)))
            }
    )
    // Maps GET request to /api/users/page with ?page=x&size=y
    @GetMapping("/page")
    public Page<User> getAllUsersPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        // Call service to fetch paginated results
        return userService.getAllUsersPaginated(page, size);
    }

    // Swagger doc for pagination with sorting
    @Operation(
            summary = "Get users with pagination and sorting",
            description = "Returns a sorted and paginated list of users",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Sorted page of users returned",
                            content = @Content(schema = @Schema(implementation = User.class))),
                    @ApiResponse(responseCode = "204", description = "No users found")
            }
    )
    // Maps GET request to /api/users/page/name with ?page=x&size=y&sortBy=fieldName
    @GetMapping("/page/name")
    public ResponseEntity<Page<User>> getAllUsersPaginatedAndSorted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        // Call service to fetch sorted and paginated users
        Page<User> users = userService.getAllUsersPaginatedAndSorted(page, size, sortBy);

        // If no users found, return HTTP 204
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        // Return the paginated users with HTTP 200
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
