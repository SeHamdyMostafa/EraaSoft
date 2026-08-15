package com.spring.boot.springtasklec11.repo;

import com.spring.boot.springtasklec11.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
