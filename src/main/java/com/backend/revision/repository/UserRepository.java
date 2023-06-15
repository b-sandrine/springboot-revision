package com.backend.revision.repository;

import com.backend.revision.models.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, List>{
	List<User> findByEmail(String email);
}
