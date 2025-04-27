package com.crm.crm_app.service;

// Importing required classes
import com.crm.crm_app.dto.UserDTO;
import com.crm.crm_app.model.User;
import com.crm.crm_app.repository.UserRepository;
import com.crm.crm_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation class of UserService interface
 * Annotated with @Service to mark it as a Spring service class
 */
@Service
public class UserServiceImpl implements UserService {

    // Inject UserRepository dependency so we can perform DB operations
    @Autowired
    private UserRepository userRepository;

    // Helper method to convert UserDTO (used in APIs) to User entity (used in DB)
    private User mapToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());  // Set ID
        user.setFirstName(userDTO.getFirstName());  // Set First Name
        user.setLastName(userDTO.getLastName());    // Set Last Name
        user.setEmail(userDTO.getEmail());          // Set Email
        user.setPhoneNumber(userDTO.getPhoneNumber()); // Set Phone
        user.setNotes(userDTO.getNotes());          // Set Notes
        user.setUsername(userDTO.getUsername());    // Set Username
        user.setPassword(userDTO.getPassword());    // Set Password
        return user;
    }

    // Helper method to convert User entity to UserDTO (to send to client)
    private UserDTO mapToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());                // Set ID
        userDTO.setFirstName(user.getFirstName());  // Set First Name
        userDTO.setLastName(user.getLastName());    // Set Last Name
        userDTO.setEmail(user.getEmail());          // Set Email
        userDTO.setPhoneNumber(user.getPhoneNumber()); // Set Phone
        userDTO.setNotes(user.getNotes());          // Set Notes
        userDTO.setUsername(user.getUsername());    // Set Username
        userDTO.setPassword(user.getPassword());    // Set Password
        return userDTO;
    }

    // Create a new user: Convert DTO to Entity -> Save to DB -> Convert Entity back to DTO
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = mapToEntity(userDTO);                // Convert to Entity
        User savedUser = userRepository.save(user);      // Save to DB
        return mapToDTO(savedUser);                      // Convert saved Entity to DTO
    }

    // Fetch all users from DB and convert each to DTO
    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();                 // Fetch all users
        return users.stream().map(this::mapToDTO)                    // Convert each user to DTO
                .collect(Collectors.toList());                 // Collect into a list
    }

    // Fetch a user by ID and return as DTO; throw exception if not found
    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)                      // Try to find user
                .orElseThrow(() -> new RuntimeException("User not found with id " + id)); // Throw if not found
        return mapToDTO(user);                                       // Convert to DTO
    }

    // Delete a user by ID
    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);                               // Delete from DB
    }

    // Fetch users with pagination
    @Override
    public Page<User> getAllUsersPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);              // Create page request
        return userRepository.findAll(pageable);                     // Fetch page from DB
    }

    // Fetch users with pagination and sorting by a specific field
    @Override
    public Page<User> getAllUsersPaginatedAndSorted(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending()); // Create sorted pageable
        return userRepository.findAll(pageable);                                       // Fetch sorted page from DB
    }
}
