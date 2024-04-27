package com.library.demo.Repositories;

import com.library.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserReposirtory extends JpaRepository<User,Long> {


    Optional<User> findByEmail(String email);
}
