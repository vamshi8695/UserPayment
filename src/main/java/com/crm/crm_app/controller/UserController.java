package com.crm.crm_app.controller;

// Importing required annotations and classes
import com.crm.crm_app.dto.UserDTO;
import com.crm.crm_app.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.crm.crm_app.model.User;
import org.springframework.data.domain.Page;

/**
 * This is the REST controller class.
 * It handles incoming HTTP requests and returns responses.
 */
@Slf4j
@RestController  // 🔹 This tells Spring this class is a REST controller.
@RequestMapping("/api/users")  // 🔹 This sets the base URL for all APIs in this controller.
public class UserController {

    @Autowired  // 🔹 Injects the service layer into the controller.
    private UserService userService;

    /**
     * Create a new user.
     * @param userDTO - user details sent from the client (JSON)
     * @return saved user with database-generated ID
     */
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    /**
     * Get all users from the database.
     * @return list of users
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    /**
     * Get a specific user by ID.
     * @param id - user's ID
     * @return User object if found, or null if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        if (userDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("WELCOME TO UserPayment APPLICATION");
        log.info("WELCOME TO TEST APPLICATION for git test");
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    /**
     * Delete a user by ID.
     * @param id - user's ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //pagination
    @GetMapping("/page")
    public Page<User> getAllUsersPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return userService.getAllUsersPaginated(page, size);
    }

    // GET /api/users/page?page=0&size=5&sortBy=firstName
    @GetMapping("/page/name")
    public ResponseEntity<Page<User>> getAllUsersPaginatedAndSorted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        Page<User> users = userService.getAllUsersPaginatedAndSorted(page, size, sortBy);

        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
