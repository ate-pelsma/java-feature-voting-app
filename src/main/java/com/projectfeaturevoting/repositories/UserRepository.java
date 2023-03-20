package com.projectfeaturevoting.repositories;

import com.projectfeaturevoting.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

// AMAZING INTERFACE THAT CAN RETURN A USER BY ITS USERNAME
// CAN RETURN ANYTHING TYPED AFTER findBy... AS LONG AS IT IS AN EXISTING PROPERTY
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
