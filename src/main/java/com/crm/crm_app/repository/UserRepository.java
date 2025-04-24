package com.crm.crm_app.repository;  // Package location

import com.crm.crm_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Marks this as a Spring-managed component
public interface UserRepository extends JpaRepository<User, Long> {

    // JpaRepository provides built-in CRUD:
    // save(), findAll(), findById(), deleteById() etc.

    // You can also write custom queries, like:
    User findByUsername(String username);  // Custom method to find user by username.
}


