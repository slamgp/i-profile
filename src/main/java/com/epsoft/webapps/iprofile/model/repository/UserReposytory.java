package com.epsoft.webapps.iprofile.model.repository;

import com.epsoft.webapps.iprofile.model.person.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserReposytory extends CrudRepository<User, Long> {
  //  User findByEmail(String email);
}
