package com.crm.crm_app.service;

// Importing the required classes
import com.crm.crm_app.dto.UserDTO;
import com.crm.crm_app.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * UserService Interface
 * 🔸 This defines the **contract** for user-related operations.
 * 🔸 The implementation will be provided by a class (e.g., UserServiceImpl).
 */
public interface UserService {

    /**
     * 🔹 Create a new user in the system.
     * @param userDTO - User data received from client
     * @return - Created user's data with database-generated ID
     */
    UserDTO createUser(UserDTO userDTO);

    /**
     * 🔹 Retrieve all users from the database.
     * @return - List of all users as DTOs
     */
    List<UserDTO> getAllUsers();

    /**
     * 🔹 Fetch a single user by their ID.
     * @param id - User's ID
     * @return - User details as DTO, or null if not found
     */
    UserDTO getUserById(Long id);

    /**
     * 🔹 Delete a user by their ID.
     * @param id - User's ID to delete
     */
    void deleteUserById(Long id);

    /**
     * 🔹 Get users in paginated format.
     * @param page - Page number (starting from 0)
     * @param size - Number of records per page
     * @return - Page of User entities
     */
    Page<User> getAllUsersPaginated(int page, int size);

    /**
     * 🔹 Get users with pagination and sorting.
     * @param page - Page number
     * @param size - Page size
     * @param sortBy - Field to sort by (e.g., "firstName")
     * @return - Page of sorted User entities
     */
    Page<User> getAllUsersPaginatedAndSorted(int page, int size, String sortBy);
}
