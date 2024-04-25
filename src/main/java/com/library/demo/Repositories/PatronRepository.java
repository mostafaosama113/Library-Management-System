package com.library.demo.Repositories;

import com.library.demo.Models.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepository extends JpaRepository<Patron , Long> {
}
