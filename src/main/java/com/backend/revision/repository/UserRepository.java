package com.backend.revision.repository;

import com.backend.revision.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
