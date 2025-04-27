package com.crm.crm_app.repository;  // Defines the package location for this class

// Import the User entity and Spring Data JPA classes
import com.crm.crm_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Marks this interface as a Spring-managed bean so it can be auto-wired that interacts with the database layer
public interface UserRepository extends JpaRepository<User, Long> {

    // This interface extends JpaRepository which provides built-in CRUD methods:
    // - save(entity)
    // - findById(id)
    // - findAll()
    // - deleteById(id)
    // - count(), existsById(), etc.

    // Custom query method to find a user by their username
    // Spring will auto-implement this method using the naming convention
    User findByUsername(String username);
}
