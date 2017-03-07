package com.epsoft.webapps.iprofile.model.repository;

import com.epsoft.webapps.iprofile.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserReposytory extends JpaRepository<User, Long> {
     User findByEmail(String email);
}
