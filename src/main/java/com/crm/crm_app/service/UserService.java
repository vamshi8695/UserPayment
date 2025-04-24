package com.crm.crm_app.service;

import com.crm.crm_app.dto.UserDTO;
import com.crm.crm_app.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

// Interface defines the service contract for User-related operations
public interface UserService {

    // Accepts UserDTO as input and returns the created UserDTO.
    UserDTO createUser(UserDTO userDTO);

    // Returns a list of all users in UserDTO form.
    List<UserDTO> getAllUsers();

    // Fetches one user based on ID and returns it as UserDTO.
    UserDTO getUserById(Long id);

    // Deletes a user by their ID.
    void deleteUserById(Long id);

    // pagination support
    Page<User> getAllUsersPaginated(int page, int size);

    // Sorting
    Page<User> getAllUsersPaginatedAndSorted(int page, int size, String sortBy);
}
